import { useState } from "react";
import axios from "axios";

import IconButton from "@mui/material/IconButton";
import BookmarkIcon from "@mui/icons-material/Bookmark";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";

const ShopFollow = ({ userId, shopId, isFollowing, followState }) => {
  console.log(isFollowing);
  const [btnStatus, setBtnStatus] = useState(isFollowing);

  const handleFollowFeat = () => {
    const newBtnStatus = !btnStatus; // 버튼 상태 변경
    setBtnStatus(newBtnStatus);

    const data = {
      userId: userId,
      shopId: shopId,
    };

    const serverUrl = "https://i9a105.p.ssafy.io/api/shop/like";

    if (!isFollowing) {
      // 팔로우 중이 아니라면 == 팔로우 요청
      axios
        .post(serverUrl, data)
        .then(() => {
          console.log("팔로우");
          followState(true);
        })
        .catch((error) => {
          console.log("post error");
          console.log(error);
          setBtnStatus(!newBtnStatus);
        });
    } else {
      axios
        .delete(serverUrl, { data: data }) // 또는 .delete(serverUrl, { ...data })
        .then(() => {
          console.log("팔로우 취소");
          followState(false);
        })
        .catch((error) => {
          console.log("delete error");
          console.log(error);
          setBtnStatus(!newBtnStatus);
        });
    }
  };

  return (
    <div>
      <IconButton onClick={handleFollowFeat}>
        {btnStatus ? (
          <BookmarkIcon color="primary" />
        ) : (
          <BookmarkBorderIcon color="primary" />
        )}
      </IconButton>
    </div>
  );
};

export default ShopFollow;
