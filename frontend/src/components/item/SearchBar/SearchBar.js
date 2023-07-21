import React from "react";
import "./SearchBar.css";

const SearchBar = (onChange) => {
  return (
    <div>
      <form className="search">
        <input
          type="text"
          placeholder="검색어를 입력해주세요"
          className="search_bar"
          name="searchText"
          onChange={onChange}
        />
      </form>
    </div>
  );
};

export default SearchBar;
