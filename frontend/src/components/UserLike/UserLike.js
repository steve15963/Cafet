// import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const UserLike = () => {

  const [likeList, setLikeList] = useState([])

  useEffect(() => {
    axios.get(`http://i9a105.p.ssafy.io:8080/api/board/like/${10}`)
      .then(function(res) {
        setLikeList(res.data)
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [])
  console.log('likeList', likeList)
  return (
    <div>
      {
        likeList.map((el) => 
          <div>
            {el.boardTitle}
          </div>
        )
      }
    </div>
  );
}

export default UserLike;

