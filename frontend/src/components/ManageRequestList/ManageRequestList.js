import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const ManageRequestList = (props) => {
  const navigate = useNavigate();
  const handleRequestDetail = (e, id) => {
    navigate(`${id}`);
  };
  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableBody>
            {props.requestList.map((row) => (
              <TableRow
                key={row.requestId}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.shop}
                </TableCell>

                <TableCell align="right">
                  <Button
                    variant="outlined"
                    onClick={(event) =>
                      handleRequestDetail(event, row.requestId)
                    }
                  >
                    상세 보기
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};
export default ManageRequestList;
