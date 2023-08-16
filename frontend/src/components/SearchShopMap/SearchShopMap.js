import { useEffect, useRef } from "react"
import { useNavigate } from "react-router-dom";

const { kakao } = window;

const SearchShopMap = ({ cafeList }) => {
  const mapRef = useRef()
  const navigate = useNavigate();

  useEffect(() => {
    const container = document.getElementById('map') // 지도를 표시할 div 
    const option = { 
        center: new kakao.maps.LatLng(37.450701, 126.570667), // 지도의 중심좌표
        level: 14 // 지도의 확대 레벨
    };
    mapRef.current =  new kakao.maps.Map(container, option)
  }, [])

  useEffect(() => {
    const overlay = cafeList?.map((el) => {
      return {
        id: el.shopId,
        title: el.shopTitle,
        address: el.address,
        phoneNo: el.phoneNo,
        lat: el.latitude,
        lng: el.longitude,
      }
    })
    overlay.forEach(el => {
      let marker = new kakao.maps.Marker({
                    map: mapRef.current,
                    position: new kakao.maps.LatLng(el.lat, el.lng),
                  });
      let content = 
      '<div class="wrap">' + 
      '    <div class="info">' + 
      '        <div class="title">' + 
      `            ${el.title}` + 
      '        </div>' + 
      '        <div class="body">' + 
      '            <div class="img">' +
      '           </div>' + 
      '            <div class="desc">' + 
      `                <div class="ellipsis">${el.address}</div>` +
      `                <div class="ellipsis">${el.phoneNo}</div>` +
      '            </div>' + 
      '        </div>' + 
      '    </div>' +    
      '</div>';
      
       

      let position = new kakao.maps.LatLng(el.lat, el.lng)
      let custom = new kakao.maps.CustomOverlay({
        position: position,
        content: content,
      });
      
      kakao.maps.event.addListener(marker, 'mouseover', function () {
        custom.setMap(mapRef.current);
      });

      // 마커에 마우스아웃 이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'mouseout', function () {
        setTimeout(function () {
          custom.setMap(null);
        })
      });
      // 클릭 시 해당 shop으로 이동
      kakao.maps.event.addListener(marker, 'click', function () {
        navigate(`/shop/${el.id}`)
      });
    })  
  }, [cafeList, navigate])

  
  return (
    <div>
      <div
        id="map"
        style={{
          width: '100%',
          height: '500px',
        }}
      />
      <style>
        {`
              .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
              .wrap * {padding: 0;margin: 0;}
              .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
              .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
              .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
              .info .body {position: relative;overflow: hidden;}
              .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
              .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
              .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
              .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
              .info .link {color: #5085BB;}
        `}
      </style>
    </div>
  )
}

export default SearchShopMap