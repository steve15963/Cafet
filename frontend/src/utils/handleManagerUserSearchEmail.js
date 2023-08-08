// import axios from "axios";

// const handleManagerUserList = (email, nickname) => {
//   const data = { email, nickname };
//   //`https://i9a105.p.ssafy.io/api/user?nickname=${nickname}&email=${email}`;
//   //   const serverUrl = `https://i9a105.p.ssafy.io/api/user?nickname=${nickname}&email=${email}`;
//   //   let serverUrl = `https://i9a105.p.ssafy.io/api/user`;

//   const serverUrl = `https://i9a105.p.ssafy.io/api/user`;
//   return axios.get(serverUrl);
// };
// export default handleManagerUserList;

import axios from "axios";

const handleManagerUserSearchEmail = async (email) => {
  const serverUrl = `https://localhost/api/user/email/${email}`;
  return axios.get(serverUrl);
};

export default handleManagerUserSearchEmail;
