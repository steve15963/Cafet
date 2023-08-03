//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";

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
            <div className="nearpost">
              <div className="nearpost_left">{value.text}</div>
              <div className="nearpost_center">{value.title}</div>
              <div className="nearpost_right">{value.created_time}</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default NearPost;
