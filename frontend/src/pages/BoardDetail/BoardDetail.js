//게시글 상세 페이지

import React, { useState } from "react";
import "./BoardDetail.scoped.css";
import { useNavigate, useParams } from "react-router-dom";

import Header from "../../components/Header/Header";
import Post from "../../components/Post/Post";
import CommentList from "../../components/CommentList/CommentList";
import NearPost from "../../components/NearPost/NearPost";
import Footer from "../../components/Footer/Footer";
import handleComment from "../../utils/handleComment";
import useBoardDetail from "../../hooks/useBoardDetail";
import useBoardList from "../../hooks/useBoardList";
// import Button from "../../components/Button/Button";

import { Stack } from "@mui/material";
import { Button } from "@mui/material";
// import axiosCreate from "../../axiosCreate";
import axios from "axios";

const BoardDetail = () => {
  const { id } = useParams();
  const { boardDetail, loading } = useBoardDetail(id);
  const { boardList } = useBoardList();
  const [content, setContent] = useState("");
  const navigate = useNavigate();

  if (loading || !boardDetail) {
    return <div>Loading...</div>;
  }

  console.log(boardList);
  
  const onClickEdit = async (event) => {
    navigate(`/create/${id}`);
  };
  const onClickDelete = async (event) => {
    try {
      // console.log(id);
      axios
        .delete(`https://i9a105.p.ssafy.io/api/board/status/${id}`)
        .then((res) => {
          // console.log(res);
          if (res.status === 200) {
            alert("글을 삭제했습니다.");
            navigate(`/board`);
            return;
          } else {
            console.error("게시글을 삭제하는 중 에러가 발생했습니다.");
            return;
          }
        });
    } catch (error) {
      console.error("삭제 실패", error);
    }
  };

  const onButtonClick = async (event) => {
    event.preventDefault();
    try {
      const userId = localStorage.getItem("userId");
      const response = await handleComment(id, userId, content);
      console.log("Comment success : ", response);
      alert("댓글 작성을 성공하셨습니다.");
      window.location.reload();
    } catch (error) {
      console.error("Comment failed:");
      alert("댓글 작성을 실패하셨습니다.");
    }
  };
  const userId = Number(localStorage.getItem("userId"));

  return (
    <div className="boarddetail-container">
      <Header />
      <div className="header-save" />
      <Post boardDetail={boardDetail} />
      {userId === boardDetail.userId && (
        <Stack direction="row" spacing={2} justifyContent="flex-end">
          <Button variant="outlined" size="large" onClick={onClickEdit}>
            수정
          </Button>
          <Button
            variant="contained"
            color="error"
            size="large"
            onClick={onClickDelete}
          >
            삭제
          </Button>
        </Stack>
      )}
      {boardDetail.commentList.length > 0 && (
        <CommentList commentList={boardDetail.commentList} />
      )}
      <Stack
        direction="row"
        spacing={2}
        justifyContent="flex-start"
        sx={{ marginTop: "20px" }}
      >
        {/* <Typography>사람</Typography> */}
        <div className="boarddetail-input-container">
          <input
            type="text"
            value={content}
            onChange={(e) => setContent(e.target.value)}
            placeholder="댓글을 적어주세요"
            style={{ width: "100%" }}
          />
        </div>
        <Button variant="contained" onClick={onButtonClick}>
          댓글 작성
        </Button>
      </Stack>
      <NearPost boardList={boardList} currentId={id}/>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
