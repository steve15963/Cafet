import axios from "axios"
import { useState, useEffect } from "react"
import h337 from 'heatmap.js'

const KioskHeatmap = ({ id }) => {

  useEffect(() => {
    // Heatmap 데이터를 생성합니다. 데이터 형식은 x, y, value를 포함해야 합니다.
    const data = [
      { x: 100, y: 200, value: 5 },
      { x: 200, y: 300, value: 10 },
      // 추가 데이터...
    ];

    // Heatmap 생성 및 설정
    const heatmapInstance = h337.create({
      container: document.getElementById('heatmapContainer'),
    });

    heatmapInstance.setData({
      max: 20, // 최대값
      data,
    });
  }, []);

  return ( 
    <div id="heatmapContainer" style={{ width: '100%', height: '400px' }} />
  )
}

export default KioskHeatmap