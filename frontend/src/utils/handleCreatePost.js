// 게시글 등록
import axios from "axios";

const handleCreatePost = async (email, nickname, phoneNo, file) => {
  const formData = new FormData();
  console.log("handle " + email);
  console.log(file);
  formData.append("dto", JSON.stringify({ email, phoneNo, nickname }));
  if (file) {
    formData.append("file", file);
  }
  console.log(formData.get("dto"));

  const serverUrl = "https://i9a105.p.ssafy.io/api/board/new";

  const response = await axios.post(serverUrl, formData, {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });

  return response;
};

export default handleCreatePost;
