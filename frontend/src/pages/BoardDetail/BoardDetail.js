import React from "react";
import "./BoardDetail.css";
import Header from "../../components/Header/Header";
import Post from "../../components/Post/Post";
import CommentList from "../../components/CommentList/CommentList";
import InputForm from "../../components/InputForm/InputForm";
import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";

const BoardDetail = () => {
  return (
    <div className="BoardDetail-container">
      <Header />
      <div className="header-save" />
      <Post />
      <CommentList />
      <InputForm text="댓글을 적어주세요" inputType="comment" />
      <NearPost />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
