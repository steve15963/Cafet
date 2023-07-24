import React from "react";

// import Header from "../components/layout/Header/Header";
// import Button from "../components/Button/Button";
// import SearchBar from "../components/SearchBar/SearchBar";
// import SideBar from "../components/SideBar/SideBar";
import CommentList from "../components/CommentList/CommentList";
import Footer from "../components/Footer/Footer";

const TestPage = () => {
  return (
    <>
      {/* <Header />
      <SideBar />
      <SearchBar />
      <Button
        text={"버튼버튼"}
        onClick={() => {
          alert("클릭했습니다.");
        }}
      /> */}
      <CommentList />
      <Footer />
    </>
  );
};

export default TestPage;
