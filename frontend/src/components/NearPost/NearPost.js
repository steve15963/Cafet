import React from "react";
import "./NearPost.scoped.css";
import { useNavigate } from "react-router-dom";

const NearPost = ({ boardList, currentId }) => {
  let navigate = useNavigate();

  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`);
  };

  const currentIndex = boardList.findIndex((post) => post.boardId === currentId);

  const prevPost = currentIndex > 0 ? boardList[currentIndex - 1] : null;
  const nextPost =
    currentIndex < boardList.length - 1 ? boardList[currentIndex + 1] : null;

  return (
    <div>
      <ul>
        {nextPost && (
          <div className="nearpost">
            <div className="nearpost_left">{"다음 글"}</div>
            <div
              className="nearpost_center"
              onClick={() => goToDetail(nextPost.boardId)}
            >
              {nextPost.boardTitle}
            </div>
            <div className="nearpost_right">{nextPost.nickname}</div>
          </div>
        )}
        {prevPost && (
          <div className="nearpost">
            <div className="nearpost_left">{"이전 글"}</div>
            <div
              className="nearpost_center"
              onClick={() => goToDetail(prevPost.boardId)}
            >
              {prevPost.boardTitle}
            </div>
            <div className="nearpost_right">{prevPost.nickname}</div>
          </div>
        )}
      </ul>
    </div>
  );
};

export default NearPost;
