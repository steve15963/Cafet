import React from "react";

// import Header from "../components/Header/Header";
// import Button from "../components/Button/Button";
// import SearchBar from "../components/SearchBar/SearchBar";
// import SideBar from "../components/SideBar/SideBar";
import Post from "../components/Post/Post";
import CommentList from "../components/CommentList/CommentList";
import InputForm from "../components/InputForm/InputForm";
import NearPost from "../components/NearPost/NearPost";
import Footer from "../components/Footer/Footer";
import Editor from "../components/Editor/Editor";

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
      <CommentList />
      <InputForm />
      <Editor />
      <NearPost />
      <Footer />
    </>
  );
};

export default TestPage;
