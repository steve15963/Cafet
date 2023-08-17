import { useEffect, useState } from "react";
import axios from "axios";

const useInquiry = ({ id }) => {
  const [inquiry, setInquiry] = useState([]);
  const [loading, setLoading] = useState(true);
  //   console.log(requestId.id);
  // console.log(id);
  useEffect(() => {
    setLoading(true);
    const getInquiry = async () => {
      try {
        let url = `https://i9a105.p.ssafy.io/api/inquiry/${id}`;
        const response = await axios.get(url);
        setInquiry(response.data);
        setLoading(false);
      } catch (error) {
        console.error("등록요청을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getInquiry();
    // setInquiry({
    //   inquiryId: 2,
    //   inquiryTitle: "집에 가고 싶어요",
    //   inquiryContent: "왜 안 보내줘요?",
    //   inquiryCategoryName: "기타",
    //   nickname: "기타",
    //   email: "1234",
    //   phoneNo: "01011122223",
    //   createdTime: "2023-08-16T16:48:59.40751",
    // });
  }, [id]);

  return { inquiry, loading };
};

export default useInquiry;
