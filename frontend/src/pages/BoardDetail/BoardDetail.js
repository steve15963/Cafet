//게시글 상세 페이지

import React, { useState } from "react";
import "./BoardDetail.scoped.css";
import { useParams } from "react-router-dom";

import Header from "../../components/Header/Header";
import Post from "../../components/Post/Post";
import CommentList from "../../components/CommentList/CommentList";
import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";
import handleComment from "../../utils/handleComment";
import useBoardDetail from "../../hooks/useBoardDetail";
import Button from "../../components/Button/Button";

const BoardDetail = () => {
  const { id } = useParams();
  const { boardDetail, loading } = useBoardDetail(id);
  const [content, setContent] = useState("");

  if (loading || !boardDetail) {
    return <div>Loading...</div>;
  }

  const onButtonClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleComment(id, content);
      console.log("Comment success : ", response);
      alert("댓글 작성을 성공하셨습니다.");
      window.location.reload();
    } catch (error) {
      console.error("Comment failed:");
      alert("댓글 작성을 실패하셨습니다.");
    }
  };

  return (
    <div className="boarddetail-container">
      <Header />
      <div className="header-save" />
      <Post boardDetail={boardDetail} />
      <CommentList commentList={boardDetail.commentList} />
      <div className="boarddetail-input-button-container">
        <div className="boarddetail-input-container">
          <input
            type="text"
            value={content}
            onChange={(e) => setContent(e.target.value)}
            placeholder="댓글을 적어주세요"
          />
        </div>
        <div className="boarddetail-button-container">
          <Button
            type="common"
            text={"입력하기"}
            className="button"
            onClick={onButtonClick}
          />
        </div>
      </div>
      <NearPost />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
