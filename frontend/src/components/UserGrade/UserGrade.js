import { useState, useEffect } from "react";
import axios from "axios";

const UserGrade = ({ userId }) => {
  const [likeStatus, SetLikeStatus] = useState([]);
  useEffect(() => {
    axios
      .get(`https://i9a105.p.ssafy.io/api/shop/like/${userId}`)
      .then(function (res) {
        SetLikeStatus(res.data);
      })
      .catch(function (err) {
        console.log(err);
      });
  }, [userId]);
  console.log("likeStatus", likeStatus);
  return <div></div>;
};

export default UserGrade;
