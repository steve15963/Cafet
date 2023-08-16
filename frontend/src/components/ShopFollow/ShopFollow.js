import { useState } from "react";
import axios from "axios";

import IconButton from "@mui/material/IconButton";
import BookmarkIcon from "@mui/icons-material/Bookmark";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";

const ShopFollow = ({ userId, shopId, isFollowing, followState }) => {
  // console.log(userId);
  // console.log(shopId);
  const [btnStatus, setBtnStatus] = useState(false);

  const handleFollowFeat = () => {
    if (isFollowing) {
      setBtnStatus(false);
    } else {
      setBtnStatus(true);
    }

    if (isFollowing) {
      // 팔로잉 중이라면 == 언팔로우 한다는 것
      axios
        .delete(`https://i9a105.p.ssafy.io/api/shop/like`, {
          data: {
            userId: userId,
            shopId: shopId,
          },
        })
        .then(() => {
          followState(false);
        })
        .catch((error) => {
          console.log("delete error");
          console.log(error);
        });
    } else {
      axios
        .post(`https://i9a105.p.ssafy.io/api/shop/like`, {
          data: {
            userId: userId,
            shopId: shopId,
          },
        })
        .then(() => {
          followState(true);
        })
        .catch((error) => {
          console.log("post error");
          console.log(error);
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
