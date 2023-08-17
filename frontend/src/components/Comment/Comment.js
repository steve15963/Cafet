//댓글 리스트를 받아오기 위한 component

import React, { useState } from "react";
import { Button, Stack } from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import "./Comment.scoped.css";
import DeleteIcon from "@mui/icons-material/Delete";
// import axiosCreate from "./../../axiosCreate";
import axios from "axios";

const Comment = ({ comment }) => {
  const [mayEdit, setMayEdit] = useState(false);
  const [content, setContent] = useState(comment.content);

  const formatTime = (isoTime) => {
    const date = new Date(isoTime);
    const year = date.getFullYear().toString().substr(-2);
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    const hour = date.getHours().toString().padStart(2, "0");
    const minute = date.getMinutes().toString().padStart(2, "0");
    return `${year}/${month}/${day} ${hour}:${minute}`;
  };

  const handleChange = (e) => {
    setContent(e.target.value);
  };

  const handleDelete = () => {
    axios
      .delete(
        `https://i9a105.p.ssafy.io/api/comment/status/${comment.commentId}`
      )
      .then((res) => {
        if (res.status === 200) {
          alert("삭제 성공.");
          window.location.reload();
          return;
        } else {
          alert("삭제 실패.");
          return;
        }
      });
  };

  const handleEdit = () => {
    if (content.length === 0) {
      handleDelete();
      return;
    }

    const data = {
      commentId: comment.commentId,
      content,
    };

    axios.put(`https://i9a105.p.ssafy.io/api/comment`, data).then((res) => {
      setMayEdit(false);
      if (res.status === 200) {
        return;
      } else {
        alert("수정 실패.");
        return;
      }
    });
  };

  const enableMayEdit = () => {
    setMayEdit(true);
  };
  const disableMayEdit = () => {
    setMayEdit(false);
  };
  const userId = Number(localStorage.getItem("userId"));
  return (
    <Stack
      spacing={0}
      direction="row"
      key={comment.commentId}
      justifyContent="space-around"
      alignItems="center"
    >
      <div style={{ width: "15%" }}>
        <strong>{comment.nickname}</strong>
      </div>
      <div
        style={{
          width: userId === comment.userId ? "55%" : "70%",
          marginLeft: "10px",
        }}
      >
        <input
          readOnly={!mayEdit}
          defaultValue={comment.content}
          className="comment"
          onChange={handleChange}
        />
      </div>
      {userId === comment.userId && mayEdit && (
        <Stack
          direction="row"
          justifyContent="center"
          sx={{ width: "15%", height: "28px" }}
        >
          <Button size="small" onClick={handleEdit}>
            수정
          </Button>
          <Button size="small" onClick={disableMayEdit}>
            취소
          </Button>
        </Stack>
      )}
      {userId === comment.userId && !mayEdit && (
        <Stack
          direction="row"
          justifyContent="space-around"
          sx={{ width: "15%", height: "28px" }}
        >
          <EditIcon size="small" onClick={enableMayEdit} />
          <DeleteIcon size="small" onClick={handleDelete} />
        </Stack>
      )}
      <div style={{ width: "15%", textAlign: "center" }}>
        {formatTime(comment.createdTime)}
      </div>
    </Stack>
  );
};

export default Comment;
