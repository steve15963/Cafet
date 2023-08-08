import axios from "axios";

const handleShop = (num, startDt, CEOName) => {
  const data = {
    num: num,
    startDt: startDt,
    CEOName: CEOName,
  };

  const serverUrl = `http://i9a105.p.ssafy.io/business/num/detail/
  ${num}/${startDt}/${CEOName}`;

  return axios.post(serverUrl, data);
};

export default handleShop;
