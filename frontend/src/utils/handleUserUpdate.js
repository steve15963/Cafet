import axiosCreate from "../axiosCreate";

const handleUserUpdate = async (email, nickname, phoneNo, file) => {
  const formData = new FormData();
  console.log("handle " + email);
  console.log(file);
  formData.append("dto", JSON.stringify({ email, phoneNo, nickname }));
  if (file) {
    formData.append("file", file);
  }
  console.log(formData.get("dto"));

  const serverUrl = "/api/user";

  const response = await axiosCreate.put(serverUrl, formData, {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });

  return response;
};

export default handleUserUpdate;
