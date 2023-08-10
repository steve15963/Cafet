//문의사항 등록(API 미구현된 상태로 수정 필요)
import axios from "axios";

const handleSubmit = (event) => {
  const data = {
    event: event,
  };

  const serverUrl = `https://i9a105.p.ssafy.io/api/business/num/detail/`;

  return axios.post(serverUrl, data);
};

export default handleSubmit;
