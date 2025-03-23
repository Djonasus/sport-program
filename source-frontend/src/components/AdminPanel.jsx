import React, { useEffect, useState } from "react";
import { Button, Card, Container, Row, Col, Spinner, Alert, Form } from "react-bootstrap";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import { useNavigate } from "react-router-dom";
import "./AdminPanel.css";

const AdminPanel = () => {
    const [newsTitle, setNewsTitle] = useState(""); // Заголовок новости
    const [newsText, setNewsText] = useState(""); // Текст новости
    const [newsImage, setNewsImage] = useState(null); // Фото новости
    const [newsAuthor, setNewsAuthor] = useState("")
    const [newsError, setNewsError] = useState(""); // Ошибка при создании новости

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
            navigate("/");
        } catch (err) {
            setError("Ошибка при обработке события");
        }
    };

    const handleNewsSubmit = async (e) => {
        e.preventDefault();

        if (!newsTitle || !newsText || !newsImage) {
            setNewsError("Все поля обязательны для заполнения");
            return;
        }

        const formData = new FormData();
        formData.append("title", newsTitle);
        formData.append("body", newsText);
        formData.append("multipartFile", newsImage);
        formData.append("author", newsAuthor);

        try {
            await axios.post(`${ApiConfig.remoteAddress}${ApiConfig.postNews}`, formData, {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            });
            setNewsAuthor("");
            setNewsTitle("");
            setNewsText("");
            setNewsImage(null);
            setNewsError("");
            alert("Новость успешно создана!");
        } catch (err) {
            setNewsError("Ошибка при создании новости");
        }
    };

    // Загружаем события при монтировании компонента
    useEffect(() => {
        fetchEvents();
    }, []);

    return (
        <Container className="admin-panel-container">
            <h1 className="admin-panel-title">Админ-панель</h1>
            <h2 className="admin-panel-subtitle">События, ожидающие подтверждения</h2>

            {loading ? (
                <div className="spinner-container">
                    <Spinner animation="border" role="status">
                        <span className="visually-hidden">Загрузка...</span>
                    </Spinner>
                </div>
            ) : error ? (
                <Alert variant="danger" className="alert-container">{error}</Alert>
            ) : events.length === 0 ? (
                <Alert variant="info" className="alert-container">Нет событий, ожидающих подтверждения.</Alert>
            ) : (
                <Row>
                    {events.map((event) => (
                        <Col key={event.event_request_id} md={4} className="mb-4">
                            <Card className="event-card">
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
                                        <strong>Количество игроков:</strong> {event.maxCountInOneTeam}*2
                                    </Card.Text>
                                    <div className="event-actions">
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
            <div className="news-form-container">
                <h2 className="news-form-title">Создать новость</h2>
                <Form onSubmit={handleNewsSubmit}>
                    <Form.Group className="mb-3">
                        <Form.Label>Заголовок новости</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Введите заголовок"
                            value={newsTitle}
                            onChange={(e) => setNewsTitle(e.target.value)}
                            required
                        />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Автор</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Введите автора"
                            value={newsAuthor   }
                            onChange={(e) => setNewsAuthor(e.target.value)}
                            required
                        />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Текст новости</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={3}
                            placeholder="Введите текст новости"
                            value={newsText}
                            onChange={(e) => setNewsText(e.target.value)}
                            required
                        />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Фото новости</Form.Label>
                        <Form.Control
                            type="file"
                            accept="image/*"
                            onChange={(e) => setNewsImage(e.target.files[0])}
                            required
                        />
                    </Form.Group>

                    {newsError && <Alert variant="danger">{newsError}</Alert>}

                    <Button variant="primary" type="submit">
                        Создать новость
                    </Button>
                </Form>
            </div>
        </Container>
    );
};

export default AdminPanel;