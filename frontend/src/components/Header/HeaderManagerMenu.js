//Header Component

import React from "react";
import "./Header.scoped.css";

import { Link } from "react-router-dom";
import { Divider, Stack } from "@mui/material";

const HeaderManagerMenu = () => {
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
        <Link to={"/manage"} className="header-link">
          관리자기능
        </Link>
      </Stack>
    </div>
  );
};

export default HeaderManagerMenu;
