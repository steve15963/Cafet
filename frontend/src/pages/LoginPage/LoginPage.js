import React from "react";
import "./LoginPage.scoped.css";
import LoginForm from "../../components/LoginForm/LoginForm";
import SignUpForm from "../../components/SignUpForm/SignUpForm";
import EmailCheckForm from "../../components/EmailCheckForm/EmailCheckForm";
import RePasswordForm from "../../components/RePassword/RePassword";
import { Link, useParams } from "react-router-dom";

const LoginPage = () => {
  const { path } = useParams();
  // console.log(path);

  const renderForm = () => {
    if (path === "signup") {
      return <SignUpForm />;
    } else if (path === "password") {
      return <EmailCheckForm />;
    } else if (path === "repassword") {
      return <RePasswordForm />;
    } else {
      return <LoginForm />;
    }
  };

  return (
    <div className="LoginForm">
      <div className="header-save" />
      <div className="logo-container">
        <Link to={"/"}>
          <img src="/images/logo/logo192.png" alt="로고" className="logo" />
        </Link>
        <p>capet</p>
      </div>
      {renderForm()}
    </div>
  );
};

export default LoginPage;
