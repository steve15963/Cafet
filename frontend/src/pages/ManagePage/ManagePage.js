import React from "react";
import { useParams } from "react-router-dom";
import "./ManagePage.scoped.css";
import SideBar from "./../../components/SideBar/SideBar";
import Header from "./../../components/Header/Header";
import ManageUsers from "../../components/ManageUsers/ManageUsers";
import ManageShops from "./ManageShops";
import ManageRequests from "./ManageRequests";

const ManagePage = () => {
  const { path } = useParams();
  const renderForm = () => {
    if (path === "requests") {
      return <ManageRequests />;
    } else if (path === "shops") {
      return <ManageShops />;
    } else {
      return <ManageUsers />;
    }
  };
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
        {renderForm()}
      </div>
    </div>
  );
};

export default ManagePage;
