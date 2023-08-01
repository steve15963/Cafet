import React, { useState } from "react";
import { TextField } from "@mui/material";
import ManagerUserTable from "../ManagerUserTable/ManageUserTable";
// import Button from "@mui/material/Button";

// const rows = [
//   createData("ssafy@ssafy.com", "싸피맨"),
//   createData("saram@man.com", "팔딱팔딱생사람"),
//   createData("goobal@zerg.net", "링컨 구바러프"),
//   createData("children@drone.net", "오빤 7드론"),
//   createData("skywindragoon@google.com", "하늘바라군"),
//   createData("hightemplar@nexus.com", "장풍도사"),
//   createData("hydra@zerg.net", "칠삼이"),
//   createData("securityman@naver.com", "보이지않는남자"),
//   createData("stabzealot@google.com", "칼빵찔럿"),
//   createData("ingyeo@remainder.com", "잉여"),
//   createData("matthew11@goliath.net", "메튜"),
//   createData("neokillerrobot@naver.com", "네오살인로봇"),
//   createData("petman@little.boy", "팻맨리틀보이"),
//   createData("hoshino@ai.com", "궁극의아이돌"),
//   createData("superconductor@google.com", "초전도체"),
//   createData("z_kick@naver.com", "그걸믿었음쩨트킥"),
// ];

const ManageUsers = () => {
  const [rows, setRows] = useState([
    { email: "asdf@bsdf.com", nickname: "asdf" },
  ]);
  // const [userData, loading] = useManagerUserList();
  console.log("rows: ", rows);
  const handleClick = (e) => {
    setRows();
    e.preventDefault();
  };
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
            label="이름"
            variant="outlined"
            placeholder="이름으로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div className="manage-user-form-div">
          <TextField
            label="닉네임"
            variant="outlined"
            placeholder="닉네임으로 검색"
            fullWidth
            size="small"
          />
        </div>
        <div>
          <button className="manage-user-form-button" onClick={handleClick}>
            검색
          </button>
        </div>

        <p className="signin" />
      </form>
      <ManagerUserTable rows={rows} />
    </div>
  );
};

export default ManageUsers;
