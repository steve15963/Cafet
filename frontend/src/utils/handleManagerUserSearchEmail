// import axios from "axios";

// const handleManagerUserList = (email, nickname) => {
//   const data = { email, nickname };
//   //`http://i9a105.p.ssafy.io:8080/api/user?nickname=${nickname}&email=${email}`;
//   //   const serverUrl = `http://localhost:8080/api/user?nickname=${nickname}&email=${email}`;
//   //   let serverUrl = `http://localhost:8080/api/user`;

//   const serverUrl = `http://localhost:8080/api/user`;
//   return axios.get(serverUrl);
// };
// export default handleManagerUserList;

import axios from "axios";

const handleManagerUserSearchEmail = async (email) => {
  const serverUrl = `http://localhost:8080/api/user/email/${email}`;
  return axios.get(serverUrl);
};

export default handleManagerUserSearchEmail;
