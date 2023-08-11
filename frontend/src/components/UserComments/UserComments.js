import { useState, useEffect } from "react";
import axios from "axios";
import './UserComments.scoped.css'

const UserComments = () => {

  const [commentList, setCommentList] = useState([])

  useEffect(() => {
    axios.get(`http://i9a105.p.ssafy.io:8080/api/comment/user/${1}`)
      .then(function(res) {
        setCommentList(res.data)
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [])

  
   
  return (
    <div>
      {
        commentList.map((el) => 
        <div>
          <div>{el.content}</div>
        </div>
        )
      }
    </div>
  );
}

export default UserComments;
