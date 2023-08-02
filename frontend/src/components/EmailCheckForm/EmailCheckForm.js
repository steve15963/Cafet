import React, { useState } from "react";
import "./EmailCheckForm.scoped.css";
import handleEmailSend from "../../utils/handleEmailSend";
import handleCheckEmail from "../../utils/handleCheckEmail";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const EmailCheckForm = () => {
  const [email, setEmail] = useState("");
  const [emailToken, setEmailToken] = useState("");
  const navigate = useNavigate();

  const onEmailSendClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleEmailSend(email);
      const token = response.data.token;
      console.log("Email send success", token);
      alert("이메일이 전송되었습니다. 5분 이내에 인증번호를 입력해주세요");
    } catch (error) {
      console.error("Email send failed:");
      alert("이메일 전송에 실패했습니다.");
    }
  };

  const onCheckEmailClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleCheckEmail(email, emailToken);
      const token = response.data.token;
      console.log("Email Check success", token);
      alert("이메일 인증에 성공했습니다.");
      navigate("/login/repassword", { replace: true });
    } catch (error) {
      console.error("Email Check failed:");
      alert("이메일 인증에 실패했습니다.");
    }
  };

  return (
    <div className="signUp">
      <form className="signUp-form">
        <p className="signUp-form-title">비밀번호 재설정</p>
        <div className="signUp-container">
          <TextField
            label="이메일"
            placeholder="이메일을 입력해주세요"
            variant="outlined"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            size="small"
            fullWidth
          />
          <Button
            type="gray"
            text={"전송하기"}
            className="button"
            onClick={onEmailSendClick}
          />
        </div>
        <div className="signUp-container">
          <TextField
            label="인증번호"
            placeholder="인증번호를 입력해주세요"
            variant="outlined"
            value={emailToken}
            onChange={(e) => setEmailToken(e.target.value)}
            size="small"
            fullWidth
          />
          <Button
            type="gray"
            text={"인증하기"}
            className="button"
            onClick={onCheckEmailClick}
          />
        </div>
      </form>
    </div>
  );
};

export default EmailCheckForm;
