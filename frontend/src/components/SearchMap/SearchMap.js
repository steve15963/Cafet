import React, { useEffect } from "react";

const { kakao } = window;

const mockData = [
  {
    id: 0,
    shop: '고양이 다락방',
    lat: 37.555970,
    lng: 126.923110,
    petClassify: '고양이',
  },
  {
    id: 1,
    shop: '포포앤미루',
    lat: 37.525396,
    lng: 127.134214,
    petClassify: '강아지',
  },
]
const SearchMap = () => {
  useEffect(() => {
    let container = document.getElementById("map");
    let options = {
      center: new kakao.maps.LatLng(37.544293, 127.076089),
      level: 7,
    };

    //map
    const map = new kakao.maps.Map(container, options);
    
    mockData.forEach((el) => {
      // 마커 생성
      new kakao.maps.Marker({
        //마커가 표시 될 지도
        map: map,
        //마커가 표시 될 위치
        position: new kakao.maps.LatLng(el.lat, el.lng),
        //마커에 hover시 나타날 title
        title: el.shop,
      });
    });
  }, []);

  return <div id="map" style={{ width: "100vw", height: "100vh" }}></div>;
};

export default SearchMap;