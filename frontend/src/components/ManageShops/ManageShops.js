import React from "react";
import { TextField } from "@mui/material";

import ManagerShopTable from "../ManageShopTable/ManageShopTable";

const ManageShops = () => {
  return (
    <div>
      <form className="manage-user-form">
        <div className="manage-user-form-div">
          <TextField
            label="이메일"
            variant="outlined"
            placeholder="이메일로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div className="manage-user-form-div">
          <TextField
            label="가게 이름"
            variant="outlined"
            placeholder="가게 이름으로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div className="manage-user-form-div">
          <TextField
            label="주소"
            variant="outlined"
            placeholder="주소로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div>
          <button className="manage-user-form-button">검색</button>
        </div>

        <p className="signin" />
      </form>
      <ManagerShopTable />
    </div>
  );
};

export default ManageShops;
