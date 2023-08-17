import axios from "axios";

const useKioskList = (shopId) => {
  console.log("useKioskList");
  const serverUrl = `https://i9a105.p.ssafy.io/api/desk/${shopId}`;

  return axios.get(serverUrl);
};

export default useKioskList;
