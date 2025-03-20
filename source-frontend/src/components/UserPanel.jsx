import { Button, Card, Row, Col, Container, Modal, Form, Spinner } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import AuthService from "../helper/AuthService";
import { useState } from "react";
import axios from "axios";
import ApiConfig from "../ApiConfig";

const UserPanel = (props) => {
    const navigate = useNavigate();
    const id = localStorage.getItem('user_id')

    const navig = () => {
        AuthService.logout()
        navigate('/');
    }

    const [loading, setLoading] = useState(false);
    const [events, setEvents] = useState([]);

    const [showModal, setShowModal] = useState(false);
    const [selectedFile, setSelectedFile] = useState(null);

    const handleShow = () => setShowModal(true);
    
    const handleClose = () => setShowModal(false);

    const handleFileChange = (event) => {
        setSelectedFile(event.target.files[0]);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!selectedFile) {
            alert("Пожалуйста, выберите файл.");
            return;
        }

        const formData = new FormData();
        formData.append("multipartFile", selectedFile);

        try {
            const response = await axios.post(`${ApiConfig.remoteAddress}${ApiConfig.newPhoto}${id}`, formData, {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            });

            if (response.status === 200) {
                props.profile.image_path = response.data.image_path;
                handleClose();
            }
        } catch (error) {
            console.error("Ошибка при загрузке файла:", error);
        }
    };

    return (
        <Container className="my-5">
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Изменить фото</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formFile" className="mb-3">
                            <Form.Label>Выберите файл</Form.Label>
                            <Form.Control type="file" onChange={handleFileChange} />
                        </Form.Group>
                        <div className="d-flex justify-content-around">
                            <Button variant="primary" type="submit">
                                Загрузить
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
                        {loading ? 
                            <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
                                <Spinner animation="border"/>
                            </div>
                        : events.length != 0 ? 
                            events.map((event) => (
                                <Col key={event.id} md={4} className="m-3">
                                    <Card>
                                        <Card.Body>
                                            <Card.Title>{event.name}</Card.Title>
                                            <Card.Text>
                                                {event.type}
                                            </Card.Text>
                                            <Card.Text>
                                                {event.date}
                                            </Card.Text>
                                            <Button variant="outline-primary" size="sm" as={Link} to={`/event/${event.id}`}>
                                                Подробнее
                                            </Button>
                                        </Card.Body>
                                    </Card>
                                </Col>
                            ))
                        :
                            <h1 className="text-center">
                                Событий нет
                            </h1>
                        }
                    </Row>
                </Card.Body>
            </Card>
        </Container>
    );
};

export default UserPanel;