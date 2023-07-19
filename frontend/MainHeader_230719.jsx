import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function MainHeader() {
  return (
    <>
      <Nav className="justify-content-center" activeKey="/home">
            PETMAN
      </Nav>
      <br/>
      <Nav className="justify-content-center" activeKey="/home">
        <Nav.Item>동물로 카페 찾기</Nav.Item> &nbsp; | &nbsp;
        <Nav.Item>지역으로 카페 찾기</Nav.Item> &nbsp; | &nbsp;
        <Nav.Item>커뮤니티</Nav.Item> &nbsp; | &nbsp;
        <Nav.Item>카페 소식</Nav.Item>
        <Nav.Item>검색</Nav.Item>
      </Nav>
    </>
  );
}

export default MainHeader;