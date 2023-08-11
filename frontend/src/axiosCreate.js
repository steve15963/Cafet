import axios from "axios";
import handleRefreshToken from "./utils/handleRefreshToken";

const axiosCreate = axios.create({
  baseURL: "https://i9a105.p.ssafy.io",
  withCredentials: true,
});

axiosCreate.interceptors.request.use(
  async (config) => {
    const sessionToken = localStorage.getItem("sessionToken");
    console.log("axiosCreate");
    if (!sessionToken) {
      try {
        const refreshTokenResponse = await handleRefreshToken();
        const newSessionToken = refreshTokenResponse.data.sessionToken;
        localStorage.setItem("sessionToken", newSessionToken);

        config.headers.Authorization = `Bearer ${newSessionToken}`;
      } catch (error) {
        console.error("Failed to refresh token:", error);
      }
    } else {
      config.headers.Authorization = `Bearer ${sessionToken}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default axiosCreate;
