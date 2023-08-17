//login

import axios from "axios";

const handleUnlike = (id, userId) => {
  console.log("handleLike");
  const data = {
    boardId: id,
    userId: userId,
  };

  const serverUrl = "https://i9a105.p.ssafy.io/api/board/like";

  return axios.delete(serverUrl, { data: data });
};

export default handleUnlike;
