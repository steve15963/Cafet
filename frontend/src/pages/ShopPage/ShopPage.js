import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./ShopPage.scoped.css";

import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

import AnimalList from "../../components/AnimalList/AnimalList";
import ShopInfoPage from "../ShopInfoPage/ShopInfoPage";

import PropTypes from "prop-types";
import Stack from "@mui/material/Stack";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import StarIcon from "@mui/icons-material/Star";
import { yellow } from "@mui/material/colors";

import SearchMap from "../../components/SearchMap/SearchMap";

function CustomTabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

CustomTabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}

const ShopPage = () => {
  const { shopId } = useParams();
  const [tabValue, setTabValue] = useState(0);
  const [shopData, setShopData] = useState([]);

  useEffect(() => {
    axios
      .get(`http://i9a105.p.ssafy.io/api/shop/${shopId}`)
      .then(function (response) {
        setShopData(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, [shopId]);
  console.log("shopData", shopData);

  const handleChange = (event, newValue) => {
    setTabValue(newValue);
  };

  return (
    <div>
      <Header />
      <div className="header-save" />
      <div className="shop-name">
        <h1>{shopData.shopTitle}</h1>
      </div>
      <Stack direction="row" alignItems="center" gap={1}>
        <StarIcon sx={{ color: yellow[700] }} />
        <Typography>
          {Math.round((shopData.totalScore / shopData.gradeCount) * 10) / 10}점
        </Typography>
      </Stack>
      <div className="tab-wrapper">
        <Box sx={{ width: "100%" }}>
          <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
            <Tabs
              value={tabValue}
              onChange={handleChange}
              aria-label="basic tabs example"
            >
              <Tab label="카페 가족" {...a11yProps(0)} />
              <Tab label="갤러리" {...a11yProps(1)} />
              <Tab label="카페 소식" {...a11yProps(2)} />
              <Tab label="카페 정보" {...a11yProps(3)} />
            </Tabs>
          </Box>
          <CustomTabPanel value={tabValue} index={0}>
            <h1>카페 가족</h1>
            <AnimalList />
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={1}>
            <h1>갤러리</h1>
            <SearchMap />
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={2}>
            <h1>카페 소식</h1>
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={3}>
            <ShopInfoPage key={shopId} {...shopData} />
          </CustomTabPanel>
        </Box>
      </div>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default ShopPage;
