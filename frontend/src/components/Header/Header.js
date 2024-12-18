//Header Component

import React from "react";
import "./Header.scoped.css";
import Divider from "@mui/material/Divider";

import { Link } from "react-router-dom";
import Stack from "@mui/material/Stack";
import HeaderDefaultMenu from "./HeaderDefaultMenu";
import HeaderUserMenu from "./HeaderUserMenu";
import HeaderShopMenu from "./HeaderShopMenu";
import HeaderManagerMenu from "./HeaderManagerMenu";

const Header = () => {
  // type = "manager";
  // type = "shop";
  // type = "user";
  const level = localStorage.getItem("level");

  const chooseMenu = () => {
    switch (level) {
      case "100":
        return <HeaderUserMenu />;
      case "200":
        return <HeaderShopMenu />;
      case "300":
        return <HeaderManagerMenu />;
      default:
        return <HeaderDefaultMenu />;
    }
  };

  const handleIndexClick = (index) => {
    sessionStorage.setItem("index", index);
  };

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
              <Stack
                direction="row"
                divider={<Divider orientation="vertical" flexItem />}
                spacing={2}
              >
                <Link to={"/search"} className="header-link">
                  카페 찾기
                </Link>
                <Link
                  to={"/board"}
                  className="header-link"
                  onClick={() => handleIndexClick(0)}
                >
                  전체게시판
                </Link>
                <Link
                  to={"/board"}
                  className="header-link"
                  onClick={() => handleIndexClick(1)}
                >
                  자유게시판
                </Link>
                <Link
                  to={"/board"}
                  className="header-link"
                  onClick={() => handleIndexClick(2)}
                >
                  질문게시판
                </Link>
                <Link
                  to={"/board"}
                  className="header-link"
                  onClick={() => handleIndexClick(3)}
                >
                  홍보게시판
                </Link>
              </Stack>
            </div>
          </div>
          {chooseMenu(level)}
        </div>
      </nav>
    </div>
  );
};

export default Header;
