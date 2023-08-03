//마이페이지

import React from "react";
import "./MyPage.scoped.css";

import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import { Outlet } from "react-router-dom";

const MyPage = () => {
  return (
    <div className="MyPage">
      <Header />
      <div className="header-save" />
      <Outlet />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default MyPage;
