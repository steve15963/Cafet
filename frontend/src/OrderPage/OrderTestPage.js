// import React, {useState } from "react";
// import "./OrderTestPage.css"

// const OrderTestPage = () => {

//     const [seconds, setSeconds] = useState(30);
//     // const intervalRef: { current: null | NodeJS.Timer } = useRef(null);
//     // const [showPaymentModal, setShowPaymentModal] = useState<boolean>(false);
//     // const [showConfirmModal, setShowConfirmModal] = useState<boolean>(false);
  
//     // const formattedSameProduct = formatSameProductIdList(orderList);
//     // const totalPrice = orderList.reduce((acc, cur) => {
//     //   const { productId, size, amount } = cur;
//     //   const price = size === 'Large' ? products[productId].price + EXTRA_PRICE : products[productId].price;
//     //   return acc + price * amount;
//     // }, 0);



//   return (
//     <div className= "cart">
//       <div className= "orderItems">
//         123
//         456
//         {/* {formattedSameProduct.map((order, index) => {
//           const { productId, size, amount } = order;
//           const menu = products[productId];
//           return (
//             <div key={index} className={styles.itemWrapper}>
//               <div className={styles.amount}>{amount}</div>
//               <MenuItem
//                 className={styles.orderItem}
//                 productId={menu.productId}
//                 menuName={menu.name}
//                 menuImg={menu.imgUrl}
//                 menuPrice={size === 'Large' ? menu.price + EXTRA_PRICE : menu.price}
//               />
//               <button className={styles.menuCancelButton} onClick={() => handleRemoveOrder(menu.productId, size)}>
//                 X
//               </button>
//             </div>
//           );
//         })} */}
//       </div>
//       <div className= "buttons">

//         123
//         {/* <span>
//           총 결제 금액 <span className={styles.totalPrice}>₩ {totalPrice.toLocaleString('ko-KR')}</span>
//         </span>
//         <span className={styles.timer}>{seconds}초 뒤에 메뉴가 전체 취소돼요!</span>
//         <button onClick={confirmRemoveAllOrders} className={styles.allCancelButton}>
//           전체취소
//         </button>
//       </div>
//       <button className={styles.orderButton} onClick={handlePaymentButtonClick}>
//         결제하기
//       </button>
//       {showPaymentModal &&
//         createPortal(
//           <PaymentModalContent
//             navigate={navigate}
//             totalPrice={totalPrice}
//             orderList={orderList}
//             handlePaymentCancelButtonClick={handlePaymentCancelButtonClick}
//           />,
//         )}
//       {showConfirmModal &&
//         createPortal(
//           <ConfirmModal
//             text={'메뉴를 모두 취소하시겠습니까?'}
//             onClickYesButton={removeAllOrders}
//             onClickNoButton={closeConfirmModal}
//           />,
//         )} */}
//         </div>
//     </div>
    
//   );
// };
// export default OrderTestPage;
