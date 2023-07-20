import React from "react";

import Header from "../components/layout/Header/Header";
import Footer from "../components/layout/Footer/Footer";
import Button from "../components/item/Button/Button";

const TestPage = () => {
  return (
    <div>
      <Header />
      <Button
        text={"버튼버튼"}
        onClick={() => {
          alert("클릭했습니다.");
        }}
      />
      <Footer />
    </div>
  );
};

export default TestPage;
