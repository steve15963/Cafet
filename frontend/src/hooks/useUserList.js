import { useEffect, useState } from "react";
import axios from "axios";

const useUserList = () => {
  const [userList, setUserList] = useState([]);
  //eslint-disable-next-line
  const [searchEmail, setsearchEmail] = useState(true);
  //eslint-disable-next-line
  const [searchNickname, setsearchNickname] = useState(true);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getUserList = async () => {
      try {
        //   "https://i9a105.p.ssafy.io/api/user"
        const response = await axios.get("https://i9a105.p.ssafy.io/api/user");
        setUserList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("유저 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getUserList();
  }, []);

  useEffect(() => {
    setLoading(true);
    const getUserList = async () => {
      try {
        //   "https://i9a105.p.ssafy.io/api/user"
        const response = await axios.get(
          `https://i9a105.p.ssafy.io/api/user/email/${searchEmail}`
        );
        setUserList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("유저 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getUserList();
  }, [searchEmail, searchNickname]);

  return { userList, searchEmail, searchNickname, loading };
};

export default useUserList;
