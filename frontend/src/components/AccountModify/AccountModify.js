//회원정보 수정을 위한 component

import React, { useState } from "react";
import "./AccountModify.scoped.css";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

import handleUserUpdate from "../../utils/handleUserUpdate";

const AccountSettings = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordCheck, setPasswordCheck] = useState("");
  const [nickname, setNickname] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [file, setFile] = useState(null);
  const navigate = useNavigate();

  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    setFile(selectedFile);
  };
  const userId = localStorage.getItem("userId");


  //회원정보 수정버튼 클릭시 동작
  const onUpdateClick = async (event) => {
    event.preventDefault();
    try {
      console.log("react " + email + nickname + phoneNo + file);
      const response = await handleUserUpdate(email, nickname, phoneNo, file);
      const token = response.data.token;
      console.log("Update success", token);
      alert("회원정보 수정에 성공하셨습니다.");
      navigate(`/mypage/:${userId}`, { replace: true });
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
          <label htmlFor="fileInput">프로필 사진 선택</label>
          <input
            type="file"
            id="fileInput"
            onChange={handleFileChange}
            accept="image/*"
          />
        </div>
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
