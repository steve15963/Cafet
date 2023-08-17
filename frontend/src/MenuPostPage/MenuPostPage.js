import React, {useState } from "react";
import TextField from "@mui/material/TextField";
import handleCreateMenu from "../utils/handleCreateMenu.js"
import Button from "../components/Button/Button.js";

import { useParams } from "react-router-dom";

const MenuPostPage = () => {
  const { shopId } = useParams();

  const [menuType, setMenuType] = useState("")
  const [menuPrice, setMenuPrice] = useState("")
  const [menuSize, setMenuSize] = useState("")


    //button 클릭시 동작
    const onPostMenuButtonClick = async (event) =>{
        event.preventDefault();

        const postMenuPriceSizeDtoList = {menuPrice, menuSize};

        console.log(file)

         await handleCreateMenu(shopId, menuType, postMenuPriceSizeDtoList, file);


    }


  const [file, setFile] = useState(null);


    const handleFileChange = (event) => {
      const selectedFile = event.target.files[0];
      setFile(selectedFile);
    };
  


  return (
    <div>
      <p>메뉴 추가 페이지</p>
      <div>{shopId}번 shop</div> {/* room number */}

        <div>
        <TextField 
        label = "메뉴 이름"
        placeholder="메뉴 이름을 적어주세요"
        variant ="outlined"
        value={menuType}
        onChange={(e) => setMenuType(e.target.value)}
        size="small"
        fullWidth
        />
        </div>
        
    <br></br>

        <div>
        <TextField 
        label = "메뉴 가격"
        placeholder="메뉴 가격을 적어주세요"
        variant ="outlined"
        value={menuPrice}
        onChange={(e) => setMenuPrice(e.target.value)}
        size="small"
        fullWidth
        />
        </div>

        <br></br>

        <div>
        <TextField 
        label = "메뉴 크기"
        placeholder="메뉴 크기를 적어주세요"
        variant ="outlined"
        value={menuSize}
        onChange={(e) => setMenuSize(e.target.value)}
        size="small"
        fullWidth
        />
        </div>

        <br></br>

        <div>
        <label htmlFor="fileInput">프로필 사진 선택</label>
          <input
            type="file"
            id="fileInput"
            onChange={handleFileChange}
            accept="image/*"
          />
        </div>

        <br></br>

        <div>
      <Button
            type="common"
            text={"입력하기"}
            className="button"
            onClick={onPostMenuButtonClick}
          />
          </div>

    </div>

    
  );
};
export default MenuPostPage;
