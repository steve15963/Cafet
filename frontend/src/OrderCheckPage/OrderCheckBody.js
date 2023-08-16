import "./OrderCheckBody.scoped.css";
import { useEffect, useRef } from "react";


function OrderCheckBody(props) {
  
  const messageContainerRef = useRef(null);

  useEffect(() => {
    scrollToBottom();
  }, [props]);
  
  const scrollToBottom = () => {
    if (messageContainerRef.current) {
      messageContainerRef.current.scrollTop = messageContainerRef.current.scrollHeight;
    }
  };


  return (
    <main ref={messageContainerRef} style={{ height: '600px', overflowY: 'scroll' }} className="Ordermaincontainer">
      
      {/* <ToastContainer bsPrefix="toast-main-container"> */}
      
        
        
        {/* {props && props.message[0].msg.split('\n').map((item)=>
        
        <Toast bg="info" className="my-message">
        <Toast.Body>{item}</Toast.Body>
      </Toast>

        )} */}
        
        {props && props.message.map((items) =>
        
            // SetLine(item.msg.split('\n'))

        
            <div bg="info" className="Ordermymessage">
              <ul>
              {items.msg.split('\n').map((item,index)=>
              <div>
              {index === 0 && <li className="OrderTable">{item}</li>}
              {index > 0 && <li className="OrderOrder">{item}</li>}
              </div>
              )
            }
            </ul>
            <br></br>
            </div>
        )}
      {/* </ToastContainer> */}
    </main>
  );
}

export default OrderCheckBody;
