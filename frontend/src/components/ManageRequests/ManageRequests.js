import React from "react";
import ManageRequestList from "../ManageRequestList/ManageRequestList";
import useRequestList from "./../../hooks/useRequestList";

const ManageRequest = () => {
  const { requestList, loading } = useRequestList();
  if (loading) {
    return <div>로딩중...</div>;
  }
  console.log(requestList);
  return (
    <div>
      <ManageRequestList
        // id={id}
        requestList={requestList}
      />
    </div>
  );
};

export default ManageRequest;
