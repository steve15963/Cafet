import React, { useEffect } from "react";

const { kakao } = window;

const KakaoMap = ({ latitude, longitude }) => {
  console.log(latitude);
  console.log(longitude);

  useEffect(() => {
    const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
    const options = {
      //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(37.544293, 127.076089), //지도의 중심좌표.
      // center: new kakao.maps.LatLng(latitude, longitude), //지도의 중심좌표.
      level: 3, //지도의 레벨(확대, 축소 정도)
    };

    //eslint-disable-next-line
    const map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    // 마커가 표시될 위치입니다
    const markerPosition = new kakao.maps.LatLng(37.544293, 127.076089);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      position: markerPosition,
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
  }, []);

  return (
    <div>
      <div id="map" style={{ width: "800px", height: "420px" }} />
    </div>
  );
};

export default KakaoMap;
