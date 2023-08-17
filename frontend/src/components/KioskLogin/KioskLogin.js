//로그인을 위한 component

import React, { useState, useRef, useEffect } from "react";
import handleKioskLogin from "../../utils/handleKioskLogin";
import "./KioskLogin.scoped.css";
import TextField from "@mui/material/TextField";
import { Link, useNavigate } from "react-router-dom";
import Button from "../Button/Button";

import KioskBoard from "kioskboard";

const KioskLogin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  //키오스크 키보드
  const keyboardRef = useRef(null);
  const numpadRef = useRef(null);
  useEffect(() => {
    if (keyboardRef.current) {
      KioskBoard.run(keyboardRef.current, {
        language: "en",
        theme: "material", capsLockActive: false, keysFontSize: '40px',
        keysArrayOfObjects: [
          {
            "0": "0",
            "1": "1",
            "2": "2",
            "3": "3",
            "4": "4",
            "5": "5",
            "6": "6",
            "7": "7",
            "8": "8",
            "9": "9"
          },
          {
            "0": "q",
            "1": "w",
            "2": "e",
            "3": "r",
            "4": "t",
            "5": "y",
            "6": "u",
            "7": "i",
            "8": "o",
            "9": "p"
          },
          {
            "0": "a",
            "1": "s",
            "2": "d",
            "3": "f",
            "4": "g",
            "5": "h",
            "6": "j",
            "7": "k",
            "8": "l"
          },
          {
            "0": "z",
            "1": "x",
            "2": "c",
            "3": "v",
            "4": "b",
            "5": "n",
            "6": "m",
            "7":"@",
            "8":"."
          }
        ]
      });
    }
  }, [keyboardRef]);

  useEffect(() => {
    if (numpadRef.current) {
      KioskBoard.run(numpadRef.current, {
        language: "en",
        theme: "material",  capsLockActive: false, keysFontSize: '40px',
        keysArrayOfObjects: [
          {
            "0": "0",
            "1": "1",
            "2": "2",
            "3": "3",
            "4": "4",
            "5": "5",
            "6": "6",
            "7": "7",
            "8": "8",
            "9": "9"
          },
          {
            "0": "q",
            "1": "w",
            "2": "e",
            "3": "r",
            "4": "t",
            "5": "y",
            "6": "u",
            "7": "i",
            "8": "o",
            "9": "p"
          },
          {
            "0": "a",
            "1": "s",
            "2": "d",
            "3": "f",
            "4": "g",
            "5": "h",
            "6": "j",
            "7": "k",
            "8": "l"
          },
          {
            "0": "z",
            "1": "x",
            "2": "c",
            "3": "v",
            "4": "b",
            "5": "n",
            "6": "m",
          }
        ]
      });
    }
  }, [numpadRef]);




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
      <div className="logo-container">
        <Link to={"/"}>
          <img src="/images/logo/logo192.png" alt="로고" className="logo" />
        </Link>
        <p>capet</p>
      </div>

      <form className="login-form">
        <p className="login-form-title">키오스크 로그인</p>
        <div className="login-container">
        <input
        className="inputFromKey"
        ref={keyboardRef}
        type="text"
        label="이메일"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        data-kioskboard-type="keyboard"
        placeholder="이메일"
      />
      <input
        className="inputFromKey"
        ref={numpadRef}
        type="text"
        variant="outlined"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        data-kioskboard-type="keyboard"
        placeholder="비밀번호"
      />
          {/* <TextField
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
          /> */}
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
