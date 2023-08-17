import React, {useState, useEffect} from "react";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import h337 from "heatmap.js";

// import KioskHeatmap from "../KioskHeatmap/KioskHeatmap";

const LiveMap = () => {
  
  const [placeX, setPlaceX] = useState("");
  const [placeY, setPlaceY] = useState("");

    var sock = new SockJS('https://i9a105.p.ssafy.io/order')
    // var sock = new SockJS('http://localhost:8080/order')
    let client = Stomp.over(sock);
  
    useEffect(() => {
      client.connect({}, () =>{
        // 받고
          client.subscribe('/topic/map/1', function(frame){

            addMessage(frame.body)

          })
      })

        // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  const addMessage = (content) =>{
    content.split('\n').map((item,index) => {
      
      if(index===0) { setPlaceX(item)}
      if(index===1) {setPlaceY(item)}
      return null
    }
    )
    
    console.log(placeX)

    // window.location.reload();
    
      const heatmapInstance = h337.create({
        container: document.getElementById("heatmapContainer"),
      })
    heatmapInstance.setData({max:100,
      data:[
        {x:placeX, y:placeY, value:1000}]});
  }

  return (
    <div>
      <div>
      <div
      id="heatmapContainer"
      style={{
        display: "flex",
        maxWidth: "200px",
        width: "100%",
        height: "200px",
      }}
    />
      </div>

    </div>

    
  );
};
export default LiveMap;
