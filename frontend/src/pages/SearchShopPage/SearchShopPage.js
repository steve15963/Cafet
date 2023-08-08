import { useState } from 'react';
import { Map } from 'react-kakao-maps-sdk';

import axios from 'axios';

// import useGeolocation from 'react-hook-geolocation';

import './SearchShopPage.scoped.css'
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import SearchCard from '../../components/SearchCard/SearchCard';

import Grid from '@mui/material/Grid';


// const { kakao } = window;

// const mockData = [
//   {
//     id: 0,
//     shop: '고양이 다락방',
//     lat: 37.555970,
//     lng: 126.923110,
//     petClassify: '고양이',
//   },
//   {
//     id: 1,
//     shop: '포포앤미루',
//     lat: 37.525396,
//     lng: 127.134214,
//     petClassify: '강아지',
//   },
// ]

const SearchShopPage = () => {

  // const [animal, setAnimal] = useState('')
  const [region, setRegion] = useState('')
  const [cafeList, setCafeList] = useState([])

  const onChangeSearch = (e) => {
    setRegion(e.target.value)
  }

  const searchResult = (place) => {
    axios.get(`http://i9a105.p.ssafy.io:8080/api/shop/address/${place}`)
      .then(function(res) {
        setCafeList(res.data)
        setRegion("")
      })
      .catch(function(err) {
        console.log(err)
      })
  }
  console.log('cafeList :', cafeList)

  // useEffect(() => {
  //   let container = document.getElementById("map");
  //   let options = {
  //     center: new kakao.maps.LatLng(37.544293, 127.076089),
  //     level: 7,
  //   };

  //   //map
  //   const map = new kakao.maps.Map(container, options);
    
  //   mockData.forEach((el) => {
  //     // 마커 생성
  //     new kakao.maps.Marker({
  //       //마커가 표시 될 지도
  //       map: map,
  //       //마커가 표시 될 위치
  //       position: new kakao.maps.LatLng(el.lat, el.lng),
  //       //마커에 hover시 나타날 title
  //       title: el.shop,
  //     });
  //   });
  // }, []);

  // const moveCenter = () => {
  //   let moveLatLon = new kakao.maps.LatLng(geolocation.latitude, geolocation.longitude);
  //   // map.setCenter(moveLatLon)
  // }
  return (
    <div className='SearchShop'>
      <Header />
      <div className="header-save"/>
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <div className='search-wrapper'>
            <div className='region-input'>
              <input value={region} onChange={onChangeSearch}/>
              <button onClick={() => {searchResult(region)}}>검색</button>
            </div>
          </div>
          <div className='list-wrapper'>
            {
              cafeList.map((el) => 
                <SearchCard {...el} />
              )
            }
          </div>
        </Grid>
        <Grid item xs={6}>
        <Map // 지도를 표시할 Container
          center={{
            // 지도의 중심좌표
            lat: 33.450701,
            lng: 126.570667,
          }}
          style={{
            // 지도의 크기
            width: "100%",
            height: "450px",
          }}
          level={3} // 지도의 확대 레벨
        />
        </Grid>
      </Grid>
      <div className="footer-save"/>
      <Footer />
    </div>
  );
}

export default SearchShopPage;