import { useEffect, useState } from "react";
import axios from "axios";

const useBoardDetail = (boardId) => {
  const [boardDetail, setBoardDetail] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getBoardDetail = async () => {
      try {
        console.log(boardId);
        const response = await axios.get(
          `http://i9a105.p.ssafy.io/api/board/${boardId}`
        );
        setBoardDetail(response.data);
        setLoading(false);
      } catch (error) {
        console.error("게시글을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getBoardDetail();
  }, [boardId]);

  return { boardDetail, loading };
};

export default useBoardDetail;
