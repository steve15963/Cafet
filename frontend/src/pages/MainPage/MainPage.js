//메인 페이지

import React from "react";
import "./MainPage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import { Outlet } from "react-router-dom";

const MainPage = () => {
  return (
    <div className="mainpage">
      <Header />
      <div className="header-save" />
      <Outlet />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default MainPage;
