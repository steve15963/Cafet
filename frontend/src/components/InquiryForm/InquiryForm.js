import React from "react";
import "./InquiryForm.css";
import { MdPerson, MdCall } from "react-icons/md";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { InputLabel, MenuItem } from "@mui/material";
import TextField from "@mui/material/TextField";

const InquiryForm = () => {
  const [category, setCategory] = React.useState("");

  const handleChange = (event) => {
    setCategory(event.target.value);
  };
  const handleSubmit = (e) => {
    alert("문의사항이 등록되었습니다.");
    e.preventDefault();
  };
  return (
    <div className="inquiryForm">
      <form className="form">
        <p className="form-title">문의하기</p>
        <b>문의자 정보</b>
        <div className="input-container">
          <TextField
            id="outlined-basic"
            label="이름"
            variant="outlined"
            placeholder="이름을 쓰세요"
            fullWidth
          />
          <span className="icon">
            <MdPerson />
          </span>
        </div>
        <div className="input-container">
          <TextField
            id="outlined-basic"
            label="이메일"
            placeholder="이메일을 쓰세요"
            variant="outlined"
            inputProps={{
              type: "email",
            }}
            fullWidth
          />
          <span className="icon">
            <svg
              stroke="currentColor"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"
                stroke-width="2"
                stroke-linejoin="round"
                stroke-linecap="round"
              ></path>
            </svg>
          </span>
        </div>
        <div className="input-container">
          <TextField
            id="outlined-basic"
            label="전화번호"
            placeholder="전화번호를 적으세요"
            variant="outlined"
            fullWidth
          />
          <span className="icon">
            <MdCall />
          </span>
        </div>
        <br />
        <b>문의 내용</b>
        <div className="input-container">
          <TextField
            id="outlined-basic"
            label="제목"
            variant="outlined"
            placeholder="제목을 쓰세요"
            fullWidth
          />
        </div>
        <div className="input-container">
          <FormControl fullWidth>
            <InputLabel id="select-label">분류</InputLabel>
            <Select
              labelId="select-label"
              id="simple-select"
              value={category}
              label="분류"
              onChange={handleChange}
              fullWidth={true}
            >
              <MenuItem value="사이트 개선">사이트 개선</MenuItem>
              <MenuItem value="오류 제보">오류 제보</MenuItem>
              <MenuItem value="사용자 신고">사용자 신고</MenuItem>
              <MenuItem value="기타 개선">기타 개선</MenuItem>
            </Select>
          </FormControl>
        </div>

        <div className="input-container">
          <TextField
            id="outlined-textarea"
            label="문의내용"
            placeholder="내용을 입력하세요"
            multiline
            fullWidth
            rows={5}
          />
        </div>
        <button class="submit" onClick={handleSubmit}>
          등록하기
        </button>
      </form>
    </div>
  );
};

export default InquiryForm;
