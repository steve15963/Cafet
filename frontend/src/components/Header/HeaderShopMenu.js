//Header Component

import React from "react";
import "./Header.scoped.css";
import { useCookies } from "react-cookie";

import { Link } from "react-router-dom";
import { Divider, Stack } from "@mui/material";

const HeaderShopMenu = () => {
  const [removeCookies] = useCookies();

  const onLogoutClick = (event) => {
    event.preventDefault();
    localStorage.removeItem("userId");
    localStorage.removeItem("level");
    removeCookies("accessToken");
    removeCookies("refreshToken");
    console.log("Logout success : ");
    alert("로그아웃에 성공하셨습니다.");
    window.location.reload();
  };

  return (
    <div className="header-link-container">
      <Stack
        direction="row"
        divider={<Divider orientation="vertical" flexItem />}
        spacing={2}
      >
        <Link
          component="button"
          className="header-link"
          onClick={onLogoutClick}
        >
          로그아웃
        </Link>
        <Link to={"/mypage"} className="header-link">
          가게 페이지
        </Link>
      </Stack>
    </div>
  );
};

export default HeaderShopMenu;
