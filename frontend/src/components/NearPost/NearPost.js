//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";
import { useNavigate } from "react-router-dom";

const NearPost = ({boardList, currentId}) => {

  let navigate = useNavigate();
  
  // eslint-disable-next-line
  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`);
  };

  const currentIndex = boardList.findIndex((post) => post.id === currentId);

  const prevPost = boardList[currentIndex - 1];
  const nextPost = boardList[currentIndex + 1];
  console.log(prevPost);
  console.log(nextPost);
  
  return (
    <div>
    <ul>
    {/* {nextId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"다음 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(nextId)} >{nextTitle}</div>
          <div className="nearpost_right">{nextNickname}</div>
        </div>
      )}
      {prevId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"이전 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(prevId)}>{prevBoard.prevTitle}</div>
          <div className="nearpost_right">{prevNickname}</div>
        </div>
      )} */}
    </ul>
  </div>
  
  );
};

export default NearPost;
