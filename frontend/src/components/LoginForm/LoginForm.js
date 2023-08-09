//로그인을 위한 component

import React, { useState } from "react";
import handleLogin from "../../utils/handleLogin";
import "./LoginForm.scoped.css";
import TextField from "@mui/material/TextField";
import { Link, useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  //로그인 버튼 클릭시 동작
  const onLoginButtonClick = async (event) => {
    event.preventDefault();
    try {
      //eslint-disable-next-line
      const response = await handleLogin(email, password);
      localStorage.setItem("userId", response.data.userId);
      localStorage.setItem("level", response.data.level);
      console.log("Login success : ");
      alert("로그인에 성공하셨습니다.");
      navigate("/", { replace: true });
    } catch (error) {
      console.error("Login failed:");
      alert("로그인에 실패하셨습니다.");
      setEmail("");
      setPassword("");
    }
  };

  return (
    <div className="login">
      <form className="login-form">
        <p className="login-form-title">로그인</p>
        <div className="login-container">
          <TextField
            label="이메일"
            placeholder="이메일을 적어주세요"
            variant="outlined"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <div className="login-container">
          <TextField
            type="password"
            label="비밀번호"
            placeholder="비밀번호를 입력해주세요"
            variant="outlined"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <br />
        <div className="login-container">
          <Button
            type="common"
            text={"입력하기"}
            className="button"
            onClick={onLoginButtonClick}
          />
        </div>
        <div className="login-container">
          <div>
            <Link to={"/login/password"} className="link">
              비밀번호 찾기
            </Link>
            &nbsp;&nbsp;| &nbsp;
            <Link to={"/login/signup"} className="link">
              회원가입
            </Link>
          </div>
        </div>
      </form>
    </div>
  );
};

export default LoginForm;
