import React from "react";
import "./SideBar.css";

import { Link } from "react-router-dom";

const SideBar = () => {
  return (
    <nav defaultActiveKey="/home" className="SideBar">
      <div className="linkdiv">
        <Link to={"/"}>유저관리</Link>
      </div>
      <div className="linkdiv">
        <Link to={"/"}>업주관리</Link>
      </div>
      <div className="linkdiv">
        <Link to={"/"}>등록요청관리</Link>
      </div>
    </nav>
  );
};

export default SideBar;
