import React from "react";
import "./KioskMain.scoped.css";
import { Link, Outlet } from "react-router-dom";

const KioskMain = () => {
  return (
    <div>
      {" "}
      <div className="LoginForm">
        <div className="header-save" />
        <div className="logo-container">
          <Link to={"/"}>
            <img src="/images/logo/logo192.png" alt="로고" className="logo" />
          </Link>
          <p>capet</p>
        </div>
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMain;
