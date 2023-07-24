import React from "react";

import Header from "../components/layout/Header/Header";
import Footer from "../components/layout/Footer/Footer";
import Button from "../components/item/Button/Button";
import SearchBar from "../components/item/SearchBar/SearchBar";
import SideBar from "../components/item/SideBar/SideBar";

const TestPage = () => {
  return (
    <>
      <Header />
      <SideBar />
      <SearchBar />
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
