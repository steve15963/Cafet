import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const ManageInquiryList = (props) => {
  const navigate = useNavigate();
  const handleInquiryDetail = (e, id) => {
    navigate(`${id}`);
  };
  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableBody>
            {props.inquiryList.map((row) => (
              <TableRow
                key={row.inquiryId}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.inquiryTitle}
                </TableCell>

                <TableCell align="right">
                  <Button
                    variant="outlined"
                    onClick={(event) =>
                      handleInquiryDetail(event, row.inquiryId)
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
export default ManageInquiryList;
