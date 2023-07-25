import React from "react";
import "./InputForm.css";
import Button from "../Button/Button";

const InputForm = ({ text, inputType }) => {
  const inputClass = `inputType_${inputType}`;
  return (
    <div className="inputForm">
      <input className={inputClass} type="text" placeholder={text} />
      <Button className="input_button" text={"입력하기"} />
    </div>
  );
};

export default InputForm;
