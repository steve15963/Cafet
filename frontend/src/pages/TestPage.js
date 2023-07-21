import React from "react";

import Header from "../components/layout/Header/Header";
import Footer from "../components/layout/Footer/Footer";
import Button from "../components/item/Button/Button";
import SideBar from "../components/layout/SideBar/SideBar";

const TestPage = () => {
  return (
    <>
      <Header />
      <SideBar />
      <Button
        text={"버튼버튼"}
        onClick={() => {
          alert("클릭했습니다.");
        }}
      />
      <Footer />
    </>
  );
};

export default TestPage;
