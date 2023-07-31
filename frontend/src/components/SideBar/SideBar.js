import React from "react";
import "./SideBar.scoped.css";

import { Link } from "react-router-dom";

const SideBar = () => {
  return (
    <nav defaultActiveKey="/home" className="SideBar">
      <div className="linkdiv">
        <Link to={"/manage/users"}>유저관리</Link>
      </div>
      <div className="linkdiv">
        <Link to={"/manage/shops"}>업주관리</Link>
      </div>
      <div className="linkdiv">
        <Link to={"/manage/requests"}>등록요청관리</Link>
      </div>
    </nav>
  );
};

export default SideBar;
