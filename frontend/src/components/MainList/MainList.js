import React from "react";
import "./MainList.css";
import useBoardList from "../../hooks/useBoardList/useBoardList";
import Masonry from "@mui/lab/Masonry";

const MainList = () => {
  const { boardList, loading } = useBoardList();

  if (loading) {
    return <div>Loading...</div>;
  }
  return (
    <div className="MainPage">
      <Masonry columns={3} spacing={2}>
        {boardList.map((item) => (
          <div className="card-container" key={item.boardId}>
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
        ))}
      </Masonry>
    </div>
  );
};

export default MainList;
