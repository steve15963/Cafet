import axiosCreate from "../axiosCreate";

const handleRefreshToken = () => {
  const refreshTokenUrl = "/api/user/token/refresh";

  return axiosCreate.post(refreshTokenUrl);
};

export default handleRefreshToken;
