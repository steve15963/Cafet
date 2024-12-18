//문의내용 작성 component

import React, { useState } from "react";
import "./InquiryForm.scoped.css";
import { MdPerson, MdCall } from "react-icons/md";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { InputLabel, MenuItem } from "@mui/material";
import TextField from "@mui/material/TextField";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

import handleSubmit from "../../utils/handleSubmit";

const InquiryForm = () => {
  const [nickname, setNickname] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [category, setCategory] = useState("");
  const navigate = useNavigate();

  //카테고리 변경 handle
  const handleChange = (event) => {
    setCategory(event.target.value);
  };

  //문의하기 버튼 클릭시 동작
  const onSubmitClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleSubmit(
        nickname,
        email,
        phoneNo,
        title,
        content,
        category
      );
      const token = response.data.token;
      console.log("Inquiry submit success", token);
      alert("문의사항이 등록되었습니다.");
      navigate("/", { replace: true });
    } catch (error) {
      console.error("Inquiry submit failed:");
      alert("문의사항 등록에 실패했습니다.");
    }
  };

  return (
    <div className="inquire">
      <form className="inquiry-form">
        <p className="inquiry-form-title">문의하기</p>
        <b>문의자 정보</b>
        <div className="input-container">
          <TextField
            label="이름"
            variant="outlined"
            placeholder="이름을 입력해주세요"
            value={nickname}
            onChange={(e) => setNickname(e.target.value)}
            fullWidth
            size="small"
          />
          <span className="inquiry-icon">
            <MdPerson />
          </span>
        </div>
        <div className="input-container">
          <TextField
            label="이메일"
            placeholder="이메일을 입력해주세요"
            variant="outlined"
            inputProps={{
              type: "email",
            }}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            size="small"
            fullWidth
          />
          <span className="inquiry-icon">
            <svg
              stroke="currentColor"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"
                strokeWidth="2"
                strokeLinejoin="round"
                strokeLinecap="round"
              />
            </svg>
          </span>
        </div>
        <div className="input-container">
          <TextField
            label="전화번호"
            placeholder="전화번호를 입력해주세요"
            variant="outlined"
            value={phoneNo}
            onChange={(e) => setPhoneNo(e.target.value)}
            size="small"
            fullWidth
          />
          <span className="inquiry-icon">
            <MdCall />
          </span>
        </div>
        <br />
        <b>문의 내용</b>
        <div className="input-container">
          <TextField
            label="제목"
            variant="outlined"
            placeholder="제목을 입력해주세요"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            fullWidth
            size="small"
          />
        </div>
        <div className="input-container">
          <FormControl fullWidth size="small">
            <InputLabel id="select-label">분류</InputLabel>
            <Select
              labelId="select-label"
              id="simple-select"
              value={category}
              label="분류"
              onChange={handleChange}
              fullWidth={true}
            >
              <MenuItem value="사이트">사이트</MenuItem>
              <MenuItem value="가게">가게</MenuItem>
              <MenuItem value="기타">기타</MenuItem>
            </Select>
          </FormControl>
        </div>
        <div className="input-container">
          <TextField
            id="outlined-textarea"
            label="문의내용"
            placeholder="내용을 입력해주세요"
            multiline
            value={content}
            onChange={(e) => setContent(e.target.value)}
            fullWidth
            rows={5}
          />
        </div>
        <div className="input-container">
          <Button
            type="common"
            text={"등록하기"}
            className="button"
            onClick={onSubmitClick}
          />
        </div>
      </form>
    </div>
  );
};

export default InquiryForm;
