//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";
import { useNavigate } from "react-router-dom";

const NearPost = ({boardList, currentId}) => {

  let navigate = useNavigate();
  
  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`);
  };

  const currentIndex = boardList.findIndex((post) => post.id === currentId);
  console.log(currentId);
  console.log(boardList);
  
  const prevId = currentIndex < boardList.length - 1 ? boardList[currentIndex + 1].boardId : null;
  const nextId = currentIndex > 0 ? boardList[currentIndex - 1].boardId : null;
  
  return (
    <div>
    <ul>
    {nextId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"다음 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(nextId)} >{boardList[currentIndex - 1].boardTitle}</div>
          <div className="nearpost_right">{boardList[currentIndex - 1].nickname}</div>
        </div>
      )}
      {prevId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"이전 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(prevId)}>{boardList[currentIndex + 1].boardTitle}</div>
          <div className="nearpost_right">{boardList[currentIndex + 1].nickname}</div>
        </div>
      )}
    </ul>
  </div>
  
  );
};

export default NearPost;
