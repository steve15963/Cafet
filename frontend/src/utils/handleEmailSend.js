//이메일 인증

import axiosCreate from "../axiosCreate";

const handleEmailSend = (mail) => {
  // console.log(email);
  const data = {
    mail: mail,
  };

  const serverUrl = "/api/mail/send/regist";

  return axiosCreate.post(serverUrl, data);
};

export default handleEmailSend;
