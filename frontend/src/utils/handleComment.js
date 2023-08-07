import axios from "axios";

const handleComment = (boardId, userId) => {
  const data = {
    boardId: boardId,
    userId: userId,
  };

  const serverUrl = `http://i9a105.p.ssafy.io:8080/api/comment/${boardId}/new/${userId}`;

  return axios.post(serverUrl, data);
};

export default handleComment;
