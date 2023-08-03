import React from "react";
import "./ManagePage.scoped.css";
import Header from "../../components/Header/Header";
import SideBar from "../../components/SideBar/SideBar";
import { Outlet } from "react-router-dom";

const ManagePage = () => {
  return (
    <div>
      <Header />
      <div className="header-save" />
      <div className="manage-box">
        <SideBar />
        <div className="manage-small-header">
          <p>CAPET </p>
          <p>관리자 페이지</p>
        </div>
        <Outlet />
      </div>
    </div>
  );
};

export default ManagePage;
