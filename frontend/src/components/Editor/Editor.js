//게시글 작성을 위한 component

import "./Editor.scoped.css";
import React, { useRef, useState } from "react";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import axios from "axios";
import { Stack, TextField } from "@mui/material";
// import { useNavigate } from "react-router-dom";
// import Button from "../Button/Button";

const Editor = ({ value, onChange }) => {
  const titleRef = useRef();
  // const navigate = useNavigate();
  const [boardTitle, setBoardTitle] = useState("");
  const [boardContent, setBoardContent] = useState("");
  // const [inputValues, setInputValues] = useState({
  //   boardTitle: "",
  //   boardContent: "",
  //   tagList: [
  //     {
  //       tagName: "강아지",
  //     },
  //   ],
  //   nickname: "ssafy123",
  //   shopTitle: null,
  //   categoryName: "자유",
  //   fileUrlList: null,
  // });

  const uploadAdapter = (loader) => {
    return {
      upload() {
        return new Promise((resolve, reject) => {
          const formData = new FormData();
          loader.file.then((file) => {
            formData.append("file", file);
            axios
              .post("https://i9a105.p.ssafy.io/api/boardfile/new", formData, {
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

  // const handleSubmit = () => {
  //   if (boardTitle.length < 1) {
  //     alert("제목을 입력하세요.");
  //     titleRef.current.focus();
  //     return;
  //   }

  //   const data = {
  //     boardTitle,
  //     boardContent,
  //   };

  //   console.log(boardTitle);

  //   axios.post("https://i9a105.p.ssafy.io/api/board/new", data).then((res) => {
  //     if (res.status === 200) {
  //       navigate("/", { replace: true });
  //       return;
  //     } else {
  //       alert("업로드 실패.");
  //       return;
  //     }
  //   });
  // };

  return (
    <div>
      <Stack spacing={2}>
        <TextField
          id="outlined-basic"
          label="제목"
          variant="outlined"
          placeholder="제목을 입력하세요"
          value={boardTitle}
          onChange={(e) => setBoardTitle(e.target.value)}
          ref={titleRef}
        />
        <div className="editor">
          <CKEditor
            editor={ClassicEditor}
            config={{
              extraPlugins: [uploadPlugin],
            }}
            data={value}
            onReady={(editor) => {
              console.log("Editor is ready to use!", editor);
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
        <Stack direction="row" spacing={2}>
          {/* <Button text="취소"></Button>
          <Button text="작성"></Button> */}
        </Stack>
      </Stack>
    </div>
  );
};

export default Editor;
