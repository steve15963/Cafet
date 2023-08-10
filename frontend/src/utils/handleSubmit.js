//문의사항 등록(API 미구현된 상태로 수정 필요)
import axiosCreate from "../axiosCreate";

const handleSubmit = (event) => {
  const data = {
    event: event,
  };

  const serverUrl = `/api/business/num/detail/`;

  return axiosCreate.post(serverUrl, data);
};

export default handleSubmit;
