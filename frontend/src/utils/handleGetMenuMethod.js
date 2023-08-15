import axios from "axios"

const handleGetMenuMethod = async (shopId) =>{
    

    const serverUrl = "https://i9a105.p.ssafy.io//api/menu/show/14";



    return axios.get(serverUrl);
};

export default handleGetMenuMethod;
