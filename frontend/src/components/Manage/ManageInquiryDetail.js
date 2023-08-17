import React from "react";
import { Button, TextField } from "@mui/material";
import "./ManageInquiryDetail.scoped.css";
import { useNavigate, useParams } from "react-router-dom";
import useInquiry from "../../hooks/useInquiry";
import formatTime from "../../utils/formatTime";
import axios from "axios";

const ManageRequestDetail = () => {
  const inquiryId = useParams();
  const navigate = useNavigate();
  const { inquiry, loading } = useInquiry(inquiryId);
  if (loading) {
    return <div>로딩중...</div>;
  }
  const handleSubmit = (e) => {
    navigate("/manage/inquiry");
    e.preventDefault();
  };
  console.log(inquiryId.id);
  const handleDelete = async (e) => {
    e.preventDefault();

    axios
      .delete(`https://i9a105.p.ssafy.io/api/inquiry/${inquiryId.id}`)
      .then((res) => {
        if (res.status === 204) {
          navigate(`/manage/inquiry`, { replace: true });
          return;
        } else {
          console.error("문의 사항 삭제에 실패");
          return;
        }
      });
  };

  return (
    <div className="request-detail">
      <form className="request-detail-form">
        <p className="request-detail-form-title">문의 관리</p>
        <b>문의자 정보</b>
        <div className="request-detail-input-container">
          <TextField
            label="성명"
            placeholder="문의자 성명을 입력해주세요"
            variant="outlined"
            value={inquiry.nickname}
            size="small"
            fullWidth
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-input-container">
          <TextField
            label="연락처"
            placeholder="전화번호를 입력해주세요"
            variant="outlined"
            inputProps={{
              type: "",
            }}
            value={inquiry.phoneNo}
            size="small"
            fullWidth
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-input-container">
          <TextField
            id="outlined-textarea"
            label="이메일"
            placeholder="문의자 메일을 입력해주세요"
            multiline
            value={inquiry.email}
            fullWidth
            size="small"
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <br />
        <b>문의 내용</b>
        <div className="request-detail-input-container">
          <TextField
            id="outlined-textarea"
            label="제목"
            placeholder="제목을 입력해주세요"
            multiline
            fullWidth
            value={inquiry.inquiryTitle}
            size="small"
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-input-container">
          <TextField
            id="outlined-textarea"
            label="분류"
            placeholder="분류를 입력해주세요"
            multiline
            fullWidth
            value={inquiry.inquiryCategoryName}
            size="small"
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-input-container">
          <TextField
            id="outlined-textarea"
            label="생성일"
            placeholder="ex) 20230801"
            multiline
            fullWidth
            size="small"
            value={formatTime(inquiry.createdTime)}
            disabled
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-input-container">
          <TextField
            label="문의 내용"
            placeholder="문의 내용을 입력해주세요"
            variant="outlined"
            value={inquiry.inquiryContent}
            size="small"
            fullWidth
            disabled
            multiline
            rows={4}
            sx={{
              "& .MuiInputBase-input.Mui-disabled": {
                WebkitTextFillColor: "#000000",
              },
            }}
          />
        </div>
        <div className="request-detail-button-row">
          <div>
            <Button fullWidth variant="contained" onClick={handleSubmit}>
              뒤로
            </Button>
          </div>
          <div>
            <Button
              fullWidth
              variant="contained"
              color="error"
              onClick={handleDelete}
            >
              삭제
            </Button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default ManageRequestDetail;
