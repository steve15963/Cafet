import React from "react";
import "./InquiryPage.scoped.css";
import InquiryForm from "../../components/InquiryForm/InquiryForm";
import Header from "../../components/Header/Header";

const InquiryPage = () => {
  return (
    <div>
      <Header />
      <InquiryForm />
    </div>
  );
};

export default InquiryPage;
