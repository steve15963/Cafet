import axios from "axios"

const handleGetMenuMethod = async (shopId) =>{
    

    const serverUrl = "http://localhost:8080/api/menu/show/14";



    return axios.get(serverUrl);
};

export default handleGetMenuMethod;
