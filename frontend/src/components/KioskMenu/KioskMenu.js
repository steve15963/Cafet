import React from "react";
import "./KioskMenu.scoped.css";
import { Link, Outlet } from "react-router-dom";

const KioskMenu = () => {
  return (
    <div>
      <div className="logo-container">
          <img src="/images/logo/logo192.png" alt="로고" className="logo" />
        <p>capet</p>
      </div>
      <div className="LoginForm">
        <div className="header-save" />
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMenu;
