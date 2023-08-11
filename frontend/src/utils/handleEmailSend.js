//이메일 인증

import axios from "axios";

const handleEmailSend = (mail) => {
  console.log("handleEmailSend");
  const data = {
    mail: mail,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/mail/send/regist";

  return axios.post(serverUrl, data);
};

export default handleEmailSend;
