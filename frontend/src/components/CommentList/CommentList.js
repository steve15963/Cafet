import React, { useState } from "react";
import "./CommentList.css";

const mockComment = [
  {
    comment_id: "1",
    comment: "동물이 귀여워요",
    created_time: new Date().getTime(),
    updated_time: "2022-04-06",
    board_id: "후기",
    user_id: "테스터1",
  },
  {
    comment_id: "2",
    comment: "강아지들이 순해요",
    created_time: new Date().getTime(),
    updated_time: "2022-04-06",
    board_id: "후기",
    user_id: "테스터2",
  },
  {
    comment_id: "3",
    comment: "고양이는 왜 없죠?",
    created_time: new Date().getTime(),
    updated_time: "2022-04-06",
    board_id: "후기",
    user_id: "테스터3",
  },
];

const CommentList = () => {
  const [commentCount] = useState(mockComment.length);

  return (
    <div>
      <p>댓글 {commentCount}개</p>
      <ul>
        {mockComment.map((value) => (
          <li key={value.comment_id}>
            <div className="cmt">
              <div className="cmt_left">
                <strong>{value.user_id}</strong>
              </div>
              <div className="cmt_center">{value.comment}</div>
              <div className="cmt_right">{value.created_time}</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CommentList;
