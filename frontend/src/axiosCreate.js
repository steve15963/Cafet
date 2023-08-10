import axios from "axios";

const axiosCreate = axios.create({
  baseURL: "https://i9a105.p.ssafy.io/api",
  withCredentials: true,
});

export default axiosCreate;
