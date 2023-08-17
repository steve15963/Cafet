import "./OrderCheckBody.scoped.css";
import { useEffect, useRef } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

function OrderCheckBody(props) {
  
  const messageContainerRef = useRef(null);

  useEffect(() => {
    scrollToBottom();
  }, [props]);
  
  var sock = new SockJS("https://i9a105.p.ssafy.io/order");
    // var sock = new SockJS("http://localhost:8080/order");

  let client = Stomp.over(sock);

  const setMessage = (p) => {

    console.log("p는"+p)

    // console.log(sock);
    client.send(
      "/app/check",
      {},
      JSON.stringify({
        message: p,
        status: true
      })
    );
  };


  const scrollToBottom = () => {
    if (messageContainerRef.current) {
      messageContainerRef.current.scrollTop = messageContainerRef.current.scrollHeight;
    }
  };

  const handleRemoveMenu = (items, index) => {
    
    console.log("items"+items)

    setMessage(items)


    props.onRemoveMenu(index);
  };
  // const [isChecked, setIsChecked] = useState(false);


  return (
    <main ref={messageContainerRef} style={{ height: '600px', overflowY: 'scroll' }} className="Ordermaincontainer">
        
        {props && props.message.map((items,index) =>
        
            // SetLine(item.msg.split('\n'))

        
            <div bg="info"  className="Ordermymessage">
            <div class="error__close" onClick={() => handleRemoveMenu(items, index)}><svg xmlns="http://www.w3.org/2000/svg" width="20" viewBox="0 0 20 20" height="20"><path fill="#393a37" d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"></path></svg></div>
            {/* <button className="buttonX" onClick={() => handleRemoveMenu(index)}>x</button> */}
            
              <ul>
              {items.msg.split('\n').map((item,index)=>
              <div>
              {index === 0 && <li className="OrderTable">{item}</li>}
              {/* {index > 0 && <li className="OrderOrder">{item}<div class="cntr"><input checked={isChecked} onChange={() => setIsChecked(!isChecked)}type="checkbox" id={`cbx${index}`} class="hidden-xs-up" /><label for={`cbx${index}`} class="cbx"></label></div></li>} */}
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
