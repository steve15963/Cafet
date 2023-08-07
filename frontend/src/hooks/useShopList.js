import { useEffect, useState } from "react";
import axios from "axios";

const useShopList = () => {
  const [shopList, setShopList] = useState([]);
  const [query, setQuery] = useState({ shopTitle: "", address: "" });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    const getShopList = async () => {
      try {
        let url = `http://localhost:8080/api/shop`;
        //   "http://i9a105.p.ssafy.io:8080/api/shop"
        if (query.shopTitle) {
          url += `/shopTitle/${query.shopTitle}`;
        } else if (query.address) {
          url += `/address/${query.address}`;
        }
        const response = await axios.get(url);
        setShopList(response.data);
        setLoading(false);
      } catch (error) {
        console.error("유저 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getShopList();
  }, [query]);

  return { shopList, setQuery, loading };
};

export default useShopList;
