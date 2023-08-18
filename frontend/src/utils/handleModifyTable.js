//테이블 번호 수정

import axios from "axios";

const handleModifyTable = (shopId, tableNum, newtableNum) => {
  console.log("handleModifyTable");
  const data = {
    newtableNum: newtableNum,
  };

  const serverUrl = `https://i9a105.p.ssafy.io/api/desk/${shopId}/${tableNum}`;

  return axios.put(serverUrl, data);
};

export default handleModifyTable;
