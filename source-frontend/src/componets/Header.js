import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function Header() {
  return (
    <>
      <Navbar bg="primary" data-bs-theme="dark" className='justify-content-between'>
        <Container>
          <Navbar.Brand> РосСпортКомпет</Navbar.Brand>
          <Nav className="me-auto">
          </Nav>
          <Nav>
            <Nav.Link>Войти</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Navbar expand="lg" sticky="bottom" bg="light" data-bs-theme="light" >
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
          <Container>
            <Nav>
              <Nav.Link>Статьи</Nav.Link>
              <Nav.Link>Карта активности</Nav.Link>
              <Nav.Link>Команды</Nav.Link>
              {/* <Nav.Link>Example4</Nav.Link> */}
            </Nav>
          </Container>
        </Navbar.Collapse>
      </Navbar>
    </>
  );
}

export default Header;