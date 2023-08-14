import axios from "axios";

const handleRefreshToken = () => {
  const serverUrl = "https://i9a105.p.ssafy.io/api/user/token/refresh";

  return axios.post(serverUrl);
};

export default handleRefreshToken;
