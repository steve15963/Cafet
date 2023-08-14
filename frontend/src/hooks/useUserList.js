import { useEffect, useState } from "react";
import axiosCreate from "../axiosCreate";

const useUserList = () => {
  const [userList, setUserList] = useState([]);
  const [query, setQuery] = useState({ email: "", nickname: "" });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    const getUserList = async () => {
      try {
        let url = "/api/user/get";

        if (query.email) {
          url += `/email/${query.email}`;
        } else if (query.nickname) {
          url += `/nickname/${query.nickname}`;
        }

        const response = await axiosCreate.get(url);
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
