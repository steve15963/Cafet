import axios from "axios";

const handleSignUp = (email, password, phoneNo, nickname) => {
  const data = {
    email: email,
    password: password,
    phoneNo: phoneNo,
    nickname: nickname,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/user/new";

  return axios.post(serverUrl, data);
};

export default handleSignUp;
