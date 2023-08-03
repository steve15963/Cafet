import React from "react";
import "./Header.scoped.css";

import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div className="header">
      <nav className="header_guest">
        <div className="header-container">
          <div className="header-logo-container">
            <Link to={"/"}>
              <img
                src="/images/logo/logo192.png"
                alt="로고"
                className="header-logo"
              />
            </Link>
            <p>capet</p>
          </div>
          <div className="header-category-container">
            <div>
              <Link to={"/login"} className="header-link">
                동물별로 찾기
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="header-link">
                가게별로 찾기
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/board"} className="header-link">
                커뮤니티
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="header-link">
                카페소식
              </Link>
              &nbsp;&nbsp;| &nbsp;
              <Link to={"/login"} className="header-link">
                검색
              </Link>
            </div>
          </div>
          <div className="header-link-container">
            <Link to={"/login"} className="header-link">
              로그인
            </Link>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default Header;
