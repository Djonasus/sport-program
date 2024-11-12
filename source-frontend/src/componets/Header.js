import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <>
      <Navbar bg="primary" data-bs-theme="dark" className='justify-content-between'>
        <Container>
          <Navbar.Brand as={Link} to="/">РосСпортКомпет</Navbar.Brand>
          <Nav className="me-auto">
          </Nav>
          <Nav>
            <Nav.Link>Войти</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Navbar expand="lg" fixed="top" sticky="bottom" bg="light" data-bs-theme="light" >
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
          <Container>
            <Nav>
              <Nav.Link as={Link} to="/articles">Статьи</Nav.Link>
              <Nav.Link>Карта активностей</Nav.Link>
              <Nav.Link>Команды</Nav.Link>
            </Nav>
          </Container>
        </Navbar.Collapse>
      </Navbar>
    </>
  );
}

export default Header;