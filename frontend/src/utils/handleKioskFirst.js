//키오스크 수량 등록
import axios from "axios";

const handleKioskFirst = (shopId, deskNum) => {
  console.log("handleKioskFirst");
  const data = {
    shopId: shopId,
    deskNum: deskNum,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/desk/first";

  return axios.post(serverUrl, data);
};

export default handleKioskFirst;
