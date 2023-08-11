//이메일 인증을 위한 component

import React, { useState } from "react";
import "./EmailCheckForm.scoped.css";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

import handleEmailSend from "../../utils/handleEmailSend";
import handleCheckEmail from "../../utils/handleCheckEmail";
import handlePasswordUpdate from "../../utils/handlePasswordUpadate";

const EmailCheckForm = () => {
  const [email, setEmail] = useState("");
  const [emailToken, setEmailToken] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const navigate = useNavigate();

  //이메일 전송 버튼 클릭시 동작
  const onEmailSendClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleEmailSend(email);
      console.log("Email send success", response);
      alert("이메일이 전송되었습니다. 15분 이내에 인증번호를 입력해주세요");
    } catch (error) {
      console.error("Email send failed:");
      alert("이메일 전송에 실패했습니다.");
    }
  };

  const onPasswordUpdateClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleCheckEmail(email, emailToken);
      console.log("Email Check success", response);
      try {
        //eslint-disable-next-line
        const loginResponse = await handlePasswordUpdate(email, password);
        console.log("Password Modify success");
        alert("비밀번호 재설정에 성공하셨습니다.");
        navigate("/", { replace: true });
      } catch (error) {
        console.error("Password Modify failed");
        alert("비밀번호 재설정에 실패하셨습니다.");
      }
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
        </div>
      </form>
      <form className="repassword-form">
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
            text={"비밀번호 변경"}
            className="button"
            onClick={onPasswordUpdateClick}
          />
        </div>
      </form>
    </div>
  );
};

export default EmailCheckForm;
