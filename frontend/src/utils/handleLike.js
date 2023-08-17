//login

import axios from "axios";

const handleLike = (id, userId) => {
  console.log("handleLike");
  const data = {
    boardId: id,
    userId: userId,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/board/like";

  return axios.post(serverUrl, data);
};

export default handleLike;
