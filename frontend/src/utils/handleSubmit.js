//문의사항 등록(API 미구현된 상태로 수정 필요)
import axios from "axios";

const handleSubmit = (nickname, email, phoneNo, title, content, category) => {
  const data = {
    nickname: nickname,
    email: email,
    phoneNo: phoneNo,
    inquiryTitle: title,
    inquiryContent: content,
    inquiryCategory: category,
  };

  const serverUrl = `https://i9a105.p.ssafy.io/api/inquiry`;

  return axios.post(serverUrl, data);
};

export default handleSubmit;
