import React from "react";
import "./Footer.css";

import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

const Footer = () => {
  return (
    <div>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container className="d-flex justify-content-center w-100">
          <Navbar.Brand href="#">회사소개</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#">제휴제안</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#">이용약관</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#">개인정보처리방침</Navbar.Brand>
          |&nbsp;&nbsp;
          <Navbar.Brand href="#inquire">문의하기</Navbar.Brand>
        </Container>
      </Navbar>
    </div>
  );
};

export default Footer;
