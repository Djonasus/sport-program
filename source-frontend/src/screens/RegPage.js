import { useState } from "react";
import { Button, Card, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import AuthService from "../helper/AuthService";
import "./RegPage.css";

const RegPage = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [last_name, setLastname] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.register(email, password, name, last_name)
            .then(data => {
                navigate('/');
            })
            .catch(error => {
                console.error("Ошибка при регистрации:", error);
            });
    };

    return (
        <div className="registration-container">
            <Card className="registration-card">
                <h1 className="registration-title">Регистрация</h1>
                <Form onSubmit={handleSubmit} className="registration-form">
                    <Form.Group controlId="formBasicName">
                        <Form.Label>Имя</Form.Label>
                        <Form.Control type="text" placeholder="Введите имя" onChange={(e) => setName(e.target.value)} />
                    </Form.Group>
                    <Form.Group controlId="formBasicSurname">
                        <Form.Label>Фамилия</Form.Label>
                        <Form.Control type="text" placeholder="Введите фамилию" onChange={(e) => setLastname(e.target.value)} />
                    </Form.Group>
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
                            Введите данные для регистрации.
                        </Form.Text>
                    </Form.Group>
                    <Button variant="primary" type="submit" className="registration-button">
                        Регистрация
                    </Button>
                    <Button variant="success" as={Link} to="/login" className="login-button">
                        Войти
                    </Button>
                </Form>
            </Card>
            <Button as={Link} to="/" variant="secondary" className="home-button">
                Вернуться на главную страницу
            </Button>
        </div>
    );
};

export default RegPage;