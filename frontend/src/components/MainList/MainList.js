//메인 페이지 게시글 component

import React from "react";
import "./MainList.scoped.css";
import Masonry from "@mui/lab/Masonry";
import { Link } from "react-router-dom";
import useBoardMainList from "../../hooks/useBoardMainList";

const MainList = () => {
  const { boardList, loading } = useBoardMainList();

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="mainlist">
      <Masonry columns={3} spacing={2}>
        {boardList.map((item) => (
          <Link
            to={`/board/detail/${item.boardId}`}
            key={item.boardId}
            state={item}
          >
            <div className="mainlist-card-container">
              <div className="mainlist-card">
                <div className="mainlist-front-content">
                  <img
                    src={`${item.thumbnail}?auto=format`} //${item.thumbnail}
                    alt={item.boardTitle}
                    onError={(e) => (e.target.style.display = "none")}
                    loading="lazy"
                  />
                </div>
                <div className="mainlist-content">
                  <p className="mainlist-heading">{item.boardTitle}</p>
                  <p>{item.boardContent}</p>
                </div>
              </div>
            </div>
          </Link>
        ))}
      </Masonry>
    </div>
  );
};

export default MainList;
