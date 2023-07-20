import React from "react";
import "./Header.css";

import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div>
      <nav className="Header_guest">
        <div class="header-container">
          <Link to={"/"}>
            <img src="images/logo192.png" alt="로고" class="logo" />
          </Link>
          <Link to={"/"}>
            <img src="images/logo512.png" alt="메인로고" class="mainlogo" />
          </Link>
          <Link to={"/LoginPage"} class="login-link">
            로그인
          </Link>
          &nbsp;&nbsp;
          <Link to={"/LoginPage"} class="login-link">
            회원가입
          </Link>
          &nbsp;&nbsp;
        </div>
      </nav>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container className="d-flex justify-content-center w-100">
          <Navbar.Brand href="#animalSearch">동물별로 찾기</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#shopSearch">가게별로 찾기</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#community">커뮤니티</Navbar.Brand>|&nbsp;&nbsp;
          <Navbar.Brand href="#newsFeed">카페소식</Navbar.Brand>|&nbsp;&nbsp;
          <Navbar.Brand href="#search">검색</Navbar.Brand>
        </Container>
      </Navbar>
    </div>
  );
};

export default Header;
