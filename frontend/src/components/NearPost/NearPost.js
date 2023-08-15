//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";
import useBoardDetail from "../../hooks/useBoardDetail";

const NearPost = (props) => {
  const { prevId, nextId } = props;
  const { prevDetail } = useBoardDetail(prevId);
  const { nextDetail } = useBoardDetail(nextId);
console.log(prevDetail);
console.log(nextDetail);

  return (
    <div>
      <ul>
        <div className="nearpost">
          <div className="nearpost_left">{prevDetail.text}</div>
          <div className="nearpost_center">{prevDetail.title}</div>
          <div className="nearpost_right">{prevDetail.created_time}</div>
        </div>
        <div className="nearpost">
          <div className="nearpost_left">{prevDetail.text}</div>
          <div className="nearpost_center">{prevDetail.title}</div>
          <div className="nearpost_right">{prevDetail.created_time}</div>
        </div>
      </ul>
    </div>
  );
};

export default NearPost;
