//login

import axios from "axios";

const handleLogin = (email, password) => {
  console.log("handleLogin");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/user/login";

  return axios.post(serverUrl, data);
};

export default handleLogin;
