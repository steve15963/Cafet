import { useEffect, useState } from "react";
import axios from "axios";

const useBoardList = () => {
  const [boardList, setBoardList] = useState([]);

  useEffect(() => {
    const getBoardList = async () => {
      try {
        const response = await axios.get("https://i9a105.p.ssafy.io/api/board");
        setBoardList(response.data);
      } catch (error) {
        console.error("게시판 목록을 불러오는 중 에러가 발생했습니다.", error);
      }
    };

    getBoardList();
  }, []);

  return { boardList };
};

export default useBoardList;
