//login

import axiosCreate from "../axiosCreate";

const handleLogin = (email, password) => {
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "/api/user/login";

  return axiosCreate.post(serverUrl, data);
};

export default handleLogin;
