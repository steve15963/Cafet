import axios from "axios"
import { useState, useEffect } from "react"
import h337 from "heatmap.js"

const KioskHeatmap = ({ id }) => {

  const [heat, setHeat] = useState([])

  // minimal heatmap instance configuration
  //eslint-disable-next-line
  const heatmapInstance = h337.create({
    // only container is required, the rest will be defaults
    container: document.querySelector('.heatmap')
  });

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
  console.log('heat:', heat)
  return(
    <div>
    </div>
  )
}

export default KioskHeatmap