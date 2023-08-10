import { useEffect, useState } from "react";
import axios from "axios";

const useRequestList = () => {
  const [requestList, setRequestList] = useState([]);
  const [loading, setLoading] = useState(true);
  //   console.log(requestId.id);
  useEffect(() => {
    setLoading(true);
    const getRequestList = async () => {
      try {
        let url = `https://i9a105.p.ssafy.io/api/user`;
        //   "http://i9a105.p.ssafy.io:8080/api/user"
        const response = await axios.get(url);
        setRequestList(response.data);

        setLoading(false);
      } catch (error) {
        console.error(
          "등록요청 목록을 불러오는 중 에러가 발생했습니다.",
          error
        );
        setLoading(false);
      }
    };

    getRequestList();
    setRequestList([
      { requestId: 0, shopTitle: "냥타벅스" },
      { requestId: 1, shopTitle: "돼지와 함께 춤을" },
    ]);
  }, []);

  return { requestList, loading };
};

export default useRequestList;
