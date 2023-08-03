//관리자 페이지 사이드 바 component

import React from "react";
import "./SideBar.scoped.css";

import { Link } from "react-router-dom";

const SideBar = () => {
  return (
    <nav className="sideBar">
      <div className="linkdiv">
        <Link to={"/manage"}>유저관리</Link>
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
