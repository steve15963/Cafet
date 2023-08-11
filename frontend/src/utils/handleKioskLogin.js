//login

import axios from "axios";

const handleKioskLogin = (email, password) => {
  console.log("handleKioskLogin");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "http://localhost:8080/api/kiosk/user/login";

  return axios.post(serverUrl, data);
};

export default handleKioskLogin;
