import './Menu.css'
// import Button from '../Button/Button'


const Menu = ({ id, name, onClick, onMouseOver, isSelected }) => {
  const handleOnClick = () => {
    onClick(id)  // 인자로 받은 onClick 함수에 맞는 게시판(id) 보여주기
  }

  const handleOnMouseOver = () => {
    onMouseOver(id)  // 마우스 올리면 해당 메뉴 활성화
  }

  return (
    <div className={[
      'Menu',
      isSelected ? `Menu_on_${id}` : `Menu_off`
    ].join(" ")}
    onClick={handleOnClick}
    onMouseOver={handleOnMouseOver}>
      
    </div>
  );
}

export default Menu