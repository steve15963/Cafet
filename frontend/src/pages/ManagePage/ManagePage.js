import React from "react";
import { useParams } from "react-router-dom";
import "./ManagePage.scoped.css";
import SideBar from "./../../components/SideBar/SideBar";
import Header from "./../../components/Header/Header";
import ManageUsers from "./ManageUsers";
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
      <SideBar />
      {renderForm()}
    </div>
  );
};

export default ManagePage;
