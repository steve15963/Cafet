import React from "react";
import "./Header.css";

import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div className="Header">
      <nav className="Header_guest">
        <div className="header-container">
          <div className="logo-container">
            <Link to={"/"}>
              <img
                src="../assets/images/logo192.png"
                alt="로고"
                className="logo"
              />
            </Link>
            <p>capet</p>
          </div>
          <div className="mainlogo-container">
            <div>
              <Link to={"/login"} className="link">
                동물별로 찾기
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="link">
                가게별로 찾기
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/board"} className="link">
                커뮤니티
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="link">
                카페소식
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="link">
                검색
              </Link>
            </div>
          </div>
          <div className="link-container">
            <Link to={"/login"} className="link">
              로그인
            </Link>
            &nbsp;&nbsp;
            <Link to={"/login"} className="link">
              회원가입
            </Link>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default Header;
