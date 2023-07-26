import React, { useState, useEffect } from "react";
// import BoardDetail from "./BoardDetail"
import "bootstrap/dist/css/bootstrap.min.css";
import "./BoardPage.css";
import Pagination from "react-bootstrap/Pagination";
import Table from "react-bootstrap/Table";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import axios from 'axios'

let active = 1;
let items = [];
for (let number = 1; number <= 5; number++) {
  items.push(
    <Pagination.Item key={number} active={number === active}>
      {number}
    </Pagination.Item>
  );
}

const BoardPage = () => {
  const [data, setData] = useState([])
  useEffect(() => {
    axios.get('http://localhost:8080/api/board/list')
    .then(function (response) {
      setData(response.data)
    })
    .catch(function (error) {
      console.log(error);
    })
  }, [])

  return (
    <>
      <Header />
      <div className="header-save" />
      <div className="table-wrapper">
      <div className="table-left-save" />
        <Table className="text-center">
          <thead>
            <tr className="table-secondary">
              <th>글번호</th>
              <th className="col-6">제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회 수</th>
              <th>댓글 수</th>
            </tr>
          </thead>
          <tbody>
            {data.map((el) => {
              return (
                <tr key={el.boardId}>
                  <td>{el.boardId}</td>
                  <td className="col-6">{el.boardTitle}</td>
                  <td>{el.nickname}</td>
                  <td>{el.createdTime}</td>
                  <td>{el.viewCnt}</td>
                  <td>{el.commentSum}</td>
                </tr>
              );
            })}
          </tbody>
        </Table>
        <div className="table-right-save" />
        </div>
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
