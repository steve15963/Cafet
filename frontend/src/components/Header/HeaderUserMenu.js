//Header Component

import React from "react";
import "./Header.scoped.css";

import { Link } from "react-router-dom";
import { Divider, Stack } from "@mui/material";

const HeaderUserMenu = () => {
  return (
    <div className="header-link-container">
      <Stack
        direction="row"
        divider={<Divider orientation="vertical" flexItem />}
        spacing={2}
      >
        <Link component="button" className="header-link">
          로그아웃
        </Link>
        <Link to={"/mypage"} className="header-link">
          마이페이지
        </Link>
      </Stack>
    </div>
  );
};

export default HeaderUserMenu;
