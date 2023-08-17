import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./ShopPage.scoped.css";

import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import ShopFollow from "../../components/ShopFollow/ShopFollow";
import ShopInfoPage from "../ShopInfoPage/ShopInfoPage";
import ShopAnimalList from "../../components/ShopAnimalList/ShopAnimalList";


import PropTypes from "prop-types";
import Stack from "@mui/material/Stack";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Box from "@mui/material/Box";
import { Avatar, Container } from "@mui/material";
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';

import PetsIcon from "@mui/icons-material/Pets";
import IconButton from '@mui/material/IconButton';
import AddBoxIcon from '@mui/icons-material/AddBox';

import Chip from '@mui/material/Chip';
import StarIcon from '@mui/icons-material/Star';

import Rating from '@mui/material/Rating';


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
      {value === index && <Box sx={{}}>{children}</Box>}
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

  const userId = localStorage.getItem('userId');
  const level = localStorage.getItem('level');

  const { shopId } = useParams();

  const [isFollowing, setIsFollowing] = useState(false)  // follow 기능

  const [tabValue, setTabValue] = useState(0);
  const [shopData, setShopData] = useState([]);

  const [ starRate, setStarRate ] = useState(0); // 별점

  useEffect(() => {
    axios
      .get(`https://i9a105.p.ssafy.io/api/shop/${shopId}`)
      .then(function (response) {
        setShopData(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, [shopId]);

  const handleChange = (event, newValue) => {
    setTabValue(newValue);
  };

  const handleFollowState = (newState) => {
    setIsFollowing(newState)
  }
  console.log(shopData)

  return (
    <div>
      <Header />
      <div className="header-save" />
      <Container justifyContent="center" sx={{ width: "80%" }}>
        <Stack
          direction="row"
          justifyContent="center"
          alignItems="center"
          gap={1}
        >
          <ListItem>
            <ListItemAvatar>
              <Avatar>
                <PetsIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary={shopData.shopTitle} 
                          secondary={
                            <>
                              <Chip icon={<StarIcon />}
                                    color="primary"
                                    size="small"
                                    label="3점" 
                                    variant="outlined" />
                            </>
                          } /> 
          </ListItem>

          {/* 가게 북마크 */}
          <ShopFollow userId={userId}
                      shopId={shopId}
                      isFollowing={isFollowing} 
                      followState={handleFollowState} />
        </Stack>
        {/* 가게 별점 */}
        <div className="star-wrapper" 
             style={{ display: 'flex', justifyContent: 'center'}}>
          <Rating
            name="simple-controlled"
            value={starRate}
            onChange={(event, newValue) => {
              console.log('newValue', newValue)
              setStarRate(newValue);
            }}
           />
        </div>
        <Box sx={{ width: "100%", borderBottom: 1, borderColor: "divider" }}>
          <Tabs
            variant="fullWidth"
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
          <ShopAnimalList shopId={shopId} />
        </CustomTabPanel>
        <CustomTabPanel value={tabValue} index={1}>
          <h1>갤러리</h1>
        </CustomTabPanel>
        <CustomTabPanel value={tabValue} index={2}>
          <h1>카페 소식</h1>
          <IconButton>
            {
              level === 300 ? <AddBoxIcon /> : <></>
            }
          </IconButton>
        </CustomTabPanel>
        <CustomTabPanel value={tabValue} index={2}>
          <ShopInfoPage key={shopId} {...shopData} />
        </CustomTabPanel>
      </Container>

      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default ShopPage;
