import axios from "axios";

const handleEmailSend = (mail) => {
  // console.log(email);
  const data = {
    mail: mail,
  };

  const serverUrl = "http://i9a105.p.ssafy.io:8080/api/mail/send/regist";

  return axios.post(serverUrl, data);
};

export default handleEmailSend;
