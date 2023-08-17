//시간 형식 맞춰주기

const formatTime = (isoTime) => {
  const date = new Date(isoTime);
  const year = date.getFullYear().toString().substr(-2);
  const month = (date.getMonth() + 1).toString().padStart(2, "0");
  const day = date.getDate().toString().padStart(2, "0");
  const hour = date.getHours().toString().padStart(2, "0");
  const minute = date.getMinutes().toString().padStart(2, "0");
  return `${year}/${month}/${day} ${hour}:${minute}`;
};
export default formatTime;
