import React, { useState } from "react";
import { TextField } from "@mui/material";

import ManagerShopTable from "./ManageShopTable";
import useShopList from "../../hooks/useShopList";

const ManageShops = () => {
  const { shopList, setQuery, loading } = useShopList();
  const [shopTitle, setShopTitle] = useState("");
  const [address, setAddress] = useState("");

  if (loading) {
    return <div>Loading...</div>;
  }

  const onChangeShopTitle = (e) => {
    setShopTitle(e.target.value);
  };
  const onChangeAddress = (e) => {
    setAddress(e.target.value);
  };

  const onHandleClick = async (event) => {
    event.preventDefault();
    setQuery({ shopTitle, address });
    setShopTitle("");
    setAddress("");
  };

  return (
    <div>
      <form className="manage-user-form">
        <div className="manage-user-form-div">
          <TextField
            label="가게 이름"
            variant="outlined"
            placeholder="가게 이름으로 검색"
            fullWidth
            size="small"
            onChange={onChangeShopTitle}
          />
        </div>
        <div className="manage-user-form-div">
          <TextField
            label="주소"
            variant="outlined"
            placeholder="주소로 검색"
            fullWidth
            size="small"
            onChange={onChangeAddress}
          />
        </div>
        <div>
          <button className="manage-user-form-button" onClick={onHandleClick}>
            검색
          </button>
        </div>

        <p className="signin" />
      </form>
      <ManagerShopTable rows={shopList} />
    </div>
  );
};

export default ManageShops;
