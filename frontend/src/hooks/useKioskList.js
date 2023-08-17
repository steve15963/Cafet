import { useEffect, useState } from "react";
import axios from "axios";

const useKioskList = (shopId) => {
  const [nameList, setNameList] = useState([]);
  const [loading, setLoading] = useState(true);
console.log(shopId);
  useEffect(() => {
    const getNameList = async () => {
      try {
        const response = await axios.get(
          `https://i9a105.p.ssafy.io/api/desk/${shopId}`
        );
        setNameList(response.data);
        setLoading(false);
      } catch (error) {
        console.error(
          "키오스크 목록을 불러오는 중 에러가 발생했습니다.",
          error
        );
        setLoading(false);
      }
    };

    getNameList();
  }, [shopId]);

  return { nameList, loading };
};

export default useKioskList;
