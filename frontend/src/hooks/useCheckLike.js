import axios from "axios";

const useCheckLike = (boardId, userId) => {
  console.log("useCheckLike");

  const serverUrl = `/api/user/${userId}/likeBoard/${boardId}`;

  return axios.get(serverUrl);
};

export default useCheckLike;
