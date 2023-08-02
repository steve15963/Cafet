import axios from "axios";

const handleCheckEmail = (mail, mailToken) => {
  // console.log(mail+ " " +mailToken);
  const data = {
    mail: mail,
    mailToken: mailToken,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/mail/check/regist";

  return axios.post(serverUrl, data);
};

export default handleCheckEmail;
