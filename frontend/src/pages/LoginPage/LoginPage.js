//로그인 페이지

import React from "react";
import "./LoginPage.scoped.css";
import { Link, Outlet } from "react-router-dom";

const LoginPage = () => {
  return (
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
  );
};

export default LoginPage;
