import axios from "axios";

const handleCreateTable = (shopId) => {
  console.log("handleCreateTable");
  const data = {
    shopId: shopId,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/desk";

  return axios.post(serverUrl, data);
};

export default handleCreateTable;
