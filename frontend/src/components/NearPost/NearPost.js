import React from "react";
import "./NearPost.css";

const mockPost = [
  {
    comment_id: "1",
    title: "우리집 고양이",
    created_time: new Date().getTime(),
    updated_time: "2022-04-06",
    board_id: "후기",
    text: "이전글",
  },
  {
    comment_id: "2",
    title: "역삼 동물 카페 추천",
    created_time: new Date().getTime(),
    updated_time: "2022-04-06",
    board_id: "후기",
    text: "다음글",
  },
];

const NearPost = () => {
  return (
    <div>
      <ul>
        {mockPost.map((value) => (
          <li key={value.comment_id}>
            <div className="cmt">
              <div className="cmt_left">{value.text}</div>
              <div className="cmt_center">{value.title}</div>
              <div className="cmt_right">{value.created_time}</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default NearPost;
