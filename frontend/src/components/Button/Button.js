//버튼 component

import React from "react";
import "./Button.scoped.css";

const Button = ({ text, type, onClick }) => {
  const btnType = ["common"].includes(type) ? type : "default";

  return (
    <button className={[`button_${btnType}`].join(" ")} onClick={onClick}>
      {text}
    </button>
  );
};

export default Button;
