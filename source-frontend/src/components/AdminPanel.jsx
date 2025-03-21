import React, { useEffect, useState } from "react";
import { Button, Card, Container, Row, Col, Spinner, Alert } from "react-bootstrap";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import { useNavigate } from "react-router-dom";

const AdminPanel = () => {
    const [events, setEvents] = useState([]); // Список событий
    const [loading, setLoading] = useState(true); // Состояние загрузки
    const [error, setError] = useState(null); // Ошибка

    const navigate = useNavigate();
    // Получение списка событий
    const fetchEvents = async () => {
        try {
            const response = await axios.get(`${ApiConfig.remoteAddress}/api/admin/wait-event`);
            setEvents(response.data);
            setLoading(false);
        } catch (err) {
            setError("Ошибка при загрузке событий");
            setLoading(false);
        }
    };

    // Подтверждение или отклонение события
    const handleEventDecision = async (id, decision) => {
        try {
            await axios.put(`${ApiConfig.remoteAddress}/api/admin/wait-event/${id}?trueOrFalse=${decision}`);
            // Обновляем список событий после изменения
            fetchEvents();
            navigate("/")
        } catch (err) {
            setError("Ошибка при обработке события");
        }
    };

    // Загружаем события при монтировании компонента
    useEffect(() => {
        fetchEvents();
    }, []);

    return (
        <Container className="my-5">
            <h1 className="text-center mb-4">Админ-панель</h1>
            <h2 className="mb-3">События, ожидающие подтверждения</h2>

            {loading ? (
                <div className="text-center">
                    <Spinner animation="border" role="status">
                        <span className="visually-hidden">Загрузка...</span>
                    </Spinner>
                </div>
            ) : error ? (
                <Alert variant="danger">{error}</Alert>
            ) : events.length === 0 ? (
                <Alert variant="info">Нет событий, ожидающих подтверждения.</Alert>
            ) : (
                <Row>
                    {events.map((event) => (
                        <Col key={event.event_request_id} md={4} className="mb-4">
                            <Card>
                                <Card.Body>
                                    <Card.Title>{event.title}</Card.Title>
                                    <Card.Text>{event.description}</Card.Text>
                                    <Card.Text>
                                        <strong>Дата:</strong> {event.date}
                                    </Card.Text>
                                    <Card.Text>
                                        <strong>Время:</strong> {event.time}
                                    </Card.Text>
                                    <Card.Text>
                                        <strong>Тип:</strong> {event.type}
                                    </Card.Text>
                                    <Card.Text>
                                        <strong>Создатель:</strong> {event.name}
                                    </Card.Text>
                                    <Card.Text>
                                        <strong>Количество играков:</strong> {event.maxCountInOneTeam}
                                    </Card.Text>
                                    <div className="d-flex justify-content-between">
                                        <Button
                                            variant="primary"
                                            onClick={() => handleEventDecision(event.event_request_id, true)}
                                        >
                                            Подтвердить
                                        </Button>
                                        <Button
                                            variant="danger"
                                            onClick={() => handleEventDecision(event.event_request_id, false)}
                                        >
                                            Отклонить
                                        </Button>
                                    </div>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>
            )}
        </Container>
    );
};

export default AdminPanel;