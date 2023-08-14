//마이페이지 기본 정보 component

import React from "react";
import { useNavigate } from "react-router-dom";

import "./AccountData.scoped.css";

import Button from "../Button/Button";

import UserBoards from "../UserBoards/UserBoards"
import UserComments from "../UserComments/UserComments"
import UserLike from "../UserLike/UserLike"
import UserGrade from "../UserGrade/UserGrade";

import PropTypes from "prop-types";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import Grid from "@mui/material/Grid";
import Avatar from "@mui/material/Avatar";
import Container from "@mui/material/Container";

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

const AccountData = () => {
  const [tabValue, setTabValue] = React.useState(0);

  const handleTabChange = (event, newValue) => {
    setTabValue(newValue);
  };

  const navigate = useNavigate();

  //임시 이동 handler
  const handleModifyClick = () => {
    navigate("/mypage/modify");
  };

  return (
    <Container maxWidth="lg">
      <div>
        <Grid container spacing={2}>
          <Grid className="xs2" item xs={2}>
            <Avatar
              className="avatar"
              alt=""
              sx={{ width: 150, height: 150 }}
            />
          </Grid>
          <Grid item xs={2} />
          <Grid className="xs10" item xs={8}>
            <p>10</p>
          </Grid>
          {/* 임시로 페이지 이동을 위한 버튼 */}
          <Button
            text={"개인정보 수정"}
            className="button"
            onClick={handleModifyClick}
          />
        </Grid>
      </div>
      <div className="tab-wrapper">
        <Box sx={{ width: "100%" }}>
          <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
            <Tabs
              value={tabValue}
              onChange={handleTabChange}
              aria-label="basic tabs example"
            >
              <Tab label="게시물" {...a11yProps(0)} />
              <Tab label="댓글" {...a11yProps(1)} />
              <Tab label="좋아요" {...a11yProps(2)} />
              <Tab label="팔로우" {...a11yProps(3)} />
              <Tab label="별점" {...a11yProps(4)} />
            </Tabs>
          </Box>
          <CustomTabPanel value={tabValue} index={0}>
            <UserBoards />
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={1}>
            <UserComments />
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={2}>
            <UserLike />
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={3}>
            팔로우
          </CustomTabPanel>
          <CustomTabPanel value={tabValue} index={4}>
            <UserGrade />
          </CustomTabPanel>
        </Box>
      </div>
    </Container>
  );
};

export default AccountData;
