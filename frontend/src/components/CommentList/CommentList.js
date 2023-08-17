//댓글 리스트를 받아오기 위한 component

import React from "react";
import "./CommentList.scoped.css";
import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Stack,
  Typography,
} from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import Comment from "../Comment/Comment";

const CommentList = ({ commentList }) => {
  console.log(commentList);
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
              <Comment comment={value} key={value.commentId}></Comment>
            ))}
          </Stack>
        </AccordionDetails>
      </Accordion>
    </div>
  );
};

export default CommentList;
