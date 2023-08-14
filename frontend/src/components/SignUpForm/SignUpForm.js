//회원 가입 component

import React, { useState } from "react";
import "./SignUpForm.scoped.css";
import handleSignUp from "../../utils/handleSignUp";
import handleEmailSend from "../../utils/handleEmailSend";
import handleCheckEmail from "../../utils/handleCheckEmail";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const SignUpForm = () => {
  const [mail, setMail] = useState("");
  const [mailToken, setMailToken] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const [nickname, setNickname] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [isEmailVerified, setIsEmailVerified] = useState(false);
  const navigate = useNavigate();

  // 이메일 전송 버튼 클릭 동작
  const onEmailSendClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleEmailSend(mail);
      const token = response.data.token;
      console.log("Email send success", token);
      alert("이메일이 전송되었습니다. 5분 이내에 인증번호를 입력해주세요");
    } catch (error) {
      console.error("Email send failed:");
      alert("이메일 전송에 실패했습니다.");
    }
  };

  // 이메일 인증 버튼 클릭 동작
  const onCheckEmailClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleCheckEmail(mail, mailToken);
      const token = response.data.token;
      console.log("Email Check success", token);
      alert("이메일 인증에 성공했습니다.");
      setIsEmailVerified(true);
    } catch (error) {
      console.error("Email Check failed:");
      alert("이메일 인증에 실패했습니다.");
    }
  };

  //회원가입 버튼 클릭 동작
  const onSignUpButtonClick = async (event) => {
    event.preventDefault();
    if (isEmailVerified) {
      try {
        const response = await handleSignUp(mail, password, phoneNo, nickname);
        const token = response.data.token;
        console.log("SignUp success", token);
        alert("회원가입에 성공하셨습니다.");
        navigate("/login");
      } catch (error) {
        console.error("SignUp failed:", error);
        alert("회원가입에 실패하셨습니다.");
      }
    } else {
      alert(
        "이메일 인증이 완료되지 않았습니다. 이메일 인증을 먼저 진행해주세요."
      );
    }
  };

  return (
    <div className="signup">
      <form className="signup-form">
        <p className="signup-form-title">회원가입</p>
        <div className="signup-container">
          <TextField
            label="이메일"
            placeholder="이메일을 입력해주세요"
            variant="outlined"
            value={mail}
            onChange={(e) => setMail(e.target.value)}
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
        <div className="signup-container">
          <TextField
            label="인증번호"
            placeholder="인증번호를 입력해주세요"
            variant="outlined"
            value={mailToken}
            onChange={(e) => setMailToken(e.target.value)}
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
        <div className="signup-container">
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
        <div className="signup-container">
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
        <div className="signup-container">
          <TextField
            label="닉네임"
            placeholder="닉네임을 입력해주세요"
            variant="outlined"
            value={nickname}
            onChange={(e) => setNickname(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <div className="signup-container">
          <TextField
            label="전화번호"
            placeholder="EX) 01012345678"
            variant="outlined"
            value={phoneNo}
            onChange={(e) => setPhoneNo(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <br />
        <div className="signup-container">
          <Button
            type="common"
            text={"가입하기"}
            className="button"
            onClick={onSignUpButtonClick}
          />
        </div>
      </form>
    </div>
  );
};

export default SignUpForm;
