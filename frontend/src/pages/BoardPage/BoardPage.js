import React, { useState, useEffect } from "react";
import { boardMenuList } from '../../utils/useBoardPageMenu/useBoardPageMenu'
import Menu from "../../components/Menu/Menu";
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
  
  // 메뉴 버튼 활성화를 위한 state 관리
  const [menuSelected, setMenuSelected] = useState(-1)
  
  const [boardData, setboardData] = useState([])
  useEffect(() => {
    axios.get('http://localhost:8080/api/board/list')
    .then(function (response) {
      setboardData(response.data)
    })
    .catch(function (error) {
      console.log(error);
    })
  }, [])

  return (
    <>
      <Header />
      <div className="header-save" />
      <div className="menu_wrapper">
        <div className="menu-left-save"/>
        <div className="menu_section">
          {
            boardMenuList.map((it) => 
              <Menu key={it.id} {...it} />
            )
          }
        </div>
        <div className="menu-right-save"/>
      </div>
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
            {boardData.map((el) => {
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
      <div className="input_wrapper">
        <div className="group">
          <input placeholder="검색" type="search" className="searchbar" />
          <svg className="icon" aria-hidden="true" viewBox="0 0 24 24"><g><path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"></path></g></svg>
        </div>
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