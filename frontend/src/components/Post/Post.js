//게시글 component

import React from "react";
import "./Post.scoped.css";

const Post = ({ boardDetail }) => {
  // document.getElementById(`post-content`).innerHTML = boardDetail.boardContent;

  return (
    <div className="post-card">
      <div className="post-info">
        <h2 className="post-title">{boardDetail.boardTitle}</h2>
        <span className="post-date">
          작성일: {new Date(boardDetail.createdTime).toLocaleDateString()}
        </span>
      </div>
      <div className="post-info">
        <span className="post-author">작성자: {boardDetail.nickname}</span>
        <span className="post-detail-info">
          조회수: {boardDetail.viewCnt} | 좋아요: {boardDetail.likeSum} | 댓글:{" "}
          {boardDetail.commentSum}
        </span>
      </div>
      <div className="post-content-wrapper">
        <div
          className="post-content"
          dangerouslySetInnerHTML={{ __html: boardDetail.boardContent }}
        ></div>
        {/* <p className="post-content">{boardDetail.boardContent}</p> */}
      </div>
    </div>
  );
};

export default Post;
