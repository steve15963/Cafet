//비밀번호 업데이트

import axiosCreate from "../axiosCreate";

const handlePasswordUpdate = (email, password) => {
  const data = {
    email: email,
    password: password,
  };

  const serverUrl = "/api/user/changepassword";

  return axiosCreate.put(serverUrl, data);
};

export default handlePasswordUpdate;
