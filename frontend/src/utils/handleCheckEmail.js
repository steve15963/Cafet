//인증번호 유효성 검사

import axiosCreate from "../axiosCreate";

const handleCheckEmail = (mail, mailToken) => {
  // console.log(mail+ " " +mailToken);
  const data = {
    mail: mail,
    mailToken: mailToken,
  };

  const serverUrl = "/api/mail/check/regist";

  return axiosCreate.post(serverUrl, data);
};

export default handleCheckEmail;
