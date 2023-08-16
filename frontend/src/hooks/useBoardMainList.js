import { useEffect, useState } from "react";
import axios from "axios";

const useBoardMainList = () => {
  const [boardList, setBoardList] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getBoardList = async () => {
      try {
        const response = await axios.get(
          "https://i9a105.p.ssafy.io/api/board/main"
        );
        setBoardList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("게시판 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getBoardList();
  }, []);

  return { boardList, loading };
};

export default useBoardMainList;
