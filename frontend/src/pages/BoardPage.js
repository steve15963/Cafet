import React from "react";
// import BoardDetail from "./BoardDetail"
import 'bootstrap/dist/css/bootstrap.min.css';
import './BoardPage.css'
import Pagination from 'react-bootstrap/Pagination';
import Table from 'react-bootstrap/Table';

let active = 1;
let items = [];
for (let number = 1; number <= 5; number++) {
  items.push(
    <Pagination.Item key={number} active={number === active}>
      {number}
    </Pagination.Item>,
  );
}

const BoardPage = ({ board }) => {
  return (
    <>
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
        {
          board.map((el) => {
            return (
            <tr>
              <td>{ el.id }</td>
              <td>{ el.category_id }</td>
              <td className="col-6">{ el.board_title }</td>
              <td>{ el.author }</td>
              <td>{ el.like_sum }</td>
              <td>{ el.author }</td>
              <td>임시</td>
            </tr>
            )
          })
        }
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
    </>
  );
}

export default BoardPage;
