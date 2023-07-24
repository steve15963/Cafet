import React from "react";
import "./Post.css";

const mockPost = {
  post_id: "1",
  title: "첫 번째 게시글",
  created_time: new Date().getTime(),
  author: "테스터",
  look: 1555,
  like_sum: 154,
  comment: 39,
  content:
    "테스트용 게시글 테스트용 게시글 테스트용 게시글 테스트용 게시글 테스트용 게시글 테스트용 게시글 테스트용 게시글 ",
};

const Post = () => {
  return (
    <div className="post-card">
      <div className="post-info">
        <h2 className="post-title">{mockPost.title}</h2>
        <span className="post-date">
          작성일: {new Date(mockPost.created_time).toLocaleDateString()}
        </span>
      </div>
      <div className="post-info">
        <span className="post-author">작성자: {mockPost.author}</span>
        <span className="post-detail-info">
          조회수: {mockPost.look} | 좋아요: {mockPost.like_sum} | 댓글:{" "}
          {mockPost.comment}
        </span>
      </div>
      <div className="post-content-wrapper">
        <p className="post-content">{mockPost.content}</p>
      </div>
    </div>
  );
};

export default Post;
