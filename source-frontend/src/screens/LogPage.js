import { useState } from "react";
import { Button, Card, Container, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import AuthService from "../helper/AuthService";

const LogPage = () => {

    const [ email, setEmail ] = useState('');
    const [ password, setPassword ] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.login(email, password)
            .then(data => {
                navigate('/');
            })
            .catch(error => {
                
            });
    };
 
    return (
        <>
            <Card className="w-25 text-center m-auto position-absolute top-50 start-50 translate-middle">
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="m-3" controlId="formBasicEmail">
                        <Form.Label>Mail</Form.Label>
                        <Form.Control type="email" placeholder="Почта" onChange={(e) => setEmail(e.target.value)}/>
                    </Form.Group>
                    <Form.Group className="m-3" controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" placeholder="Пароль" onChange={(e) => setPassword(e.target.value)}/>
                    </Form.Group>
                    <Form.Group className="m-3" controlId="formBasicPassword">
                        <Form.Label>Введите почту и пароль чтобы войти в аккаунт.</Form.Label>
                        
                    </Form.Group>

                    <Button variant="primary" type="submit" className="mb-3">
                        Войти
                    </Button>
                    <Button variant="primary" as={Link} to="/reg" className="mb-3 ms-3">
                        Регистрация
                    </Button>
                </Form>
            </Card>
            <Button as={Link} to="/" variant="light" className="position-fixed bottom-0 end-0">Вернуться на главную страницу</Button>
        </> 
    )
};

export default LogPage;