import axios from "axios";

const handletest = () => {
  const serverUrl = "http://localhost:8080/api/user/get";

  return axios.get(serverUrl);
};

export default handletest;
