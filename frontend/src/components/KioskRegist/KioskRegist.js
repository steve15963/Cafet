//로그인을 위한 component

import React, { useState } from "react";
import handleKioskFirst from "../../utils/handleKioskFirst";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import KioskButton from "../KioskButton/KioskButton";

const KioskRegist = () => {
  const shopId = localStorage.getItem("shopId");
  const [deskNum, setDeskNum] = useState("");
  const navigate = useNavigate();

  const onButtonClick = async (event) => {
    event.preventDefault();
    try {
      //eslint-disable-next-line
      const response = await handleKioskFirst(shopId, deskNum);
      console.log(response.headers);
      console.log("submit success : ");
      alert("등록에 성공하셨습니다.");
      navigate("/kiosk/list", { replace: true });
    } catch (error) {
      console.error("submit failed:");
      alert("등록에 실패하셨습니다.");
    }
  };

  return (
    <div className="login">
      <form className="login-form">
        <p className="login-form-title">키오스크 등록하기</p>
        <div className="login-container">
          <TextField
            label="키오스크 수량"
            placeholder="키오스크 수량을 입력해주세요"
            variant="outlined"
            value={deskNum}
            onChange={(e) => setDeskNum(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <br />
        <div className="login-container">
          <KioskButton
            type="common"
            text={"입력하기"}
            className="button"
            onClick={onButtonClick}
          />
        </div>
      </form>
    </div>
  );
};

export default KioskRegist;
