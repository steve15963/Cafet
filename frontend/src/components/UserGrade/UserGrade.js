import { useState, useEffect } from "react";
import axios from "axios";

const UserGrade = () => {
  const [likeStatus, SetLikeStatus] = useState([])
  useEffect(() => {
    axios.get(`https://i9a105.p.ssafy.io/api/shop/like/${1}`)
      .then(function (res) {
        SetLikeStatus(res.data)
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [])
  console.log('likeStatus', likeStatus)
  return (
    <div>

    </div>
  )
 
}

export default UserGrade