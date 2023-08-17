import axios from "axios";
import { useEffect, useState } from "react";
import "./KioskHeatmap.scoped.css";
import h337 from "heatmap.js";

const KioskHeatmap = ({ id }) => {
  const [heatmapData, setHeatmapData] = useState([]);

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

  useEffect(() => {
    console.log("페이지 리로드"); // 페이지 로드될 때 "페이지 리로드" 출력

    fetchHeatmapData();

    const intervalId = setInterval(fetchHeatmapData, 10000);

    return () => {
      clearInterval(intervalId);
    };
  }, []); // 의존성 배열을 빈 배열로 설정하여 워닝 무시

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
