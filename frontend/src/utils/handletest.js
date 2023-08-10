import axiosCreate from "../axiosCreate";

const handletest = () => {
  const serverUrl = "user/get";

  return axiosCreate.get(serverUrl);
};

export default handletest;
