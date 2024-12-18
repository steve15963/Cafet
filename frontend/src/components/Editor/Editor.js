//게시글 작성을 위한 component

import "./Editor.scoped.css";
import React, { useRef, useState } from "react";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import axios from "axios";
import { Button, MenuItem, Select, Stack, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Editor = ({ title, boardId, value, defaultCategory }) => {
  const titleRef = useRef();
  const navigate = useNavigate();
  const [categoryName, setCategoryName] = useState(defaultCategory);
  const [boardTitle, setBoardTitle] = useState(title);
  const [boardContent, setBoardContent] = useState(value);
  const userId = localStorage.getItem("userId");

  console.log(defaultCategory);

  const uploadAdapter = (loader) => {
    return {
      upload() {
        return new Promise((resolve, reject) => {
          const formData = new FormData();
          loader.file.then((file) => {
            formData.append("file", file);
            axios
              .post("https://i9a105.p.ssafy.io//api/boardfile/new", formData, {
                headers: {
                  "Content-Type": "multipart/form-data",
                },
              })
              .then((res) => {
                console.log(res.data);
                resolve({
                  default: res.data,
                });
              })
              .catch((err) => reject(err));
          });
        });
      },
    };
  };

  function uploadPlugin(editor) {
    editor.plugins.get("FileRepository").createUploadAdapter = (loader) => {
      return uploadAdapter(loader);
    };
  }

  const handleAbort = () => {
    navigate(-1);
  };

  const handleChange = (event) => {
    setCategoryName(event.target.value);
  };

  const handleSubmit = () => {
    if (boardTitle.length < 1) {
      alert("제목을 입력하세요.");
      titleRef.current.focus();
      return;
    }

    const data = {
      boardTitle,
      boardContent,
      userId,
      tagList: [],
      shopTitle: null,
      categoryName,
      // files: null,
    };

    // console.log(boardTitle);
    // console.log(boardContent);

    axios.post("https://i9a105.p.ssafy.io/api/board/new", data).then((res) => {
      // console.log(res);
      if (res.status === 201) {
        navigate("/", { replace: true });
        return;
      } else {
        alert("업로드 실패.");
        return;
      }
    });
  };

  const handleEdit = () => {
    if (boardTitle.length < 1) {
      alert("제목을 입력하세요.");
      titleRef.current.focus();
      return;
    }

    const data = {
      boardId,
      boardTitle,
      boardContent,
      userId,
      tagList: [],
      shopTitle: null,
      categoryName,
    };

    // console.log(boardTitle);
    // console.log(boardContent);

    console.log(data);

    axios.put(`https://i9a105.p.ssafy.io/api/board`, data).then((res) => {
      if (res.status === 200) {
        navigate(`/board/detail/${boardId}`, { replace: true });
        return;
      } else {
        alert("업로드 실패.");
        return;
      }
    });
  };

  return (
    <div style={{ width: "60%" }}>
      <Stack spacing={2}>
        <div
          style={{
            display: "flex",
            justifyContent: "space-between",
            columnGap: "10px",
          }}
        >
          <Select
            id="demo-simple-select"
            value={categoryName}
            onChange={handleChange}
            sx={{ width: "30%" }}
          >
            <MenuItem value={"자유"}>자유 게시판</MenuItem>
            <MenuItem value={"질문"}>질문 게시판</MenuItem>
            <MenuItem value={"홍보"}>홍보 게시판</MenuItem>
          </Select>
          <TextField
            id="outlined-basic"
            label="제목"
            variant="outlined"
            placeholder="제목을 입력하세요"
            value={boardTitle}
            onChange={(e) => setBoardTitle(e.target.value)}
            ref={titleRef}
            fullWidth
            // sx={{ width: "59%" }}
          />
        </div>

        <div className="editor">
          <CKEditor
            editor={ClassicEditor}
            config={{
              extraPlugins: [uploadPlugin],
              mediaEmbed: {
                previewsInData: true,
              },
            }}
            // data={value}
            onReady={(editor) => {
              editor.setData(boardContent);
              // console.log("Editor is ready to use!", editor);
              // editor.setData("<p>이랏샤이마세</p>");
            }}
            onChange={(event, editor) => {
              const data = editor.getData();

              setBoardContent(data);
              console.log(boardContent); // console.log({ event, editor, data });
              // console.log("data: ", data);
            }}
            onBlur={(event, editor) => {
              // console.log("Blur.", editor);
            }}
            onFocus={(event, editor) => {
              // console.log("Focus.", editor);
            }}
          />
        </div>
        <Stack direction="row" spacing={2} justifyContent="flex-end">
          <Button size="large" variant="outlined" onClick={handleAbort}>
            취소
          </Button>
          {!boardId ? (
            <Button size="large" variant="contained" onClick={handleSubmit}>
              작성
            </Button>
          ) : (
            <Button size="large" variant="contained" onClick={handleEdit}>
              수정
            </Button>
          )}
        </Stack>
      </Stack>
    </div>
  );
};

export default Editor;
