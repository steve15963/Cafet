//이메일 인증(response 방식 변경 중)
import axios from "axios";

const handleCreatePost = (inputValues) => {
  console.log(inputValues);
  const serverUrl = "http://i9a105.p.ssafy.io/api/board/new";

  return axios.post(serverUrl, inputValues);
};

export default handleCreatePost;
