import { useEffect, useState } from "react";
import axios from "axios";

const useShopUpRequest = (requestId) => {
  const [shopUpRequest, setShopUpRequest] = useState([]);
  const [loading, setLoading] = useState(true);
  //   console.log(requestId.id);
  useEffect(() => {
    setLoading(true);
    const getShopUpRequest = async () => {
      try {
        let url = `https://i9a105.p.ssafy.io/api/user/${requestId}`;
        const response = await axios.get(url);
        setShopUpRequest(response.data);

        setLoading(false);
      } catch (error) {
        console.error("등록요청을 불러오는 중 에러가 발생했습니다.", error);
        setLoading(false);
      }
    };

    getShopUpRequest();
    setShopUpRequest({
      requester: "신청자",
      phoneNo: "01012345678",
      businessNo: "1234",
      trademark: "(주)축생",
      ceoName: "김금수",
      openDate: "20230116",
      businessType: "동물 카페",
      businessEmail: "saram@man.com",
      address: "서울특별시 여러분 담배꽁초",
    });
  }, [requestId]);

  return { shopUpRequest, loading };
};

export default useShopUpRequest;
