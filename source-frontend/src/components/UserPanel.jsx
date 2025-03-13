import { Button, Card, Row, Col, Container, Modal, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import AuthService from "../helper/AuthService";
import { useState } from "react";

const UserPanel = (props) => {
    const navigate = useNavigate();
    
    const navig = () => {
        AuthService.logout()
        navigate('/');
    }

    const [showModal, setShowModal] = useState(false);

    const handleShow = () => setShowModal(true);
    
    const handleClose = () => setShowModal(false);

    return (
        <Container className="my-5">
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form >
                        
                        <div className="d-flex justify-content-around">
                            <Button variant="primary">
                                Изменить
                            </Button>
                            <Button variant="secondary" onClick={handleClose}>
                                Закрыть
                            </Button>
                        </div>
                    </Form>
                </Modal.Body>
                    
                    
                
            </Modal>

            <Card className="shadow-sm">
                <Card.Body>
                    <Row className="align-items-center">
                        <Col md={4} className="text-center">
                            <img
                                className="rounded-circle img-thumbnail"
                                src={props.profile.image_path}
                                alt="User Avatar"
                                width="200px"
                                height="300px"
                            />
                        </Col>
                        <Col md={8}>
                            <h1 className="display-4">{props.profile.name} {props.profile.last_name}</h1>
                            <p className="text-muted">Добро пожаловать в ваш профиль!</p>
                            <Button variant="primary" className="me-2" onClick={handleShow}>
                                Изменить фото
                            </Button>
                            <Button variant="danger" onClick={navig}>
                                Выйти из аккаунта
                            </Button>
                        </Col>
                    </Row>
                </Card.Body>
            </Card>

            <Card className="mt-4 shadow-sm">
                <Card.Body>
                    <h3 className="mb-4">Мои события:</h3>
                    <Row>

                        <Col md={4}>
                            <Card>
                                <Card.Body>
                                    <Card.Title>Название события 1</Card.Title>
                                    <Card.Text>
                                        Краткое описание события.
                                    </Card.Text>
                                    <Card.Text>
                                        Дата: 30.10.2023
                                    </Card.Text>
                                    <Button variant="outline-primary" size="sm">
                                        Подробнее
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                        
                        <Col md={4}>
                            <Card>
                                <Card.Body>
                                    <Card.Title>Название события 2</Card.Title>
                                    <Card.Text>
                                        Краткое описание события.
                                    </Card.Text>
                                    <Card.Text>
                                        Дата: 30.10.2023
                                    </Card.Text>
                                    <Button variant="outline-primary" size="sm">
                                        Подробнее
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>
                </Card.Body>
            </Card>
        </Container>
    );
};

export default UserPanel;