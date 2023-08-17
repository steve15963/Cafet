import { useEffect, useState } from "react";
import axios from "axios";

const useKioskList = () => {
  const [nameList, setNameList] = useState([]);

  useEffect(() => {
    const getNameList = async () => {
      try {
        const response = await axios.get("https://i9a105.p.ssafy.io/api/kiosk/name");
        setNameList(response.data);
      } catch (error) {
        console.error("키오스크 이름을 불러오는 중 에러가 발생했습니다.", error);
      }
    };

    getNameList();
  }, []);

  return { nameList };
};

export default useKioskList;
