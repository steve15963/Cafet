import React, { useState } from "react";
import handleLogin from "../../utils/handleLogin";
import "./RePassword.scoped.css";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const RePasswordForm = () => {
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const navigate = useNavigate();

  const onLoginButtonClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleLogin(password);
      const token = response.data.token;
      console.log("Login success", token);
      alert("로그인에 성공하셨습니다.");
      navigate("/", { replace: true });
    } catch (error) {
      console.error("Login failed:");
      alert("로그인에 실패하셨습니다.");
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
        <div className="repassword-container">
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
            text={"이메일 전송"}
            className="button"
            onClick={onLoginButtonClick}
          />
        </div>
      </form>
    </div>
  );
};

export default RePasswordForm;
