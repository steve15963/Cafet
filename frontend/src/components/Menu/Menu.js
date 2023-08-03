import "./Menu.scoped.css";

const Menu = ({ id, name }) => {
  // const handleOnClick = () => {
  //   onClick(id)  // 인자로 받은 onClick 함수에 맞는 게시판(id) 보여주기
  // }

  return (
    <div>
      <button
        className={"menu"}
        // onClick={handleOnClick}
      >
        <span>{name}</span>
      </button>
    </div>
  );
};

export default Menu;
