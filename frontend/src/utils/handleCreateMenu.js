import axios from "axios"

const handleCreateMethod = async (shopId, menuType, postMenuPriceSizeDtoList, file) =>{
    const formData = new FormData();
    console.log(shopId)
    console.log(menuType)
    console.log(postMenuPriceSizeDtoList)
    console.log(file)

    
    formData.append("dto",JSON.stringify({shopId, menuType, postMenuPriceSizeDtoList}));

    if(file){
        console.log(file)
        formData.append("file", file);
    }else{
        formData.append("file",file)
        console.log(formData)
    }

    

    const serverUrl = "https://i9a105.p.ssafy.io/api/menu/menu";

    const response = await axios.post(serverUrl, formData, {
        headers:{
            'Content-Type' : 'multipart/form-data'},
    });

    



    return response;
};

export default handleCreateMethod;
