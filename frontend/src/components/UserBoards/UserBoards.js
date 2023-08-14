import "./UserBoards.scoped.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";

const UserBoards = ({ userId }) => {
  const navigate = useNavigate();

  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [boardList, setBoardList] = useState([]);

  useEffect(() => {
    axios
      .get(`https://i9a105.p.ssafy.io/api/board/userId/${userId}`)
      .then(function (res) {
        setBoardList(res.data);
      })
      .catch(function (err) {
        console.log(err);
      });
  }, [userId]);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  const goToDetail = (pageId) => {
    navigate(`/board/detail/${pageId}`);
  };

  const formatTime = (isoTime) => {
    const date = new Date(isoTime);
    const year = date.getFullYear().toString().substr(-2);
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    const hour = date.getHours().toString().padStart(2, "0");
    const minute = date.getMinutes().toString().padStart(2, "0");
    return `${year}/${month}/${day} ${hour}:${minute}`;
  };

  return (
    <div>
      <Paper sx={{ width: "100%", overflow: "hidden" }}>
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell align="center">번호</TableCell>
                <TableCell align="center">제목</TableCell>
                <TableCell align="center">작성일자</TableCell>
                <TableCell align="center">조회 수</TableCell>
                <TableCell align="center">댓글 수</TableCell>
                <TableCell align="center">좋아요</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {boardList
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
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
                    <TableCell>{formatTime(row.createdTime)}</TableCell>
                    <TableCell align="center">{row.viewCnt}</TableCell>
                    <TableCell align="center">{row.commentSum}</TableCell>
                    <TableCell align="center">{row.likeSum}</TableCell>
                  </TableRow>
                ))}
            </TableBody>
          </Table>
        </TableContainer>
        <TablePagination
          rowsPerPageOptions={[10, 25, 50]}
          component="div"
          count={boardList.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </Paper>
    </div>
  );
};

export default UserBoards;
