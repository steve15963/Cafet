import axiosCreate from "../axiosCreate";

const handletest = () => {
  const serverUrl = "/api/user/get";

  return axiosCreate.get(serverUrl);
};

export default handletest;
