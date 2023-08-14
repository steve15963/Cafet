//댓글 리스트를 받아오기 위한 component

import React from "react";
import "./CommentList.scoped.css";
import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Button,
  Stack,
  Typography,
} from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";

const CommentList = ({ commentList }) => {
  const formatTime = (isoTime) => {
    const date = new Date(isoTime);
    const year = date.getFullYear().toString().substr(-2);
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    const hour = date.getHours().toString().padStart(2, "0");
    const minute = date.getMinutes().toString().padStart(2, "0");
    return `${year}/${month}/${day} ${hour}:${minute}`;
  };
  console.log(commentList);

  const userId = Number(localStorage.getItem("userId"));
  console.log(typeof userId);
  return (
    <div>
      <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel2a-content"
          id="panel2a-header"
        >
          <Typography>댓글 {commentList.length}개</Typography>
        </AccordionSummary>
        <AccordionDetails>
          <Stack spacing={1}>
            {commentList.map((value) => (
              <Stack
                spacing={0}
                direction="row"
                key={value.commentId}
                justifyContent="space-around"
                alignItems="center"
              >
                <div style={{ width: "15%" }}>
                  <strong>{value.nickname}</strong>
                </div>
                <div
                  style={{
                    width: userId === value.userId ? "55%" : "70%",
                    marginLeft: "10px",
                  }}
                >
                  {value.content}
                </div>
                {userId === value.userId && (
                  <Stack
                    direction="row"
                    justifyContent="center"
                    sx={{ width: "15%" }}
                  >
                    <Button size="small">수정</Button>
                    <Button size="small">삭제</Button>
                  </Stack>
                )}
                <div style={{ width: "15%", textAlign: "center" }}>
                  {formatTime(value.createdTime)}
                </div>

                {/* </div> */}
              </Stack>
            ))}
          </Stack>
        </AccordionDetails>
      </Accordion>
    </div>
  );
};

export default CommentList;
