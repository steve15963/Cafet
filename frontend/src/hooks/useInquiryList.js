import { useEffect, useState } from "react";
import axios from "axios";

const useInquiryList = () => {
  const [inquiryList, setInquiryList] = useState([]);
  const [loading, setLoading] = useState(true);
  //   console.log(requestId.id);
  useEffect(() => {
    setLoading(true);
    const getInquiryList = async () => {
      try {
        let url = `https://i9a105.p.ssafy.io/api/inquiry`;
        const response = await axios.get(url);
        setInquiryList(response.data);

        setLoading(false);
      } catch (error) {
        console.error("문의 목록을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getInquiryList();
    // setInquiryList([
    //   { requestId: 0, shopTitle: "냥타벅스" },
    //   { requestId: 1, shopTitle: "돼지와 함께 춤을" },
    // ]);
  }, []);

  return { inquiryList, loading };
};

export default useInquiryList;
