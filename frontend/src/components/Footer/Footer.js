import React from "react";
import "./Footer.scoped.css";

import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <div className="Footer">
      <nav className="footer-common">
        <div className="footer-container">
          <p className="text">
            회사소개 | 제휴제안 | 이용약관 | 개인정보처리방침 |
          </p>
          &nbsp;
          <Link to={"/inquiry"} className="link">
            <p className="text">문의하기</p>
          </Link>
        </div>
      </nav>
    </div>
  );
};

export default Footer;
