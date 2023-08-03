//login

import axios from "axios";

const handleLogin = (email, password) => {
  // console.log(email + " " + password + " handle");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/user/login";

  return axios.post(serverUrl, data);
};

export default handleLogin;
