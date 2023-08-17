import React from "react";
import ManageInquiryList from "./ManageInquiryList";
import useInquiryList from "../../hooks/useInquiryList";

const ManageInquiry = () => {
  const { inquiryList, loading } = useInquiryList();
  if (loading) {
    return <div>로딩중...</div>;
  }
  console.log(inquiryList);
  return (
    <div>
      <ManageInquiryList inquiryList={inquiryList} />
    </div>
  );
};

export default ManageInquiry;
