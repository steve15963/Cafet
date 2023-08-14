//login

import axios from "axios";

const handleKioskLogin = (email, password) => {
  console.log("handleKioskLogin");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/kiosk/user/login";

  return axios.post(serverUrl, data);
};

export default handleKioskLogin;
