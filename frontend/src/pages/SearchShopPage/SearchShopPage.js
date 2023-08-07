import { useState, useEffect } from 'react';

import './SearchShopPage.scoped.css'
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const SearchShop = () => {
  const [animal, setAnimal] = useState('')
  const [region, setRegion] = useState('')

  const handleChangeAnimal = (event) => {
    setAnimal(event.target.value);
  };

  const handleChangeRegion = (event) => {
    setRegion(event.target.value);
  };

  // useEffect(()=> {

  // }, [])
  return (
    <div className='SearchShop'>
      <Header />
      <div className="header-save"/>
      <div>
        <div className='search-container'>
          <FormControl sx={{ m: 1, minWidth: 120 }}>
            <InputLabel id="selector-region-label">Region</InputLabel>
            <Select
              labelId="selector-region-label"
              id="selector-region"
              value={region}
              label="Region"
              onChange={handleChangeRegion}
            >
              <MenuItem value={'서울'}>서울</MenuItem>
              <MenuItem value={'경기'}>경기</MenuItem>
              <MenuItem value={'강원'}>강원</MenuItem>
              <MenuItem value={'충청'}>충청</MenuItem>
              <MenuItem value={'전라'}>전라</MenuItem>
              <MenuItem value={'경상'}>경상</MenuItem>
              <MenuItem value={'인천'}>인천</MenuItem>
              <MenuItem value={'울산'}>울산</MenuItem>
              <MenuItem value={'대전'}>대전</MenuItem>
              <MenuItem value={'광주'}>광주</MenuItem>
              <MenuItem value={'대구'}>대구</MenuItem>
              <MenuItem value={'부산'}>부산</MenuItem>
              <MenuItem value={'세종'}>세종</MenuItem>
              <MenuItem value={'제주'}>제주</MenuItem>
            </Select>
          </FormControl>
          <FormControl sx={{ m: 1, minWidth: 120 }}>
            <InputLabel id="selector-animal-label">Animal</InputLabel>
            <Select
              labelId="selector-animal-label"
              id="selector-animal"
              value={animal}
              label="Animal"
              onChange={handleChangeAnimal}
            >
              <MenuItem value={'전체'}>전체</MenuItem>
              <MenuItem value={'강아지'}>강아지</MenuItem>
              <MenuItem value={'고양이'}>고양이</MenuItem>
              <MenuItem value={'기타'}>기타</MenuItem>
            </Select>
          </FormControl>
        </div>
        <div className="map-container">
      </div>
      </div>
      <div className="footer-save"/>
      <Footer />
    </div>
  );
}

export default SearchShop;