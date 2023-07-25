import React from "react";
import Post from "../components/Post/Post";
import CommentList from "../components/CommentList/CommentList";
import InputForm from "../components/InputForm/InputForm";
import NearPost from "../components/NearPost/NearPost";
import Footer from "../components/Footer/Footer";

const BoardDetail = () => {
  return (
    <div>
      <Post />
      <CommentList />
      <InputForm text="댓글을 적어주세요" inputType="comment" />
      <NearPost />
      <Footer />
    </div>
  );
};

export default BoardDetail;
