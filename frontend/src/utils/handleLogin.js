//login

import axios from "axios";
axios.defaults.withCredentials = true;

const handleLogin = (email, password) => {
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "http://i9a105.p.ssafy.io/api/user/login";

  axios
    .post(serverUrl, data)
    .then((response) => {
      const { accessToken } = response.data;
      console.log(accessToken);
      axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;
    })
    .catch((error) => {});
};

export default handleLogin;
