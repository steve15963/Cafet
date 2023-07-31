import React, { useState } from "react";
import "./CommentList.scoped.css";

const CommentList = ({ commentList }) => {
  const [commentCount] = useState(commentList.length);

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
              <div className="cmt_center">{value.content}</div>
              <div className="cmt_right">{value.createdTime}</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CommentList;
