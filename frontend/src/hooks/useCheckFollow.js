import axios from "axios";

const useCheckFollow = (shopId, userId) => {
  console.log("useCheckFollow");

  const serverUrl = `/api/user/${userId}/likeShop/${shopId}`;

  return axios.get(serverUrl);
};

export default useCheckFollow;
