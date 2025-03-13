import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Form, Link } from 'react-router-dom';

function Header() {

  var user_id = localStorage.getItem('user_id') 

  return (
    <>
      <Navbar bg="primary" data-bs-theme="dark" className='justify-content-between'>
        <Container>
          <Navbar.Brand as={Link} to="/">SportTech</Navbar.Brand>
          <Nav className="me-auto">
          </Nav>
          <Nav>
            {user_id ? <Nav.Link as={Link} to={`/profile/${user_id}`}>Личный кабинет</Nav.Link> : <Nav.Link as={Link} to="/login">Войти</Nav.Link>}
          </Nav>
        </Container>
      </Navbar>
      <Navbar expand="lg" fixed="top" sticky="bottom" bg="light" data-bs-theme="light" >
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
          <Container>
            <Nav>
              <Nav.Link as={Link} to="/article">Статьи</Nav.Link>
              <Nav.Link as={Link} to="/maps">Карта активностей</Nav.Link>
              <Nav.Link as={Link} to="/rank">Рейтинг играков</Nav.Link>
            </Nav>
          </Container>
        </Navbar.Collapse>
      </Navbar>
    </>
  );
}

export default Header;