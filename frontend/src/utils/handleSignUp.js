//회원가입
import axiosCreate from "../axiosCreate";

const handleSignUp = (email, password, phoneNo, nickname) => {
  const data = {
    email: email,
    password: password,
    phoneNo: phoneNo,
    nickname: nickname,
  };

  const serverUrl = "/api/user/new";

  return axiosCreate.post(serverUrl, data);
};

export default handleSignUp;
