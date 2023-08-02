import axios from "axios";

const handleStore = (num, startDt, CEOName) => {
  const data = {
    num: num,
    startDt: startDt,
    CEOName: CEOName,
  };

  const serverUrl = `http://i9a105.p.ssafy.io:8080/business/num/detail/
  ${num}/${startDt}/${CEOName}`;

  return axios.post(serverUrl, data);
};

export default handleStore;
