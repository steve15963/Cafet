import React from "react";
import { Link } from "react-router-dom";

import Header from "../components/Header/Header";
import Button from "../components/Button/Button";

const MainPage = () => {
  return (
    <div>
      <Header />
      메인페이지
      <br />
      <Link to="/testpage">
        <Button text={"테스트 페이지로 이동"} />
      </Link>
    </div>
  );
};

export default MainPage;
