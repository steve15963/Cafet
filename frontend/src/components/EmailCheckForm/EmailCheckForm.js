//이메일 인증을 위한 component

import React, { useState } from "react";
import "./EmailCheckForm.scoped.css";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

import handleEmailSend from "../../utils/handleEmailSend";
import handleCheckEmail from "../../utils/handleCheckEmail";

const EmailCheckForm = () => {
  const [email, setEmail] = useState("");
  const [emailToken, setEmailToken] = useState("");
  const navigate = useNavigate();

  //이메일 전송 버튼 클릭시 동작
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

  //이메일 인증번호 확인 버튼 클릭시 동작
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
    <div className="emailcheck">
      <form className="emailcheck-form">
        <p className="emailcheck-form-title">비밀번호 재설정</p>
        <div className="emailcheck-container">
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
        <div className="emailcheck-container">
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
