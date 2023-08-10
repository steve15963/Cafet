import { useEffect, useState } from "react";
import axios from "axios";

const useUserList = () => {
  const [userList, setUserList] = useState([]);
  const [query, setQuery] = useState({ email: "", nickname: "" });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    const getUserList = async () => {
      try {
        let url = `https://i9a105.p.ssafy.io/api/user`;
        if (query.email) {
          url += `/email/${query.email}`;
        } else if (query.nickname) {
          url += `/nickname/${query.nickname}`;
        }
        const response = await axios.get(url);
        setUserList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("유저 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getUserList();
  }, [query]);

  return { userList, setQuery, loading };
};

export default useUserList;
