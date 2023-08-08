import { useEffect, useState } from "react";
import axios from "axios";

const useShopList = () => {
  const [shopList, setShopList] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getShopList = async () => {
      try {
        const response = await axios.get("http://i9a105.p.ssafy.io/api/shop");
        console.log(response.data);
        setShopList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("지점 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getShopList();
  }, []);

  return { shopList, loading };
};

export default useShopList;
