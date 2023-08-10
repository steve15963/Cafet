import axiosCreate from "../axiosCreate";

const handleShop = (num, startDt, CEOName) => {
  const data = {
    num: num,
    startDt: startDt,
    CEOName: CEOName,
  };

  const serverUrl = `/api/business/num/detail/
  ${num}/${startDt}/${CEOName}`;

  return axiosCreate.post(serverUrl, data);
};

export default handleShop;
