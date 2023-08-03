import React, { useState } from "react";
import "./AccountSettings.scoped.css";
import handleUserUpdate from "../../utils/handleUserUpdate";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const AccountSettings = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const [nickname, setNickname] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [fileUrl, setFileUrl] = useState("");
  const navigate = useNavigate();

  const onUpdateClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleUserUpdate(
        email,
        nickname,
        phoneNo,
        fileUrl
      );
      const token = response.data.token;
      console.log("Update success", token);
      alert("회원정보 수정에 성공하셨습니다.");
      navigate("/mypage");
    } catch (error) {
      console.error("Update failed:", error);
      alert("회원정보 수정에 실패하셨습니다.");
    }
  };

  return (
    <div className="acsettings">
      <form className="acsettings-form">
        <p className="acsettings-form-title">회원 정보 수정</p>
        <div className="acsettings-container">
          <TextField
            label="이메일"
            placeholder="이메일을 입력해주세요"
            variant="outlined"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <div className="acsettings-container">
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
        <div className="acsettings-container">
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
        <div className="acsettings-container">
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
        <div className="acsettings-container">
          <TextField
            label="전화번호"
            placeholder="전화번호를 입력해주세요"
            variant="outlined"
            value={phoneNo}
            onChange={(e) => setPhoneNo(e.target.value)}
            size="small"
            fullWidth
          />
        </div>
        <br />
        <div className="acsettings-container">
          <Button
            type="common"
            text={"수정하기"}
            className="button"
            onClick={onUpdateClick}
          />
        </div>
      </form>
    </div>
  );
};

export default AccountSettings;
