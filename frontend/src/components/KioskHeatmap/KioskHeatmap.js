import axios from "axios"
import { useEffect } from "react"

import "./KioskHeatmap.scoped.css"

import h337 from 'heatmap.js'

const KioskHeatmap = ({ id }) => {

  // const [heatmapData, setHeatmapData] = useState([
  //   { x: 100, y: 200, value: 5 },
  //   { x: 200, y: 300, value: 10 },
  // ])

  useEffect(() => {
    // Heatmap 데이터를 생성합니다. 데이터 형식은 x, y, value를 포함해야 합니다.
    
    axios.get(`https://i9a105.p.ssafy.io/api/location/pet?animalId=${id}`)
      .then(function(res) {
        console.log(res.data)
        res.data.max = 10
        const heatmapInstance = h337.create({
          container: document.getElementById('heatmapContainer'),
        });
        heatmapInstance.setData(res.data);
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [id]);

  // useEffect(() => {

  //   // Heatmap 생성 및 설정
  //   const heatmapInstance = h337.create({
  //     container: document.getElementById('heatmapContainer'),
  //   });

  //   heatmapInstance.setData({
  //     max: 10, // 최대값
  //     heatmapData,
  //   });
  // }, [heatmapData])

  return ( 
    <div id="heatmapContainer" style={{ 
      display: "flex", maxWidth: '600px', width: '100%', height: '400px' 
    }} />
  )
}
export default KioskHeatmap