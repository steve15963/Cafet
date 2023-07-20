import React from "react";
import "./Header.css";

import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

const Header = () => {
  return (
    <div>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container fluid>
          <Navbar.Brand href="#">로고</Navbar.Brand>
          <Navbar.Brand
            href="#"
            className="d-flex justify-content-center w-100"
          >
            PET MAN
          </Navbar.Brand>
          <Navbar.Brand href="#login">로그인</Navbar.Brand>
          <Navbar.Brand href="#register">회원가입</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll"></Navbar.Collapse>
        </Container>
      </Navbar>
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
