import "./CreatePage.scoped.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Editor from "../../components/Editor/Editor";
import Button from "../../components/Button/Button";

import { useNavigate } from "react-router-dom";

const CreatePage = () => {
  let navigate = useNavigate();

  const goToBack = () => {
    navigate(-1);
  };

  return (
    <div className="CreatePage">
      <Header />
      <div className="header-save" />
      <Editor className="Editor" />
      <div className="button-wrapper">
        <Button
          className="backBtn"
          text={"뒤로가기"}
          onClick={() => goToBack()}
        />
        <Button className="submitBtn" text={"작성하기"} />
      </div>
      <div className="footer-save" />
      <Footer />
    </div>
  );
};

export default CreatePage;
