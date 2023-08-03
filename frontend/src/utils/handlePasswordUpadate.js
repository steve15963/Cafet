//비밀번호 업데이트(API 미구현 수정 필요)

import axios from "axios";

const handlePasswordUpdate = (email, password) => {
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/user/login";

  return axios.post(serverUrl, data);
};

export default handlePasswordUpdate;
