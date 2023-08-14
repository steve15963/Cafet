import React, { useState } from "react";
// import { useNavigate } from "react-router-dom";

import "./CreatePage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Editor from "../../components/Editor/Editor";
import { useParams } from "react-router-dom";
import useBoardDetail from "../../hooks/useBoardDetail";
// import axiosCreate from "../../axiosCreate";

const CreatePage = () => {
  const boardId = useParams();
  const { boardDetail, loading } = useBoardDetail(boardId.id);
  // let navigate = useNavigate();

  // const goToBack = () => {
  //   navigate(-1);
  // };
  console.log(boardId.id);

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
  // console.log(inputValues);

  //내용 변경시 동작
  const onChangeContent = (e) => {
    setInputValues({
      ...inputValues,
      boardContent: e.target.value,
    });
  };

  if (loading) {
    return <div>로딩중...</div>;
  }

  return (
    <div className="CreatePage">
      <Header />
      <div className="header-save" />
      <div className="editor-wrapper">
        <Editor
          boardId={boardId.id}
          title={boardDetail.boardTitle}
          value={boardDetail.boardContent}
          onChange={onChangeContent}
        />
      </div>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default CreatePage;
