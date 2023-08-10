import axiosCreate from "../axiosCreate";

const handletest = () => {
  const serverUrl = "http://localhost:8080/api/user/get";

  return axiosCreate.get(serverUrl);
};

export default handletest;
