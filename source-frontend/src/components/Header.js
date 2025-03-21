import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import './Header.css';

function Header() {
    var user_id = localStorage.getItem('user_id');

    return (
        <>
            <Navbar bg="primary" data-bs-theme="dark" className="navbar-primary justify-content-between">
                <Container>
                    <Navbar.Brand as={Link} to="/" className="logo">
                        <div className="logo-pulse">
                            <div className="pulse-wave"></div>
                            <div className="pulse-wave"></div>
                            <div className="pulse-wave"></div>
                        </div>
                        <span className="logo-text">Спорт-Пульс</span>
                    </Navbar.Brand>
                    <Nav className="me-auto">
                    </Nav>
                    <Nav>
                        {user_id ? (
                            <Nav.Link as={Link} to={`/profile/${user_id}`} className="nav-link">
                                Личный кабинет
                            </Nav.Link>
                        ) : (
                            <Nav.Link as={Link} to="/login" className="nav-link">
                                Войти
                            </Nav.Link>
                        )}
                    </Nav>
                </Container>
            </Navbar>
            <Navbar expand="lg" fixed="top" sticky="bottom" bg="light" data-bs-theme="light" className="navbar-light">
                <Container>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link as={Link} to="/article" className="nav-link-light">
                                Статьи
                            </Nav.Link>
                            <Nav.Link as={Link} to="/maps" className="nav-link-light">
                                Карта активностей
                            </Nav.Link>
                            <Nav.Link as={Link} to="/rank" className="nav-link-light">
                                Рейтинг игроков
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    );
}

export default Header;