import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

import "./CreatePage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Editor from "../../components/Editor/Editor";
import Button from "../../components/Button/Button";

import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import handleCreatePost from "../../utils/handleCreatePost";

const CreatePage = () => {
  let navigate = useNavigate();

  const goToBack = () => {
    navigate(-1);
  };

  const [inputValues, setInputValues] = useState({
    boardTitle: "",
    boardContent: "",
    tagList: [
      {
        tagName: "강아지",
      },
    ],
    nickname: "ssafy123",
    shopTitle: null,
    categoryName: "자유",
    fileUrlList: null,
  });
  console.log(inputValues);

  //제목 변경시 동작
  const onChangeTitle = (e) => {
    setInputValues({
      ...inputValues,
      boardTitle: e.target.value,
    });
  };

  //내용 변경시 동작
  const onChangeContent = (e) => {
    setInputValues({
      ...inputValues,
      boardContent: e.target.value,
    });
  };

  //작성 버튼 클릭 시 동작 (현재 응답이 따로 오지 않아서 성공 실패 판단 불가 백에서 수정 중)
  const onCreateButtonClick = async (event) => {
    event.preventDefault();
    try {
      const response = await handleCreatePost(inputValues);
      const token = response.data.token;
      console.log("Post Create Success", token);
      alert("게시글이 성공적으로 등록되었습니다.");
      navigate("/", { replace: true });
    } catch (error) {
      console.error("Post Create failed");
      alert("게시글 등록에 실패했습니다.");
    }
  };

  return (
    <div className="CreatePage">
      <Header />
      <div className="header-save" />
      <div className="title-wrapper">
        <div className="p" />
        <Box
          className="title-center"
          component="form"
          sx={{
            width: 500,
            maxWidth: "100%",
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            fullWidth
            id="outlined-basic"
            label="제목"
            variant="outlined"
            type="text"
            value={inputValues.boardTitle}
            onChange={onChangeTitle}
          />
        </Box>
        <br />
        <p>{inputValues.boardTitle}</p>
        <div className="title-right" />
      </div>
      <div className="editor-wrapper">
        <Editor onChange={onChangeContent} />
      </div>
      <div className="button-wrapper">
        <Button
          className="backBtn"
          text={"뒤로가기"}
          onClick={() => goToBack()}
        />
        <Button
          className="submitBtn"
          onClick={onCreateButtonClick}
          text={"작성하기"}
        />
      </div>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default CreatePage;
