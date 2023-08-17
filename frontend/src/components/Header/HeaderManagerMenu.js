//Header Component

import React from "react";
import "./Header.scoped.css";
import handleLogout from "../../utils/handleLogout";
import { Link } from "react-router-dom";
import { Divider, Stack } from "@mui/material";

const HeaderManagerMenu = () => {
  const onLogoutClick = async (event) => {
    event.preventDefault();
    try {
      console.log("logout");
      //eslint-disable-next-line
      const response = await handleLogout();
      // console.log(response);
      localStorage.removeItem("userId");
      localStorage.removeItem("level");
      // console.log("sessionToken 삭제");
      localStorage.removeItem("sessionToken");
      // console.log("sessionToken 삭제완료");
      console.log("Logout success : ");
      alert("로그아웃에 성공하셨습니다.");
      window.location.reload();
    } catch (error) {
      console.error("Logout failed:");
      alert("로그아웃에 실패하셨습니다.");
    }
  };
  const userId = localStorage.getItem("userId");

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
        <Link to={`/mypage/${userId}`} className="header-link">
          마이페이지
        </Link>
        <Link to={"/manage"} className="header-link">
          관리자페이지
        </Link>
      </Stack>
    </div>
  );
};

export default HeaderManagerMenu;
