import React from "react";
import { TextField } from "@mui/material";

import ManagerShopTable from "../ManageShopTable/ManageShopTable";
import useShopList from "./../../hooks/useShopList";

const ManageShops = () => {
  const { shopList, loading } = useShopList();
  // const [nickname, setNickname] = useState("");
  // const [email, setEmail] = useState("");

  if (loading) {
    return <div>로딩중...</div>;
  }
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
      <ManagerShopTable rows={shopList} />
    </div>
  );
};

export default ManageShops;
