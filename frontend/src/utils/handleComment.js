import axiosCreate from "../axiosCreate";

const handleComment = (boardId, userId, content) => {
  const data = {
    content: content,
  };

  const serverUrl = `/api/comment/${boardId}/new/${userId}`;

  return axiosCreate.post(serverUrl, data);
};

export default handleComment;
