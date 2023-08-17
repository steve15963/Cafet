import { useState, useEffect, useCallback } from "react";
import axios from "axios";

import "./SearchShopPage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import SearchCard from "../../components/SearchCard/SearchCard";
import SearchShopMap from "../../components/SearchShopMap/SearchShopMap";

import Grid from "@mui/material/Grid";

const SearchShopPage = () => {

  const [region, setRegion] = useState("");
  const [cafeList, setCafeList] = useState([]);

  useEffect(() => {
    axios.get('https://i9a105.p.ssafy.io/api/shop')
      .then(function(res) {
        setCafeList(res.data.slice(0, 9))
      })
      .catch(function (err) {
        console.log(err);
        alert('검색결과가 없습니다')
        setRegion("")
      });
  }, []);

  const onChangeSearch = useCallback((e) => {
    const newValue = e.target.value;
    setRegion(newValue);
  }, []);

  const searchResult = (place) => {
    if (place.trim() === "") return;

    axios
      .get(`/api/shop/address/${place}`)
      .then(function (res) {
        const newCafeList = res.data.map((el) => ({ ...el })); // 새로운 배열 생성
        setCafeList(newCafeList);
        setRegion("");
      })
      .catch(function (err) {
        console.log(err);
      });
  };

  const handleRegionSearchClick = useCallback(() => {
    searchResult(region);
    let keyword = document.getElementById("searchValue").value;
    console.log("keyword : "  + keyword);
    axios.get(`https://i9a105.p.ssafy.io/api/shop/address/${keyword}`)
      .then(function(res) {
        console.log(res);
        setCafeList(res.data.slice(0, 9))
        
      })
      .catch(function (err) {
        console.log(err);
        alert('검색결과가 없습니다')
        setRegion("")
      });
  }, [region]);
  

  return (
    <div className="SearchShop">
      <Header />
      <div className="header-save" />
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <div className="search-wrapper">
            <div className="region-input">
              <input id="searchValue" value={region} onChange={onChangeSearch} />
              <button onClick={handleRegionSearchClick}>검색</button>
            </div>
          </div>
          <div className="list-wrapper">
            {cafeList.map((el) => (
              <SearchCard key={el.shopId} {...el} />
            ))}
          </div>
        </Grid>
        <Grid item xs={6}>
          <SearchShopMap cafeList={cafeList} />
        </Grid>
      </Grid>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default SearchShopPage;
