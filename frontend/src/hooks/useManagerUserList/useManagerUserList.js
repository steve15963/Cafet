import { useEffect, useState } from "react";
import axios from "axios";

const useManagerUserList = () => {
  const [managerUserList, setmanagerUserList] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect((nameQuery, emailQuery, nicknameQuery) => {
    const getBoardList = async () => {
      try {
        const response = await axios.get(
          `http://i9a105.p.ssafy.io:8080/api/user?nickname=${nicknameQuery}&emailQuery=${emailQuery}`
        );
        setmanagerUserList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("유저 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getBoardList();
  }, []);

  return { managerUserList, loading };
};

export default useManagerUserList;
