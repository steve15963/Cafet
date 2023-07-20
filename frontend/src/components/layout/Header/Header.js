import React from "react";
import "./Header.css";

import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div>
      <nav className="Header_guest">
        <div class="header-container">
          <div class="logo-container">
            <Link to={"/"}>
              <img src="images/logo192.png" alt="로고" class="logo" />
            </Link>
          </div>
          <div class="mainlogo-container">
            <Link to={"/"}>
              <img src="images/logo512.png" alt="메인로고" class="mainlogo" />
            </Link>
          </div>
          <div class="link-container">
            <Link to={"/LoginPage"} class="link">
              로그인
            </Link>
            &nbsp;&nbsp;
            <Link to={"/LoginPage"} class="link">
              회원가입
            </Link>
          </div>
        </div>
      </nav>
      <nav className="Header_category">
        <div>
          <Link to={"/LoginPage"} class="link">
            동물별로 찾기
          </Link>
          &nbsp;&nbsp;| &nbsp;
          <Link to={"/LoginPage"} class="link">
            가게별로 찾기
          </Link>
          &nbsp;&nbsp;| &nbsp;
          <Link to={"/LoginPage"} class="link">
            커뮤니티
          </Link>
          &nbsp;&nbsp;| &nbsp;
          <Link to={"/LoginPage"} class="link">
            카페소식
          </Link>
          &nbsp;&nbsp;| &nbsp;
          <Link to={"/LoginPage"} class="link">
            검색
          </Link>
        </div>
      </nav>
    </div>
  );
};

export default Header;
