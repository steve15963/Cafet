import React from "react";
import BoardDetail from "./BoardDetail"
// import "/BoardPage.css"

const BoardPage = ({ board }) => {
  return (
    <div className="BoardPage">
      {
        board.map((el) => {
          return <BoardDetail {...el} />
        })
      }
    </div>
  );
};

export default BoardPage;
