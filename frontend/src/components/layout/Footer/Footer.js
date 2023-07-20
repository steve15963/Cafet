import React from "react";
import "./Footer.css";

import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <div>
      <nav className="Footer">
        <div class="footer-container">
          <p class="text">
            회사소개 | 제휴제안 | 이용약관 | 개인정보처리방침 |
          </p>
          &nbsp;
          <Link to={"/LoginPage"} class="link">
            문의하기
          </Link>
        </div>
      </nav>
    </div>
  );
};

export default Footer;
