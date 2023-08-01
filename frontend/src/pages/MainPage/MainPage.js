import React from "react";
import "./MainPage.scoped.css";
import Header from "../../components/Header/Header";
import MainList from "../../components/MainList/MainList";
import Footer from "../../components/Footer/Footer";

const MainPage = () => {
  return (
    <div style={{ backgroundColor: "#fdfdfd" }}>
      <Header />
      <MainList />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default MainPage;
