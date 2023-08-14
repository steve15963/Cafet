import axios from "axios"
import { useState, useEffect } from "react"
import { Heatmap } from "heatmap.js"

const KioskHeatmap = ({ id }) => {

  const [heat, setHeat] = useState([])

  // minimal heatmap instance configuration
  //eslint-disable-next-line
  

  useEffect(() => {
    axios.get(
      `http://i9a105.p.ssafy.io:1234/api/location/pet?animalId=${id}`
      )
      .then(function(res) {
        setHeat(res.data)
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [id])
  useEffect(() => {
    if (heat.length > 0) {
      const heatmapInstance = Heatmap.create({
        // only container is required, the rest will be defaults
        container: document.getElementById('heatmapContainer'),
      });

      heatmapInstance.addData(heat)
      heatmapInstance.draw()
    }
  }, [heat])
  return(
    <div>
      <div id="heatmapContainer" style={{width: '100%', height: '500px'}}>

      </div>
    </div>
  )
}

export default KioskHeatmap