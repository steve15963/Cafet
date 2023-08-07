import React from "react";
// import { useParams } from "react-router-dom";

const ManageRequestDetail = (props) => {
  // const { id } = useParams();

  return (
    <div>
      <p>신청자 정보</p>
      <div>
        <p>성명</p>
        <div>{props.name}</div>
      </div>
      <div>
        <p>연락처</p>
        <div>{props.name}</div>
      </div>
      <p>가게 정보</p>
      <div>
        <p>사업자 정보</p>
        <div>{props.businessNumber}</div>
      </div>
      <div>
        <p>상호</p>
        <div>{props.trademark}</div>
      </div>
      <div>
        <p>대표자</p>
        <div>{props.ceo}</div>
      </div>
      <div>
        <p>이메일</p>
        <div>{props.email}</div>
      </div>
      <div>
        <p>소재지</p>
        <div>{props.address}</div>
      </div>
    </div>
  );
};

export default ManageRequestDetail;
