import axios from "axios";

const handleRefreshToken = () => {
  const refreshTokenUrl = "https://i9a105.p.ssafy.io/api/user/token/refresh";

  return axios.post(refreshTokenUrl);
};

export default handleRefreshToken;
