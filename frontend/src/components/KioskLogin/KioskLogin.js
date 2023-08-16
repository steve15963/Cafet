//로그인을 위한 component

import React, { useState } from "react";
import handleKioskLogin from "../../utils/handleKioskLogin";
import "./KioskLogin.scoped.css";
import TextField from "@mui/material/TextField";
import { Link, useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const KioskLogin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  //로그인 버튼 클릭시 동작
  const onLoginButtonClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleKioskLogin(email, password);
      console.log(response.headers);
      localStorage.setItem("shopId", response.data.shopId);
      localStorage.setItem("levelCode", response.data.levelCode);
      localStorage.setItem(
        "sessionToken",
        response.headers.get("Authorization")
      );
      console.log("Login success : ");
      alert("로그인에 성공하셨습니다.");
      navigate("/kiosk/list", { replace: true });
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
        <p className="login-form-title">키오스크 로그인</p>
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
          </div>
        </div>
      </form>
    </div>
  );
};

export default KioskLogin;
