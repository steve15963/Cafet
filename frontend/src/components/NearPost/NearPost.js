//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";

const NearPost = () => {
  const prevId = sessionStorage.getItem('prevId');
  sessionStorage.removeItem('prevId');
  const prevTitle = sessionStorage.getItem('prevTitle');
  sessionStorage.removeItem('prevTitle');
  const prevNickname = sessionStorage.getItem('prevNickname');
  sessionStorage.removeItem('prevNickname');
  const nextId = sessionStorage.getItem('nextId');
  sessionStorage.removeItem('prevTitle');
  const nextTitle = sessionStorage.getItem('nextTitle');
  sessionStorage.removeItem('nextTitle');
  const nextNickname = sessionStorage.getItem('nextNickname');
  sessionStorage.removeItem('nextNickname');

  return (
    <div>
    <ul>
    {nextId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"다음 글"}</div>
          <div className="nearpost_center">{nextTitle}</div>
          <div className="nearpost_right">{nextNickname}</div>
        </div>
      )}
      {prevId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"이전 글"}</div>
          <div className="nearpost_center">{prevTitle}</div>
          <div className="nearpost_right">{prevNickname}</div>
        </div>
      )}
    </ul>
  </div>
  
  );
};

export default NearPost;
