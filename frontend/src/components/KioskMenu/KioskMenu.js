import React from "react";
import { Outlet } from "react-router-dom";

const KioskMenu = () => {
  return (
    <div>
      <div>
        <Outlet />
      </div>
    </div>
  );
};

export default KioskMenu;
