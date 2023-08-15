//메인 페이지 게시글 component

import React from "react";
import "./MainList.scoped.css";
import useBoardList from "../../hooks/useBoardList";
import Masonry from "@mui/lab/Masonry";
import { Link, useNavigate } from "react-router-dom";

const MainList = () => {
  const { boardList, loading } = useBoardList();
  let navigate = useNavigate();
  const DummyThumbnailList = [
    "/images/main/babyrabbit.png",
    "/images/main/bamboodog.png",
    "/images/main/blackcat.png",
    "/images/main/cat.png",
    "/images/main/chinchilla.png",
    "/images/main/dog.png",
    "/images/main/ducklings.png",
    "/images/main/hamster.png",
    "/images/main/puppy.png",
    "/images/main/rabbit.png",
    "/images/main/walldog.png",
    "/images/main/wooddog.png",
  ];

  if (loading) {
    return <div>Loading...</div>;
  }
  
  const goToDetail = (pageId) => {
    const clickedIndex = boardList.findIndex((row) => row.boardId === pageId);

    if (clickedIndex !== -1) {
      const nextId = clickedIndex > 0 ? boardList[clickedIndex - 1].boardId : null;
      const prevId = clickedIndex < boardList.length - 1 ? boardList[clickedIndex + 1].boardId : null;
      console.log(boardList);
      sessionStorage.setItem('prevId', prevId);
      sessionStorage.setItem('prevTitle', boardList[clickedIndex + 1].boardTitle);
      sessionStorage.setItem('prevNickname', boardList[clickedIndex + 1].nickname);
      sessionStorage.setItem('nextId', nextId);
      sessionStorage.setItem('nextTitle', boardList[clickedIndex - 1].boardTitle);
      sessionStorage.setItem('nextNickname', boardList[clickedIndex - 1].nickname);
    }
    navigate(`/board/detail/${pageId}`);
  };
  
  return (
    <div className="mainlist">
      <Masonry columns={3} spacing={2}>
        {boardList.map((item) => (
          <Link
            to={`/board/detail/${item.boardId}`}
            key={item.boardId}
            state={item}
            onClick={() => goToDetail(item.boardId)}
          >
            <div className="mainlist-card-container">
              <div className="mainlist-card">
                <div className="mainlist-front-content">
                  <img
                    src={
                      item.thumbnail
                        ? `${item.thumbnail}?auto=format`
                        : `${
                            DummyThumbnailList[
                              item.boardId % DummyThumbnailList.length
                            ]
                          }?auto=format`
                    } //${item.thumbnail}
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
