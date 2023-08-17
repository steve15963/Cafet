import axios from "axios";
import { useEffect, useState } from "react";
import "./KioskHeatmap.scoped.css";
import h337 from "heatmap.js";

const KioskHeatmap = ({ id }) => {
  const [heatmapData, setHeatmapData] = useState([]);

  useEffect(() => {
    const fetchHeatmapData = () => {
      axios
        .get(`https://i9a105.p.ssafy.io/api/location/pet?animalId=${id}`)
        .then(function (res) {
          res.data.max = 10;
          setHeatmapData(res.data);
        })
        .catch(function (err) {
          console.log(err);
        });
    };

    fetchHeatmapData();

    const intervalId = setInterval(fetchHeatmapData, 10000);

    return () => {
      clearInterval(intervalId);
    };
  }, [id]);

  useEffect(() => {
    if (heatmapData.length > 0) {
      const heatmapInstance = h337.create({
        container: document.getElementById("heatmapContainer"),
      });
      heatmapInstance.setData(heatmapData);
    }
  }, [heatmapData]);

  return (
    <div
      id="heatmapContainer"
      style={{
        display: "flex",
        maxWidth: "600px",
        width: "100%",
        height: "400px",
      }}
    />
  );
};

export default KioskHeatmap;
