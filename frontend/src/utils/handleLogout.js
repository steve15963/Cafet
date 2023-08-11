//login

import axios from "axios";

const handleLogout = () => {
  console.log("handleLogout");
  const serverUrl = "https://i9a105.p.ssafy.io/api/user/logout";

  return axios.post(serverUrl);
};

export default handleLogout;
