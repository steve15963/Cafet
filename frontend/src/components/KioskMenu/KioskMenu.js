import React from "react";
import "./KioskMenu.scoped.css";
import { Outlet } from "react-router-dom";

const KioskMenu = () => {
  return (
    <div>
      <div >
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMenu;
