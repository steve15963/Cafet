import React from "react";
import "./MainPage.scoped.css";
import Header from "../../components/Header/Header";
import InquiryForm from "../../components/InquiryForm/InquiryForm";
import MainList from "../../components/MainList/MainList";
import Footer from "../../components/Footer/Footer";
import { useParams } from "react-router-dom";

const MainPage = () => {
  const { path } = useParams();

  const renderForm = () => {
    if (path === "inquiry") {
      return <InquiryForm />;
    } else {
      return <MainList />;
    }
  };

  return (
    <div style={{ backgroundColor: "#fdfdfd" }}>
      <Header />
      {renderForm()}
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default MainPage;
