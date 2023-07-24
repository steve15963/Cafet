import React from "react";
import "./NearPost.css";

const mockPost = [
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
];

const NearPost = () => {
  return (
    <div>
      <ul>
        {mockPost.map((value) => (
          <li key={value.comment_id}>
            <div className="cmt">
              <div className="cmt_user_id">이전글</div>
              <div className="cmt_cmt">{value.comment}</div>
              <div className="cmt_created_time">다음글</div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default NearPost;
