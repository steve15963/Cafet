import React, { useEffect } from "react";

const { kakao } = window;

mockData = [
  {
    id: 0,
    shop: '고양이 다락방',
    latitude: 37.555970,
    longitude: 126.923110,
    petClassify: '고양이',
  },
  {
    id: 1,
    shop: '포포앤미루',
    latitude: 37.525396,
    longitude: 127.134214,
    petClassify: '강아지',
  },
]


const KakaoMap = () => {
  useEffect(() => {
    const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    const options = { //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(37.566840, 126.978346), //지도의 중심좌표.
      level: 3 //지도의 레벨(확대, 축소 정도)
    };
  
    const map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  }, [])

  return(
    <div>
      <div id="map" style={{ width: '100%', height: '100%' }} />
    </div>
  );
};

export default KakaoMap;