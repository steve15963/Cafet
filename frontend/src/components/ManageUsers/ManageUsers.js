import React, { useState } from "react";
import { TextField } from "@mui/material";
import ManagerUserTable from "../ManagerUserTable/ManageUserTable";
// import handleManagerUserList from "../../utils/handleManagerUserList";
import useUserList from "../../hooks/useUserList";
import handleManagerUserSearchEmail from "../../utils/handleManagerUserSearchEmail";
import handleManagerUserSearchNickname from "../../utils/handleManagerUserSearchNickname";
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
  // const [rows, searchQuery, loading] = useManagerUserList();

  //eslint-disable-next-line
  const { userList, searchEmail, searchNickname, loading } = useUserList();
  // const { list1 } = handleManagerUserSearchEmail();
  // const { list2 } = handleManagerUserSearchNickname();
  const [nickname, setNickname] = useState("");
  const [email, setEmail] = useState("");

  if (loading) {
    return <div>Loading...</div>;
  }

  // const [rows, setRows] = useState([
  //   // { email: "asdf@bsdf.com", nickname: "asdf" },
  // ]);
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
    try {
      if (email) {
        try {
          //eslint-disable-next-line
          const response = await handleManagerUserSearchEmail(email);
          // list1 = response.data;
        } catch (error) {
          console.log("이메일 검색 에러");
        }
      } else if (nickname) {
        try {
          //eslint-disable-next-line
          const response = await handleManagerUserSearchNickname(nickname);
          // list2 = response.data;
        } catch (error) {
          console.log("닉네임 검색 에러");
        }
      }
      // const response = await handleManagerUserList();
      // // const token = response.data.token;
      // console.log(response.data);
      // // console.log("email: ", response.data.email);
      // // console.log("nickname: ", response.data.nickname);
      // // setRows(response.data);
      // if(email){
      //   try{
      //   }
      //   catch(error){
      //   }
      //   axios.get("http://i9a105.p.ssafy.io/api/user/nickname")
      // }
      // if (nickname) {
      //   axios.get("http://i9a105.p.ssafy.io/api/user/nickname");
      // }
    } catch (error) {
      if (error.response) {
        console.log(error.response.data); // => the response payload
      }
      console.error("Search Failed");
      alert("유저 검색에 실패했습니다.");
    }
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
      {/* <ManagerUserTable rows={list1} />
      <ManagerUserTable rows={list2} /> */}
    </div>
  );
};

export default ManageUsers;
