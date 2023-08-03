import React from "react";
import "./MyPage.scoped.css";

import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import BasicTabs from "../../components/MyPageTabs/MyPageTabs";

import Grid from "@mui/material/Grid";
import Avatar from "@mui/material/Avatar";
import Container from "@mui/material/Container";

const MyPage = () => {
  return (
    <div className="MyPage">
      <Header />
      <div className="header-save" />
      <Container maxWidth="lg">
        <div>
          <Grid container spacing={2}>
            <Grid
              className="xs2"
              item
              xs={2}
              sx={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
              <Avatar
                alt=""
                sx={{ width: 150, height: 150, marginLeft: "20px" }}
              />
            </Grid>
            <Grid item xs={2} />
            <Grid className="xs10" item xs={8}>
              <p>10</p>
            </Grid>
          </Grid>
        </div>
        <div className="mypage-tab-wrapper">
          <BasicTabs />
        </div>
      </Container>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default MyPage;
