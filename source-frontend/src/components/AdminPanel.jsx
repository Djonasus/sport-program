import React, { useEffect, useState } from "react";
import { Button, Card, Container, Row, Col, Spinner, Alert } from "react-bootstrap";
import axios from "axios";

const AdminPanel = () => {
    const [events, setEvents] = useState([]); // Список событий
    const [loading, setLoading] = useState(true); // Состояние загрузки
    const [error, setError] = useState(null); // Ошибка

    // Получение списка событий
    const fetchEvents = async () => {
        try {
            const response = await axios.get("/api/admin/wait-event");
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
            await axios.put(`/api/admin/wait-event/${id}`, { trueOrFalse: decision });
            // Обновляем список событий после изменения
            fetchEvents();
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
                        <Col key={event.id} md={4} className="mb-4">
                            <Card>
                                <Card.Body>
                                    <Card.Title>{event.name}</Card.Title>
                                    <Card.Text>{event.description}</Card.Text>
                                    <Card.Text>
                                        <strong>Дата:</strong> {event.date}
                                    </Card.Text>
                                    <Card.Text>
                                        <strong>Статус:</strong> {event.status}
                                    </Card.Text>
                                    <div className="d-flex justify-content-between">
                                        <Button
                                            variant="success"
                                            onClick={() => handleEventDecision(event.id, true)}
                                        >
                                            Подтвердить
                                        </Button>
                                        <Button
                                            variant="danger"
                                            onClick={() => handleEventDecision(event.id, false)}
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