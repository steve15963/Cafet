import React from "react";

import "./CreatePage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Editor from "../../components/Editor/Editor";
import { useParams } from "react-router-dom";
import useBoardDetail from "../../hooks/useBoardDetail";

const CreatePage = () => {
  const boardId = useParams();
  const { boardDetail, loading } = useBoardDetail(boardId.id);
  console.log(boardId.id);
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
          defaultCategory={boardDetail.categoryName}
        />
      </div>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default CreatePage;
