import React from "react";
import "./MainList.scoped.css";
import useBoardList from "../../hooks/useBoardList";
import Masonry from "@mui/lab/Masonry";
import { Link } from "react-router-dom";

const MainList = () => {
  const { boardList, loading } = useBoardList();

  if (loading) {
    return <div>Loading...</div>;
  }

  const logLinkClick = (item) => {
    console.log("Link clicked with item:", item);
  };

  return (
    <div className="MainPage">
      <Masonry columns={3} spacing={2}>
        {boardList.map((item) => (
          <Link
            to={`/board/detail/${item.boardId}`}
            key={item.boardId}
            state={item}
            onClick={() => logLinkClick(item.boardId)}
          >
            <div className="card-container">
              <div className="card">
                <div className="front-content">
                  <img
                    src={`${item.thumbnail}?auto=format`}
                    alt={item.boardTitle}
                    onError={(e) => (e.target.style.display = "none")}
                    loading="lazy"
                  />
                </div>
                <div className="content">
                  <p className="heading">{item.boardTitle}</p>
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
