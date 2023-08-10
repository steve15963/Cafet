//비밀번호 재설정

import axios from "axios";

const handlePasswordUpdate = (email, password) => {
  console.log("handlePasswordUpdate");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/user/changepassword";

  return axios.put(serverUrl, data);
};

export default handlePasswordUpdate;
