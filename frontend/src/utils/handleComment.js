import axios from "axios";

const handleComment = (boardId, content) => {
  const data = {
    content: content,
  };

  const serverUrl = `https://i9a105.p.ssafy.io/api/comment/${boardId}/new/1`;

  return axios.post(serverUrl, data);
};

export default handleComment;
