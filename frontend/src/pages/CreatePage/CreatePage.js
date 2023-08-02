import React, {useState} from 'react';
import { useNavigate } from "react-router-dom";


import axios from "axios";

import './CreatePage.scoped.css'
import Header from '../../components/Header/Header';
import Footer from '../../components/Footer/Footer';
import Editor from '../../components/Editor/Editor';
import Button from '../../components/Button/Button';

const CreatePage = () => {
  let navigate = useNavigate();

  const goToBack = () => {
    navigate(-1)
  }

  const [inputValues, setInputValues] = useState({
    boardTitle:"",
    boardContent:"",
    tagList:[
        {
        tagName:"강아지"
            }
            ],
    nickname:"ssafy123",
    shopTitle: null,
    categoryName:"자유",
    fileUrlList: null,
  })
  console.log(inputValues)

  // const {boardTitle, boardContent, tagList, nickname, shopTitle, categoryName, fileUrlList} = inputValues

    const onChangeTitle = (e) => {
      setInputValues({
        ...inputValues,
        boardTitle: e.target.value
      })
    }

    const onChangeContent = (e) => {
      setInputValues({
        ...inputValues,
        boardContent: e.target.value,
      })
    }

  const requestPost = (data) => {
    const serverUrl = "http://i9a105.p.ssafy.io:8080/api/board/new";
    axios.post(serverUrl, data)
    .then((res) => {
      alert('성공')
      navigate('/board')

    }).catch((err) => {
      alert('fail')
    })
  }

  return (
    <div className='CreatePage'>
      <Header />
      <div className='header-save'/>
      <div className='title-wrapper'>
        <input placeholder="제목을 입력하세요" 
               type='text' value={inputValues.boardTitle} onChange={onChangeTitle}/>
        <br />
        <p>{inputValues.boardTitle}</p>
      </div>
      <div className='editor-wrapper'>
        <Editor onChange={onChangeContent} />
      </div>
      <div className='button-wrapper'>
        <Button className='backBtn' text={'뒤로가기'} onClick={() => goToBack()} />
        <Button className='submitBtn' onClick={() => requestPost(inputValues)} text={'작성하기'} />
      </div>
      <div className='footer-save' />
      <Footer />
    </div>
  );
}

export default CreatePage;