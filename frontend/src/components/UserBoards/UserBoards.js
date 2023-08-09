import './UserBoards.scoped.css'
import { useState, useEffect } from "react"
import axios from "axios"

const UserBoards = () => {
  const [boardList, setBoardList] = useState([])

  useEffect(() => {
    axios.get(`http://i9a105.p.ssafy.io:8080/api/board/userId/${1}`)
      .then(function(res) {
        setBoardList(res.data)
      })
      .catch(function(err) {
        console.log(err)
      })
  }, [])
   
  return (
    <div>
      {
        boardList.map((el) => 
          <div>
            <div class="task">
              <div class="tags">
                <span class="tag">{el.categoryName}</span>
                <button class="options">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    xmlnsXlink="http://www.w3.org/1999/xlink"
                    viewBox="0 0 41.915 41.916"
                    id="Capa_1"
                    version="1.1"
                    fill="#000000"
                  >
                    <g strokeWidth="0" id="SVGRepo_bgCarrier"></g>
                    <g
                      strokeLinejoin="round"
                      strokeLinecap="round"
                      id="SVGRepo_tracerCarrier"
                    ></g>
                    <g id="SVGRepo_iconCarrier">
                      <g>
                        <g>
                          <path
                            d="M11.214,20.956c0,3.091-2.509,5.589-5.607,5.589C2.51,26.544,0,24.046,0,20.956c0-3.082,2.511-5.585,5.607-5.585 C8.705,15.371,11.214,17.874,11.214,20.956z"
                          ></path>
                          <path
                            d="M26.564,20.956c0,3.091-2.509,5.589-5.606,5.589c-3.097,0-5.607-2.498-5.607-5.589c0-3.082,2.511-5.585,5.607-5.585 C24.056,15.371,26.564,17.874,26.564,20.956z"
                          ></path>
                          <path
                            d="M41.915,20.956c0,3.091-2.509,5.589-5.607,5.589c-3.097,0-5.606-2.498-5.606-5.589c0-3.082,2.511-5.585,5.606-5.585 C39.406,15.371,41.915,17.874,41.915,20.956z"
                          ></path>
                        </g>
                      </g>
                    </g>
                  </svg>
                </button>
              </div>
              <p>
                {el.boardTitle}
              </p>
            </div>  
          </div>
        )
      }
    </div>
  );
}

export default UserBoards;