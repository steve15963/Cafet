import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { boardMenuList } from '../../hooks/useBoardPageMenu/useBoardPageMenu'
import Menu from "../../components/Menu/Menu";
import "./BoardPage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Button from "../../components/Button/Button";

import axios from "axios";

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';

const createTable = (boardId, boardTitle, nickname, createdTime, viewCnt, commentSum) => {
  return {boardId, boardTitle, nickname, createdTime, viewCnt, commentSum}
}


const BoardPage = () => {
  // 메뉴 버튼 활성화를 위한 state 관리
  // const [menuSelected, setMenuSelected] = useState(-1)
  let navigate = useNavigate();

  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`)
  }

  const goToCreate = () => {
    navigate('/create')
  }

  const [boardData, setboardData] = useState([])

  useEffect(() => {
    axios
      .get("http://i9a105.p.ssafy.io:8080/api/board/list")
      .then(function (response) {
        setboardData(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  const tableRows = boardData.map((el) => 
    createTable(el.boardId, el.boardTitle, el.nickname, el.createdTime, el.viewCnt, el.commentSum)
  )

  return (
    <>
      <Header />
      <div className="header-save" />
      <div className="menu_wrapper">
        <div className="menu-left-save" />
        <div className="menu_section">
          {boardMenuList.map((it) => (
            <Menu key={it.id} {...it} />
          ))}
        </div>
        <div>
          <Button text={'글 작성'} onClick={goToCreate}/>
        </div>
        <div className="menu-right-save" />
      </div>
      <div className="table-wrapper">
        <div className="table-left-save" />
        
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell align="center">번호</TableCell>
              <TableCell align="center">제목</TableCell>
              <TableCell align="center">작성자</TableCell>
              <TableCell align="center">작성일자</TableCell>
              <TableCell align="center">조회 수</TableCell>
              <TableCell align="center">댓글 수</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {tableRows.map((row) => (
              <TableRow
                key={row.boardId}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell component="th" scope="row" align="center">
                  {row.boardId}
                </TableCell>
                <TableCell onClick={() => goToDetail(row.boardId)}>{row.boardTitle}</TableCell>
                <TableCell>{row.nickname}</TableCell>
                <TableCell>{row.createdTime}</TableCell>
                <TableCell align="center">{row.viewCnt}</TableCell>
                <TableCell align="center">{row.commentSum}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
        <div className="table-right-save" />
      </div>
      <div className="input_wrapper">
        <div className="group">
          <input placeholder="검색" type="search" className="searchbar" />
          <svg className="icon" aria-hidden="true" viewBox="0 0 24 24">
            <g>
              <path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"></path>
            </g>
          </svg>
        </div>
      </div>
      <div className="pagenation">
        <Stack>
          <Pagination count={10} shape="rounded" />
        </Stack>
      </div>
      <div className="footer-save" />
      <Footer />
    </>
  );
};

export default BoardPage;
