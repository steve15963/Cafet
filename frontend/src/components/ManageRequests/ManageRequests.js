import React from "react";
import ManageRequestList from "../ManageRequestList/ManageRequestList";

const ManageRequest = () => {
  // const path = useParams();
  // const [requestList, setRequestList] = useState([
  //   { requestId: 0, shop: "냥타벅스" },
  //   { requestId: 1, shop: "돼지와 함께 춤을" },
  // ]);
  // console.log(path);
  //   if (path === "detail") {
  //     console.log(path);
  //   }
  return (
    <div>
      <ManageRequestList
        // id={id}
        requestList={[
          { requestId: 0, shop: "냥타벅스" },
          { requestId: 1, shop: "돼지와 함께 춤을" },
        ]}
      />
    </div>
  );
};

export default ManageRequest;
