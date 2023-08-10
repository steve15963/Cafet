//댓글 리스트를 받아오기 위한 component

import React, { useState } from "react";
import "./CommentList.scoped.css";

const CommentList = ({ commentList }) => {
  const [commentCount] = useState(commentList.length);
  console.log(commentList);

  const formatTime = (isoTime) => {
    const date = new Date(isoTime);
    const year = date.getFullYear().toString().substr(-2);
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    const hour = date.getHours().toString().padStart(2, "0");
    const minute = date.getMinutes().toString().padStart(2, "0");
    return `${year}/${month}/${day} ${hour}:${minute}`;
  };

  return (
    <div>
      <p>댓글 {commentCount}개</p>
      <ul>
        {commentList.map((value) => (
          <li key={value.commentId}>
            <div className="cmt">
              <div className="cmt_left">
                <strong>{value.nickname}</strong>
              </div>
              <div className="cmt_picture">{value.boardfileId}</div>
              <div className="cmt_center">{value.content}</div>
              <div className="cmt_right">{formatTime(value.createdTime)}</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CommentList;
