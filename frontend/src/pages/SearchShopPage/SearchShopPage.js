import { useState, useEffect, useCallback } from 'react';

import axios from 'axios';

import './SearchShopPage.scoped.css'
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import SearchCard from '../../components/SearchCard/SearchCard';
import SearchShopMap from '../../components/SearchShopMap/SearchShopMap';

import Grid from '@mui/material/Grid';

import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const SearchShopPage = () => {

  const [region, setRegion] = useState('')
  const [animal, setAnimal] = useState('')
  const [cafeList, setCafeList] = useState([])
  
  useEffect(() => {
    axios.get('http://i9a105.p.ssafy.io:8080/api/shop')
      .then(function(res) {
        setCafeList(res.data.slice(0, 9))
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [])

  const handleAnimalChange = (e) => {
    setAnimal(e.target.value)
  }

  const onChangeSearch = useCallback((e) => {
    const newValue = e.target.value;
    setRegion(newValue);
  }, []);

  const searchResult = (place) => {
    if (place.trim() === "") return;

    axios.get(`/api/shop/address/${place}`)
      .then(function(res) {
        const newCafeList = res.data.map(el => ({ ...el })); // 새로운 배열 생성
        setCafeList(newCafeList);
        setRegion("")
      })
      .catch(function(err) {
        console.log(err)
      })
  }

  const handleRegionSearchClick = useCallback(() => {
    searchResult(region);
  }, [region]);
   
  return (
    <div className='SearchShop'>
      <Header />
      <div className="header-save"/>
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <div className='search-wrapper'>
            <div className='region-input'>
              <input value={region} onChange={onChangeSearch}/>
              <button onClick={handleRegionSearchClick}>검색</button>
            </div>
              <FormControl sx={{ m: 1, minWidth: 120 }} size="small">
                <InputLabel id="select-animal-label">Animal</InputLabel>
                <Select
                  labelId="select-animal-label"
                  id="select-animal"
                  value={animal}
                  label="Animal"
                  onChange={handleAnimalChange}
                >
                  <MenuItem value={'강아지'}>강아지</MenuItem>
                  <MenuItem value={'고양이'}>고양이</MenuItem>
                  <MenuItem value={'기타'}>기타</MenuItem>
                </Select>
              </FormControl>
            </div>
          <div className='list-wrapper'>
            {
              cafeList.map((el) => 
                <SearchCard key={el.shopId} {...el} />
              )
            }
          </div>
        </Grid>
        <Grid item xs={6}>
          <SearchShopMap cafeList={cafeList}/>
        </Grid>
      </Grid>
      <div className="footer-save"/>
      <Footer />
    </div>
  );
}

export default SearchShopPage;