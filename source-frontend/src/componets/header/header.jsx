import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function Header() {
  return (
    <>
      <Navbar bg="light" data-bs-theme="light">
        <Container>
          <Navbar.Brand>Logo</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link>Example1</Nav.Link>
            <Nav.Link>Example2</Nav.Link>
            <Nav.Link>Example3</Nav.Link>
            <Nav.Link>Example4</Nav.Link>
            <Nav.Link>Авторизация</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default Header;