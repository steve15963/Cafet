//테이블 삭제
import axios from "axios";

const handleDeleteTable = (shopId, tableNum) => {
  console.log("handleDeleteTable");
  const data = {
    shopId: shopId,
    tableNum: tableNum,
  };

  const serverUrl = `https://i9a105.p.ssafy.io/api/desk/${shopId}/${tableNum}`;

  return axios.delete(serverUrl, { data: data });
};

export default handleDeleteTable;
