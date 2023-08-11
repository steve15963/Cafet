//login

import axiosCreate from "../axiosCreate";

const handleLogout = () => {
  console.log("handleLogout");
  const serverUrl = "https://i9a105.p.ssafy.io/api/user/logout";

  return axiosCreate.post(serverUrl);
};

export default handleLogout;
