import React from "react";
import "./BoardDetail.css";
import { useParams } from "react-router-dom";

import Header from "../../components/Header/Header";
import Post from "../../components/Post/Post";
import CommentList from "../../components/CommentList/CommentList";
import InputForm from "../../components/InputForm/InputForm";
import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";

import useBoardDetail from "../../hooks/useBoardDetail/useBoardDetail";

const BoardDetail = () => {
  const { id } = useParams();
  const { boardDetail, loading } = useBoardDetail(id);

  if (loading || !boardDetail) {
    return <div>Loading...</div>;
  }

  return (
    <div className="BoardDetail-container">
      <Header />
      <div className="header-save" />
      <Post boardDetail={boardDetail} />
      <CommentList commentList={boardDetail.commentList} />
      <InputForm text="댓글을 적어주세요" inputType="comment" />
      <NearPost />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
