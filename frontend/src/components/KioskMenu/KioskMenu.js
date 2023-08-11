import React from "react";
import "./KioskMenu.scoped.css";
import { Outlet } from "react-router-dom";

const KioskMenu = () => {
  return (
    <div>
      {" "}
      <div className="LoginForm">
        <div className="header-save" />
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMenu;
