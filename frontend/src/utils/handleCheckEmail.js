//인증번호 유효성 검사

import axios from "axios";

const handleCheckEmail = (mail, mailToken) => {
  // console.log(mail+ " " +mailToken);
  const data = {
    mail: mail,
    mailToken: mailToken,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/mail/check/regist";

  return axios.post(serverUrl, data);
};

export default handleCheckEmail;
