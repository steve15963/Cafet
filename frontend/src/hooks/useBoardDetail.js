import { useEffect, useState } from "react";
import axios from "axios";

const useBoardDetail = (boardId) => {
  const [boardDetail, setBoardDetail] = useState({
    boardTitle: "",
    boardContent: "",
    tagList: [
      {
        tagName: "강아지",
      },
    ],
    nickname: "",
    shopTitle: null,
    categoryName: "자유",
    fileUrlList: null,
  });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getBoardDetail = async () => {
      try {
        console.log(boardId);
        const response = await axios.get(
          `https://i9a105.p.ssafy.io/api/board/${boardId}`
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
