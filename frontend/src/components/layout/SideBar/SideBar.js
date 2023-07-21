import React from "react";
import "./SideBar.css";

import { Link } from "react-router-dom";

const rectangleStyle = {
  border: "solid",
  borderWidth: "0 0 1px 0",
};

const SideBar = () => {
  return (
    <nav defaultActiveKey="/home" className="SideBar">
      <div style={rectangleStyle}>
        <Link to={"/"}>유저관리</Link>
      </div>
      <div style={rectangleStyle}>
        <Link to={"/"}>업주관리</Link>
      </div>
      <div style={rectangleStyle}>
        <Link to={"/"}>등록요청관리</Link>
      </div>
    </nav>
  );
};

export default SideBar;
