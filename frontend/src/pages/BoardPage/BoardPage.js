import React from "react";
// import BoardDetail from "./BoardDetail"
import "bootstrap/dist/css/bootstrap.min.css";
import "./BoardPage.css";
import Pagination from "react-bootstrap/Pagination";
import Table from "react-bootstrap/Table";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

let active = 1;
let items = [];
for (let number = 1; number <= 5; number++) {
  items.push(
    <Pagination.Item key={number} active={number === active}>
      {number}
    </Pagination.Item>
  );
}

const mockBoard = [
  {
    id: 0,
    board_id: 0,
    user_id: 0,
    shop_id: 0,
    board_title: "Title TMP",
    board_content: "Content TMP",
    author: "Author TMP",
    created_time: new Date().getTime(),
    updated_time: new Date().getTime(),
    type: false,
    category_id: "chat",
    like_sum: 10,
  },
  {
    id: 1,
    board_id: 1,
    user_id: 1,
    shop_id: 1,
    board_title: "Title TMP1",
    board_content: "Content TMP1",
    author: "Author TMP1",
    created_time: new Date().getTime(),
    updated_time: new Date().getTime(),
    type: false,
    category_id: "chat",
    like_sum: 64,
  },
  {
    id: 2,
    board_id: 2,
    user_id: 2,
    shop_id: 2,
    board_title: "Title TMP2",
    board_content: "Content TMP2",
    author: "Author TMP2",
    created_time: new Date().getTime(),
    updated_time: new Date().getTime(),
    type: false,
    category_id: "chat",
    like_sum: 102,
  },
];

const BoardPage = () => {
  return (
    <>
      <Header />
      <div className="header-save" />
      <Table className="text-center">
        <thead>
          <tr className="table-secondary">
            <th>글번호</th>
            <th>말머리</th>
            <th className="col-6">제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회 수</th>
            <th>추천 수</th>
          </tr>
        </thead>
        <tbody>
          {mockBoard.map((el) => {
            return (
              <tr>
                <td>{el.id}</td>
                <td>{el.category_id}</td>
                <td className="col-6">{el.board_title}</td>
                <td>{el.author}</td>
                <td>{el.like_sum}</td>
                <td>{el.author}</td>
                <td>임시</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
      <div className="boardPage_input">
        <input className="boardPage_search" />
        <button className="boardPage_btn">search</button>
      </div>
      <div className="d-flex justify-content-center">
        <Pagination>
          <Pagination.Prev />
          {items}
          <Pagination.Next />
        </Pagination>
      </div>
      <div className="footer-save" />
      <Footer />
    </>
  );
};

export default BoardPage;
