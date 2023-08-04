import axios from "axios";

const handleUserUpdate = async (email, nickname, phoneNo, file) => {
  const formData = new FormData();
  console.log("handle " + email);
  console.log(file);
  formData.append("dto", JSON.stringify({ email, phoneNo, nickname }));
  if (file) {
    formData.append("file", file);
  }
  console.log(formData.get("dto"));

  const serverUrl = "http://localhost:8080/api/user";

  try {
    const response = await axios.put(serverUrl, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    return response.data;
  } catch (error) {
    console.error("Error updating user:", error);
    throw error;
  }
};

export default handleUserUpdate;
