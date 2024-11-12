import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Accordion from 'react-bootstrap/Accordion';

function PForm() {
  return (
    <Accordion defaultActiveKey="0">
        <Accordion.Item eventKey="0" >
            <Accordion.Header>Вход</Accordion.Header>
            <Accordion.Body>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Логин</Form.Label>
                        <Form.Control type="email" placeholder="Логин" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password" placeholder="Пароль" />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Войти
                    </Button>
                </Form>
            </Accordion.Body>
        </Accordion.Item>
        <Accordion.Item eventKey="1">
            <Accordion.Header>Регистрация</Accordion.Header>
            <Accordion.Body>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicLogin">
                        <Form.Label>Логин</Form.Label>
                        <Form.Control type="text" placeholder="Логин" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Почта</Form.Label>
                        <Form.Control type="email" placeholder="Почта" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password" placeholder="Пароль" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Повторите пароль</Form.Label>
                        <Form.Control type="password" placeholder="Повторите пароль" />
                    </Form.Group>
                    
                    <Button variant="primary" type="submit">
                        Войти
                    </Button>
                </Form>
            </Accordion.Body>
        </Accordion.Item>
    </Accordion>
  );
}

export default PForm;