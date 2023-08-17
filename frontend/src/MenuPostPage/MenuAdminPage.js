import React, {useEffect, useState} from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import MenuItemPage from "./MenuItemPage";

const MenuAdminPage = () => {
    const [shopId] = useParams();
    const [menuList, setMenuList] = useState([]);

    useEffect(() => {
        getMenuList();
        // eslint-disable-next-line react-hooks/exhaustive-deps
      }, []);


    const getMenuList = async () => {
        const resp = await (
          await axios.get("https://i9a105.p.ssafy.io/api/menu/show/" + shopId)
        ).data;
        setMenuList(resp);
        // console.log(resp)
      };


  return (
    <div className="Ordertwo">
      <div className="Ordertitle">
        shop : {shopId}
      </div>
      <br></br>
      <br></br>

      <div className>
        <div className>
          {menuList &&
            menuList.map((item) => (
              <div className="OrderorderItem1">
              <MenuItemPage item={item}/>
              </div>
            ))}
        </div>
      </div>



    </div>

    
  );
};
export default MenuAdminPage;