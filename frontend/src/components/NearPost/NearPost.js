//이전글과 다음글로 이동하기 위한 component(수정 필요)
import React from "react";
import "./NearPost.scoped.css";
import { useNavigate } from "react-router-dom";

const NearPost = () => {
  const boardList = sessionStorage.getItem('boardList');
  const prevId = sessionStorage.getItem('prevId');
  sessionStorage.removeItem('prevId');
  const nextId = sessionStorage.getItem('nextId');
  sessionStorage.removeItem('nextId');

  let navigate = useNavigate();
  
  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`);
  };
  
  const prevBoard = boardList.find(board => board.boardId === prevId);
  console.log(prevBoard);
  const nextBoard = boardList.find(board => board.boardId === nextId);
  console.log(nextBoard);

  return (
    <div>
    <ul>
    {nextId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"다음 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(nextId)} >{nextBoard.nextTitle}</div>
          <div className="nearpost_right">{nextBoard.nextNickname}</div>
        </div>
      )}
      {prevId !== "null" && (
        <div className="nearpost">
          <div className="nearpost_left">{"이전 글"}</div>
          <div className="nearpost_center" onClick={() => goToDetail(prevId)}>{prevBoard.prevTitle}</div>
          <div className="nearpost_right">{prevBoard.prevNickname}</div>
        </div>
      )}
    </ul>
  </div>
  
  );
};

export default NearPost;
