import React from "react";
import "./KioskMain.scoped.css";
import { Outlet } from "react-router-dom";

const KioskMain = () => {
  return (
    <div>
      <div className="LoginForm">
        <div className="header-save" />
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMain;
