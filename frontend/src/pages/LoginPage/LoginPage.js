import React from "react";
import "./LoginPage.css";
import LoginForm from "../../components/LoginForm/LoginForm";
import { Link } from "react-router-dom";

const LoginPage = () => {
  return (
    <div className="LoginForm">
      <div className="logo-container">
        <Link to={"/"}>
          <img src="/images/logo/logo192.png" alt="로고" className="logo" />
        </Link>
        <p>capet</p>
      </div>
      <LoginForm />
    </div>
  );
};

export default LoginPage;
