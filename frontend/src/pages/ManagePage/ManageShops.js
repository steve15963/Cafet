import React from "react";
import { TextField } from "@mui/material";
import ManagerShopTable from "./ManageShopTable";

const ManageShops = () => {
  return (
    <div>
      <form class="manage-user-form">
        <div class="manage-user-form-div">
          <TextField
            label="이메일"
            variant="outlined"
            placeholder="이메일로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div class="manage-user-form-div">
          <TextField
            label="가게 이름"
            variant="outlined"
            placeholder="가게 이름으로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div class="manage-user-form-div">
          <TextField
            label="주소"
            variant="outlined"
            placeholder="주소로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div>
          <button class="manage-user-form-button">검색</button>
        </div>

        <p class="signin" />
      </form>
      <ManagerShopTable />
    </div>
  );
};

export default ManageShops;
