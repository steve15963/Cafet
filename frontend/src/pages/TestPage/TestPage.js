//컴퍼넌트 확인을 위한 테스트 페이지

import React from "react";
import "./TestPage.scoped.css";
// import Header from "../components/Header/Header";
import Button from "../../components/Button/Button";
// import SearchBar from "../components/SearchBar/SearchBar";
// import SideBar from "../components/SideBar/SideBar";
// import Post from "../../components/Post/Post";
// import CommentList from "../../components/CommentList/CommentList";
// import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";
import handletest from "../../utils/handletest";
// import Editor from "../../components/Editor/Editor";

const TestPage = () => {
  const onButtonClick = async (event) => {
    event.preventDefault();
    try {
      //eslint-disable-next-line
      const response = await handletest();
      console.log("Success : ");
      alert("요청에 성공하셨습니다.");
    } catch (error) {
      console.error("Failed:");
      alert("요청에 실패하셨습니다.");
    }
  };

  return (
    <>
      {/* <Header />
      <SideBar />
      <SearchBar />*/}
      <Button text={"버튼버튼"} onClick={onButtonClick} />
      {/* <Post />
      <CommentList />
      <Editor />
      <NearPost /> */}
      <Footer />
    </>
  );
};

export default TestPage;
