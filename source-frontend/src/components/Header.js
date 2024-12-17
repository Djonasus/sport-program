import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Form, Link } from 'react-router-dom';

import { useState } from 'react';
import Offcanvas from 'react-bootstrap/Offcanvas';

import Button from 'react-bootstrap/Button';
import PForm from './PForm';

function Header() {

  const [show, setShow] = useState(false);

  const handleShow = () => setShow(true);
  const handleClose = () => setShow(false);

  return (
    <>
      <Navbar bg="primary" data-bs-theme="dark" className='justify-content-between'>
        <Container>
          <Navbar.Brand as={Link} to="/">РосСпортКомпет</Navbar.Brand>
          <Nav className="me-auto">
          </Nav>
          <Nav>
            <Nav.Link onClick={handleShow}>Войти</Nav.Link>
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
              <Nav.Link as={Link} to="/rank">Команды</Nav.Link>
            </Nav>
          </Container>
        </Navbar.Collapse>
      </Navbar>
      <Offcanvas show={show} onHide={handleClose} placement='end'>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>Вход и регистрация</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>
          <PForm/>
        </Offcanvas.Body>
      </Offcanvas>
    </>
    
  );
}

export default Header;