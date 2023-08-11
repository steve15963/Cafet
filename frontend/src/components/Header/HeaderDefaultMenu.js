//Header Component

import React from "react";
import "./Header.scoped.css";
import Divider from "@mui/material/Divider";

import { Link } from "react-router-dom";
import Stack from "@mui/material/Stack";

const HeaderDefaultMenu = () => {
  return (
    <div className="header-link-container">
      <Stack
        direction="row"
        divider={<Divider orientation="vertical" flexItem />}
        spacing={2}
      >
        <Link to={"/login"} className="header-link">
          로그인
        </Link>
      </Stack>
    </div>
  );
};

export default HeaderDefaultMenu;
