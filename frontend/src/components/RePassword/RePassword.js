//비밀번호 재설정 component

import React, { useState } from "react";
import "./RePassword.scoped.css";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";
import handlePasswordUpdate from "../../utils/handlePasswordUpadate";

const RePasswordForm = () => {
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const navigate = useNavigate();

  //비밀번호 변경 버튼 클릭 시 동작(API 미구현)
  const onPasswordUpdateClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handlePasswordUpdate(password);
      const token = response.data.token;
      console.log("Password Modify success", token);
      alert("비밀번호 재설정에 성공하셨습니다.");
      navigate("/", { replace: true });
    } catch (error) {
      console.error("Password Modify failed:");
      alert("비밀번호 재설정에 실패하셨습니다.");
    }
  };

  return (
    <div className="repassword">
      <form className="repassword-form">
        <p className="repassword-form-title">비밀번호 재설정</p>
        <div className="signUp-container">
          <TextField
            label="비밀번호"
            placeholder="비밀번호를 입력해주세요"
            variant="outlined"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <div className="signUp-container">
          <TextField
            label="비밀번호 확인"
            placeholder="비밀번호를 다시 한번 입력해주세요"
            variant="outlined"
            value={passwordCheck}
            onChange={(e) => setPasswordCheck(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <br />
        <div className="repassword-container">
          <Button
            type="common"
            text={"비밀번호 변경"}
            className="button"
            onClick={onPasswordUpdateClick}
          />
        </div>
      </form>
    </div>
  );
};

export default RePasswordForm;
