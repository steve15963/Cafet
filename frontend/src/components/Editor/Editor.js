import React, { Component } from "react";
import "./Editor.css";

import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import Button from "../Button/Button";

class Editor extends Component {
  render() {
    return (
      <div className="Editor">
        <h2>Editor 컴포넌트 입니다.</h2>
        <CKEditor
          editor={ClassicEditor}
          data="<p>test test test test test test test test </p>"
          onReady={(editor) => {
            console.log("Editor is ready to use!", editor);
          }}
          onChange={(event, editor) => {
            const data = editor.getData();
            console.log({ event, editor, data });
          }}
          onBlur={(event, editor) => {
            console.log("Blur.", editor);
          }}
          onFocus={(event, editor) => {
            console.log("Focus.", editor);
          }}
        />
        <div className="editor_button">
          <Button text={"글 작성"} />
        </div>
      </div>
    );
  }
}

export default Editor;
