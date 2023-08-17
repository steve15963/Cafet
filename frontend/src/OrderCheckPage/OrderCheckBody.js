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

  const handleRemoveMenu = (index) => {

    props.onRemoveMenu(index);
  };


  return (
    <main ref={messageContainerRef} style={{ height: '600px', overflowY: 'scroll' }} className="Ordermaincontainer">
      
      {/* <ToastContainer bsPrefix="toast-main-container"> */}
      
        
        
        {/* {props && props.message[0].msg.split('\n').map((item)=>
        
        <Toast bg="info" className="my-message">
        <Toast.Body>{item}</Toast.Body>
      </Toast>

        )} */}
        
        {props && props.message.map((items,index) =>
        
            // SetLine(item.msg.split('\n'))

        
            <div bg="info"  className="Ordermymessage">
            <div class="error__close" onClick={() => handleRemoveMenu(index)}><svg xmlns="http://www.w3.org/2000/svg" width="20" viewBox="0 0 20 20" height="20"><path fill="#393a37" d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"></path></svg></div>
            {/* <button className="buttonX" onClick={() => handleRemoveMenu(index)}>x</button> */}
            
              <ul>
              {items.msg.split('\n').map((item,index)=>
              <div>
              {index === 0 && <li className="OrderTable">{item}</li>}
              {index > 0 && <li className="OrderOrder">{item}<div class="cntr"><input checked="" type="checkbox" id="cbx" class="hidden-xs-up" /><label for="cbx" class="cbx"></label></div></li>}
              
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
