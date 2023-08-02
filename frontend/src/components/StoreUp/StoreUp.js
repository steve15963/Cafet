// import React, { useState } from "react";
// import "./StoreUp.scoped.css";
// import handleStore from "../../utils/handleStore";
// import TextField from "@mui/material/TextField";
// import { useNavigate } from "react-router-dom";
// import Button from "../Button/Button";

// const StoreUp = () => {
//   const [businessTypes, setBusinessTypes] = useState("");
//   const [CEOName, setCEOName] = useState("");
//   const [num, setNum] = useState("");
//   const [startDt, setStartDt] = useState("");
//   const [passwordCheck, setPasswordCheck] = useState("");
//   const [isStoreVerified, setIsStoreVerified] = useState(false);
//   const navigate = useNavigate();

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     alert("카페 등록 신청되었습니다");
//     navigate("/");
//   };

//   const onStoreCheckClick = async (event) => {
//     event.preventDefault();
//     try {
//       const response = await handleStore(num, startDt, CEOName);
//       const token = response.data.token;
//       console.log("Store Check success", token);
//       alert("사업자 인증에 성공했습니다.");
//       setIsStoreVerified(true);
//     } catch (error) {
//       console.error("Email Check failed:");
//       alert("사업자 인증에 실패했습니다.");
//     }
//   };

//   return (
//     <div className="storeup">
//       <form className="storeup-form">
//         <p className="storeup-form-title">카페 등록하기</p>
//         <b>신청자 정보</b>
//         <div className="input-container">
//           <TextField
//             label="성명"
//             placeholder="대표자 성명을 입력해주세요"
//             variant="outlined"
//             value={num}
//             onChange={(e) => setNum(e.target.value)}
//             size="small"
//             fullWidth
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             label="연락처"
//             placeholder="전화번호를 입력해주세요"
//             variant="outlined"
//             inputProps={{
//               type: "",
//             }}
//             size="small"
//             fullWidth
//           />
//         </div>
//         <br />
//         <b>가게 정보</b>
//         <div className="input-container">
//           <TextField
//             label="사업자번호"
//             variant="outlined"
//             placeholder="사업자번호를 입력해주세요"
//             fullWidth
//             size="small"
//           />
//           <Button
//             type="gray"
//             text={"전송하기"}
//             className="button"
//             onClick={onStoreCheckClick}
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             id="outlined-textarea"
//             label="법인명"
//             placeholder="법인명을 입력해주세요"
//             multiline
//             fullWidth
//             size="small"
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             id="outlined-textarea"
//             label="대표자"
//             placeholder="대표자 이름을 입력해주세요"
//             multiline
//             fullWidth
//             size="small"
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             id="outlined-textarea"
//             label="개업연월일"
//             placeholder="ex) 20230801"
//             multiline
//             fullWidth
//             size="small"
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             label="사업의 종류"
//             placeholder="사업의 종류를 입력해주세요"
//             variant="outlined"
//             value={businessTypes}
//             onChange={(e) => setBusinessTypes(e.target.value)}
//             size="small"
//             fullWidth
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             id="outlined-textarea"
//             label="이메일"
//             placeholder="가게 대표 메일을 입력해주세요"
//             multiline
//             fullWidth
//             size="small"
//           />
//         </div>
//         <div className="input-container">
//           <TextField
//             id="outlined-textarea"
//             label="사업장 소재지"
//             placeholder="사업장 소재지를 입력해주세요"
//             multiline
//             fullWidth
//             size="small"
//           />
//         </div>
//         <div className="input-container">
//           <Button
//             type="common"
//             text={"등록하기"}
//             className="button"
//             onClick={handleSubmit}
//           />
//         </div>
//       </form>
//     </div>
//   );
// };

// export default StoreUp;
