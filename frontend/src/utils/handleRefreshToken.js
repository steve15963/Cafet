import axiosCreate from "../axiosCreate";

const handleRefreshToken = () => {
  const refreshTokenUrl = "/user/token/refresh";

  return axiosCreate.post(refreshTokenUrl);
};

export default handleRefreshToken;
