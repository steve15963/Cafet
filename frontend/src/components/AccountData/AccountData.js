//마이페이지 기본 정보 component

import React from "react";
import "./AccountData.scoped.css";
import BasicTabs from "../../components/MyPageTabs/MyPageTabs";
import Grid from "@mui/material/Grid";
import Avatar from "@mui/material/Avatar";
import Container from "@mui/material/Container";
import Button from "../Button/Button";
import { useNavigate } from "react-router-dom";

const AccountData = () => {
  const navigate = useNavigate();

  //임시 이동 handler
  const handleModifyClick = () => {
    navigate("/mypage/modify");
  };

  return (
    <Container maxWidth="lg">
      <div>
        <Grid container spacing={2}>
          <Grid className="xs2" item xs={2}>
            <Avatar
              className="avatar"
              alt=""
              sx={{ width: 150, height: 150 }}
            />
          </Grid>
          <Grid item xs={2} />
          <Grid className="xs10" item xs={8}>
            <p>10</p>
          </Grid>
          {/* 임시로 페이지 이동을 위한 버튼 */}
          <Button
            text={"개인정보 수정"}
            className="button"
            onClick={handleModifyClick}
          />
        </Grid>
      </div>
      <div className="tab-wrapper">
        <BasicTabs />
      </div>
    </Container>
  );
};

export default AccountData;
