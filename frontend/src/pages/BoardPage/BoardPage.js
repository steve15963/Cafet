//게시글 페이지

import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import "./BoardPage.scoped.css";

import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Button from "../../components/Button/Button";

import axios from "axios";

import PropTypes from "prop-types";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";

function CustomTabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

const formatTime = (isoTime) => {
  const date = new Date(isoTime);
  const year = date.getFullYear().toString().substr(-2);
  const month = (date.getMonth() + 1).toString().padStart(2, "0");
  const day = date.getDate().toString().padStart(2, "0");
  const hour = date.getHours().toString().padStart(2, "0");
  const minute = date.getMinutes().toString().padStart(2, "0");
  return `${year}/${month}/${day} ${hour}:${minute}`;
};

CustomTabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}

const createTable = (
  boardId,
  boardTitle,
  nickname,
  createdTime,
  viewCnt,
  commentSum
) => {
  return { boardId, boardTitle, nickname, createdTime, viewCnt, commentSum };
};

const BoardPage = () => {
  const [value, setValue] = React.useState(0); // Tabs
  const handleChange = (event, newValue) => {
    // Tabs
    setValue(newValue);
  };

  const [page, setPage] = useState(0); // pagination
  const [rowsPerPage, setRowsPerPage] = useState(10); // pagination

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  let navigate = useNavigate();

  const goToDetail = (pageId) => {
    const clickedIndex = totalBoard.findIndex((row) => row.boardId === pageId);

    if (clickedIndex !== -1) {
      const prevId = clickedIndex > 0 ? totalBoard[clickedIndex - 1].boardId : null;
      const nextId = clickedIndex < totalBoard.length - 1 ? totalBoard[clickedIndex + 1].boardId : null;

      sessionStorage.setItem('prevId', prevId);
      sessionStorage.setItem('nextId', nextId);
    }
    navigate(`/board/detail/${pageId}`);
};

  const goToCreate = () => {
    navigate("/create");
  };

  const [boardData, setboardData] = useState([]);
  useEffect(() => {
    axios
      .get("https://i9a105.p.ssafy.io/api/board")
      .then(function (response) {
        setboardData(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  const totalBoard = boardData.map((el) =>
    createTable(
      el.boardId,
      el.boardTitle,
      el.nickname,
      el.createdTime,
      el.viewCnt,
      el.commentSum,
      el.category_id
    )
  );

  // 전체게시판
  const generalBoard = boardData.filter((it) => it.categoryName === "자유");
  const questBoard = boardData.filter((it) => it.categoryName === "질문");
  const adBoard = boardData.filter((it) => it.categoryName === "홍보");

  return (
    <>
      <Header />
      <div className="header-save" />
      <div className="menu_wrapper">
        <div className="menu-left-save" />
        <Box sx={{ width: "100%" }}>
          <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
            <Tabs
              value={value}
              onChange={handleChange}
              aria-label="basic tabs example"
            >
              <Tab label="전체게시판" {...a11yProps(0)} />
              <Tab label="자유게시판" {...a11yProps(1)} />
              <Tab label="질문게시판" {...a11yProps(2)} />
              <Tab label="홍보게시판" {...a11yProps(3)} />
            </Tabs>
          </Box>
          <CustomTabPanel value={value} index={0}>
            <h1>전체 게시판</h1>
            <div className="btn-wrapper">
              <Button text={"글 작성"} onClick={goToCreate} />
            </div>
            <Paper sx={{ width: "100%", overflow: "hidden" }}>
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
                    {totalBoard
                      .slice(
                        page * rowsPerPage,
                        page * rowsPerPage + rowsPerPage
                      )
                      .map((row) => (
                        <TableRow
                          key={row.boardId}
                          sx={{
                            "&:last-child td, &:last-child th": { border: 0 },
                          }}
                        >
                          <TableCell component="th" scope="row" align="center">
                            {row.boardId}
                          </TableCell>
                          <TableCell onClick={() => goToDetail(row.boardId)}>
                            {row.boardTitle}
                          </TableCell>
                          <TableCell>{row.nickname}</TableCell>
                          <TableCell>{formatTime(row.createdTime)}</TableCell>
                          <TableCell align="center">{row.viewCnt}</TableCell>
                          <TableCell align="center">{row.commentSum}</TableCell>
                        </TableRow>
                      ))}
                  </TableBody>
                </Table>
              </TableContainer>
              <TablePagination
                rowsPerPageOptions={[10, 25, 50]}
                component="div"
                count={totalBoard.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
              />
            </Paper>
          </CustomTabPanel>
          <CustomTabPanel value={value} index={1}>
            <h1>자유게시판</h1>
            <div className="btn-wrapper">
              <Button text={"글 작성"} onClick={goToCreate} />
            </div>
            <Paper sx={{ width: "100%", overflow: "hidden" }}>
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
                    {generalBoard
                      .slice(
                        page * rowsPerPage,
                        page * rowsPerPage + rowsPerPage
                      )
                      .map((row) => (
                        <TableRow
                          key={row.boardId}
                          sx={{
                            "&:last-child td, &:last-child th": { border: 0 },
                          }}
                        >
                          <TableCell component="th" scope="row" align="center">
                            {row.boardId}
                          </TableCell>
                          <TableCell onClick={() => goToDetail(row.boardId)}>
                            {row.boardTitle}
                          </TableCell>
                          <TableCell>{row.nickname}</TableCell>
                          <TableCell>{row.createdTime}</TableCell>
                          <TableCell align="center">{row.viewCnt}</TableCell>
                          <TableCell align="center">{row.commentSum}</TableCell>
                        </TableRow>
                      ))}
                  </TableBody>
                </Table>
              </TableContainer>
              <TablePagination
                rowsPerPageOptions={[10, 25, 50]}
                component="div"
                count={generalBoard.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
              />
            </Paper>
          </CustomTabPanel>
          <CustomTabPanel value={value} index={2}>
            <h1>질문게시판</h1>
            <div className="btn-wrapper">
              <Button text={"글 작성"} onClick={goToCreate} />
            </div>
            <Paper sx={{ width: "100%", overflow: "hidden" }}>
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
                    {questBoard
                      .slice(
                        page * rowsPerPage,
                        page * rowsPerPage + rowsPerPage
                      )
                      .map((row) => (
                        <TableRow
                          key={row.boardId}
                          sx={{
                            "&:last-child td, &:last-child th": { border: 0 },
                          }}
                        >
                          <TableCell component="th" scope="row" align="center">
                            {row.boardId}
                          </TableCell>
                          <TableCell onClick={() => goToDetail(row.boardId)}>
                            {row.boardTitle}
                          </TableCell>
                          <TableCell>{row.nickname}</TableCell>
                          <TableCell>{row.createdTime}</TableCell>
                          <TableCell align="center">{row.viewCnt}</TableCell>
                          <TableCell align="center">{row.commentSum}</TableCell>
                        </TableRow>
                      ))}
                  </TableBody>
                </Table>
              </TableContainer>
              <TablePagination
                rowsPerPageOptions={[10, 25, 50]}
                component="div"
                count={questBoard.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
              />
            </Paper>
          </CustomTabPanel>
          <CustomTabPanel value={value} index={3}>
            <h1>홍보게시판</h1>
            <div className="btn-wrapper">
              <Button text={"글 작성"} onClick={goToCreate} />
            </div>
            <Paper sx={{ width: "100%", overflow: "hidden" }}>
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
                    {adBoard
                      .slice(
                        page * rowsPerPage,
                        page * rowsPerPage + rowsPerPage
                      )
                      .map((row) => (
                        <TableRow
                          key={row.boardId}
                          sx={{
                            "&:last-child td, &:last-child th": { border: 0 },
                          }}
                        >
                          <TableCell component="th" scope="row" align="center">
                            {row.boardId}
                          </TableCell>
                          <TableCell onClick={() => goToDetail(row.boardId)}>
                            {row.boardTitle}
                          </TableCell>
                          <TableCell>{row.nickname}</TableCell>
                          <TableCell>{row.createdTime}</TableCell>
                          <TableCell align="center">{row.viewCnt}</TableCell>
                          <TableCell align="center">{row.commentSum}</TableCell>
                        </TableRow>
                      ))}
                  </TableBody>
                </Table>
              </TableContainer>
              <TablePagination
                rowsPerPageOptions={[10, 25, 50]}
                component="div"
                count={adBoard.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
              />
            </Paper>
          </CustomTabPanel>
        </Box>
        <div className="menu-right-save" />
      </div>
      <div className="input_wrapper">
        <div className="group">
          <input placeholder="검색" type="search" className="searchbar" />
          <svg className="icon" aria-hidden="true" viewBox="0 0 24 24">
            <g>
              <path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z" />
            </g>
          </svg>
        </div>
      </div>
      <div className="footer-save" />
      <Footer />
    </>
  );
};

export default BoardPage;
