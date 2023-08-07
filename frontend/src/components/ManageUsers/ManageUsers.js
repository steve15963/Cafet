import React, { useState } from "react";
import { TextField } from "@mui/material";
import ManagerUserTable from "../ManagerUserTable/ManageUserTable";
import useUserList from "../../hooks/useUserList";

const ManageUsers = () => {
  const { userList, setQuery, loading } = useUserList();
  const [nickname, setNickname] = useState("");
  const [email, setEmail] = useState("");

  if (loading) {
    return <div>Loading...</div>;
  }

  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };
  const onChangeEmail = (e) => {
    setEmail(e.target.value);
  };
  console.log("email", email);
  console.log("nickname", nickname);

  const onHandleClick = async (event) => {
    event.preventDefault();
    setQuery({ email, nickname });
    setEmail("");
    setNickname("");
  };

  console.log("rows: ", userList);
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
            onChange={onChangeEmail}
          />
        </div>
        <div className="manage-user-form-div">
          <TextField
            label="닉네임"
            variant="outlined"
            placeholder="닉네임으로 검색"
            fullWidth
            size="small"
            onChange={onChangeNickname}
          />
        </div>
        <div>
          <button className="manage-user-form-button" onClick={onHandleClick}>
            검색
          </button>
        </div>

        <p className="signin" />
      </form>
      <ManagerUserTable rows={userList} />
    </div>
  );
};

export default ManageUsers;
