import React from "react";
import { TextField } from "@mui/material";
import Button from "../Button/Button";
import "./ManageRequestDetail.scoped.css";
import { useParams } from "react-router-dom";
import useShopUpRequest from "../../hooks/useShopUpRequest";

const ManageRequestDetail = () => {
  const requestId = useParams();
  const { shopUpRequest, loading } = useShopUpRequest(requestId);
  if (loading) {
    return <div>로딩중...</div>;
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    alert("카페 등록 신청되었습니다");
  };

  return (
    <div className="request-detail">
      <form className="request-detail-form">
        <p className="request-detail-form-title">등록 요청 관리</p>
        <b>신청자 정보</b>
        <div className="request-detail-input-container">
          <TextField
            label="성명"
            placeholder="신청자 성명을 입력해주세요"
            variant="outlined"
            value={shopUpRequest.requester}
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
            value={shopUpRequest.phoneNo}
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
        <br />
        <b>가게 정보</b>
        <div className="request-detail-input-container">
          <TextField
            label="사업자번호"
            variant="outlined"
            placeholder="사업자번호를 입력해주세요"
            fullWidth
            value={shopUpRequest.businessNo}
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
            label="법인명"
            placeholder="법인명을 입력해주세요"
            multiline
            fullWidth
            value={shopUpRequest.trademark}
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
            label="대표자"
            placeholder="대표자 이름을 입력해주세요"
            multiline
            fullWidth
            value={shopUpRequest.ceoName}
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
            label="개업연월일"
            placeholder="ex) 20230801"
            multiline
            fullWidth
            size="small"
            value={shopUpRequest.openDate}
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
            label="사업의 종류"
            placeholder="사업의 종류를 입력해주세요"
            variant="outlined"
            value={shopUpRequest.businessType}
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
            placeholder="가게 대표 메일을 입력해주세요"
            multiline
            value={shopUpRequest.businessEmail}
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
        <div className="request-detail-input-container">
          <TextField
            id="outlined-textarea"
            label="사업장 소재지"
            placeholder="사업장 소재지를 입력해주세요"
            multiline
            value={shopUpRequest.address}
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
        <div className="request-detail-button-row">
          <div>
            <Button
              type="common"
              text={"수락"}
              className="button"
              onClick={handleSubmit}
            />
          </div>
          <div>
            <Button
              type="common"
              text={"거절"}
              className="button"
              onClick={handleSubmit}
            />
          </div>
        </div>
      </form>
    </div>
  );
};

export default ManageRequestDetail;
