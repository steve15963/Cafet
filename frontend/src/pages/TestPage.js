import React from "react";

// import Header from "../components/layout/Header/Header";
// import Button from "../components/Button/Button";
// import SearchBar from "../components/SearchBar/SearchBar";
// import SideBar from "../components/SideBar/SideBar";
import Post from "../components/Post/Post";
import CommentList from "../components/CommentList/CommentList";
import CommentSlot from "../components/CommentSlot/CommentSlot";
import NearPost from "../components/NearPost/NearPost";
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
      />  */}
      <Post />
      <CommentSlot />
      <CommentList />
      <NearPost />
      <Footer />
    </>
  );
};

export default TestPage;
