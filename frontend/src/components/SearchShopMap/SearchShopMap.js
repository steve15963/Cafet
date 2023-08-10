import { useEffect, useRef } from "react"

const { kakao } = window;

const SearchShopMap = ({ cafeList }) => {
  const mapRef = useRef()

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
      let content = '<div class="wrap">' + 
                              '<div class="info">' + 
                              '<div class="title">' + 
                              `${el.title}` + 
                              '</div>' + 
                              '<div class="body">' +          
                              `<div class="ellipsis">${el.address}</div>` + 
                              '</div>' + 
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
          custom.setMap();
        })
      });
    })  
  }, [cafeList])

  
  return (
    <div
      id="map"
      style={{
        width: '100%',
        height: '100%',
      }}
    />
  )
}

export default SearchShopMap