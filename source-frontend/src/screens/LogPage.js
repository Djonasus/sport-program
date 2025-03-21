import { useState } from "react";
import { Button, Card, Container, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import AuthService from "../helper/AuthService";
import "./LogPage.css";

const LogPage = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.login(email, password)
            .then(data => {
                navigate('/');
            })
            .catch(error => {
                console.error("Ошибка при входе:", error);
            });
    };

    return (
        <div className="login-container">
            <Card className="login-card">
                <h1 className="login-title">Вход</h1>
                <Form onSubmit={handleSubmit} className="login-form">
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Почта</Form.Label>
                        <Form.Control type="email" placeholder="Введите почту" onChange={(e) => setEmail(e.target.value)} />
                    </Form.Group>
                    <Form.Group controlId="formBasicPassword">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password" placeholder="Введите пароль" onChange={(e) => setPassword(e.target.value)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Text className="text-muted">
                            Введите почту и пароль чтобы войти в аккаунт.
                        </Form.Text>
                    </Form.Group>
                    <Button variant="primary" type="submit" className="login-button">
                        Войти
                    </Button>
                    <Button variant="success" as={Link} to="/reg" className="register-button">
                        Регистрация
                    </Button>
                </Form>
            </Card>
            <Button as={Link} to="/" variant="secondary" className="home-button">
                Вернуться на главную страницу
            </Button>
        </div>
    );
};

export default LogPage;