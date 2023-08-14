//login

import axiosCreate from "../axiosCreate";

const handleKioskLogin = (email, password) => {
  console.log("handleKioskLogin");
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/kiosk/user/login";

  return axiosCreate.post(serverUrl, data);
};

export default handleKioskLogin;
