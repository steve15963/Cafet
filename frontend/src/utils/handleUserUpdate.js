import axios from "axios";

const handleUserUpdate = (email, nickname, phoneNo, fileUrl) => {
  const data = {
    email: email,
    nickname: nickname,
    phoneNo: phoneNo,
    fileUrl: fileUrl,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/user";

  return axios.put(serverUrl, data);
};

export default handleUserUpdate;
