import axios from "axios";

const handleRefreshToken = (email, password) => {
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/user/token/refresh";

  return axios.post(serverUrl, data);
};

export default handleRefreshToken;
