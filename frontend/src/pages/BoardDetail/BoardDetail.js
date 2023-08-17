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
import useCheckLike from "../../hooks/useCheckLike";

import { Stack } from "@mui/material";
import { Button } from "@mui/material";
import axios from "axios";
import handleLike from "../../utils/handleLike";
import handleUnlike from "../../utils/handleUnlike";

const BoardDetail = () => {
  const { id } = useParams();
  const { boardDetail, loading } = useBoardDetail(id);
  const { boardList } = useBoardList();
  const [content, setContent] = useState("");
  const userId = Number(localStorage.getItem("userId"));
  console.log(typeof userId);
  console.log(typeof id);
  console.log(typeof Number(id));
  const nowLiked = useCheckLike(Number(id), userId);
  const [liked, setLiked] = useState(nowLiked);

  const navigate = useNavigate();

  if (loading || !boardDetail) {
    return <div>Loading...</div>;
  }

  //console.log(boardList);

  const onClickEdit = async (event) => {
    navigate(`/create/${id}`);
  };
  const onClickDelete = async (event) => {
    try {
      //console.log(id);
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

  //댓글 등록
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

  //좋아요 상태 변경
  const onLikeClick = (event) => {
    event.preventDefault();
    console.log("변경 전 " + liked);
    try {
      if (!liked) {
        //eslint-disable-next-line
        const response = handleLike(id, userId);
        console.log("Like");
      } else {
        //eslint-disable-next-line
        const response = handleUnlike(id, userId);
        console.log("Unlike");
      }
      const newLiked = !liked;
      setLiked(newLiked);
    } catch (error) {
      console.error("Error:", error);
      alert("에러가 발생했습니다.");
    }
  };

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
      <div className="likebtn-wrapper">
        <Button
          variant="contained"
          size="large"
          onClick={onLikeClick}
            style={{
              backgroundColor: "white",
              color: liked ? "red" : "black", // 내용에 맞게 색상 변경
            }}
          >
            {liked ? "♥" : "♡"}
        </Button>
      </div>
      {boardDetail.commentList.length > 0 && (
        <CommentList commentList={boardDetail.commentList} />
      )}
      <div className="wrap">
      <Stack
        direction="row"
        spacing={2}
        justifyContent="flex-start"
        sx={{ marginTop: "20px" }}
      >
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
      </div>
      <NearPost boardList={boardList} currentId={id} />
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default BoardDetail;
