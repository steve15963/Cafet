import React from "react";
import "./BoardDetail.scoped.css";
import { useParams } from "react-router-dom";

import Header from "../../components/Header/Header";
import Post from "../../components/Post/Post";
import CommentList from "../../components/CommentList/CommentList";
import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";

import useBoardDetail from "../../hooks/useBoardDetail";
import Button from "../../components/Button/Button";

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
      <div className="input-button-container">
        <div className="input-container">
          <input type="text" placeholder="댓글을 적어주세요" />
        </div>
        <div className="button-container">
          <Button text={"입력하기"} />
        </div>
      </div>
      <NearPost />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
