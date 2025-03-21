import { Button, Container, Form } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import DatePicker from "react-datepicker";
import { useState } from "react";
import "react-datepicker/dist/react-datepicker.css";
import ApiConfig from "../ApiConfig";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import "./NewEventPage.css";

const NewEventPage = () => {
    const navigate = useNavigate();
    const params = useParams();
    const idCoord = params.id;
    const userId = localStorage.getItem('user_id');

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [sport, setSport] = useState("");
    const [startDate, setStartDate] = useState(new Date());
    const [startTime, setStartTime] = useState(new Date());
    const [maxCount, setMaxCount] = useState(1);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formattedDate = startDate.toISOString().split("T")[0];
        const formattedTime = startTime.toLocaleTimeString("en-GB", { hour: "2-digit", minute: "2-digit" });

        const json = {
            title: title,
            description: description,
            sport: sport,
            date: formattedDate,
            time: formattedTime,
            maxCount: maxCount,
            coordId: parseInt(idCoord),
            userId: parseInt(userId),
        };

        try {
            const response = await axios.post(ApiConfig.remoteAddress + ApiConfig.createEvent, json);

            if (response.status === 200) {
                console.log("Событие успешно создано!");
                navigate("/");
            }
        } catch (error) {
            console.error("Ошибка при создании события:", error);
        }
    };

    return (
        <>
        <Header />
        <div className="new-event-container">
            
            <Container>
                <h1 className="new-event-title">Новое событие</h1>
                <Form onSubmit={handleSubmit} className="new-event-form">
                    <Form.Group className="mb-3">
                        <Form.Label>Название</Form.Label>
                        <Form.Control type="text" placeholder="Название события" onChange={(e) => setTitle(e.target.value)} />
                        <Form.Text className="text-muted">
                            Введите название события.
                        </Form.Text>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Описание</Form.Label>
                        <Form.Control as="textarea" aria-label="Описание" onChange={(e) => setDescription(e.target.value)} />
                        <Form.Text className="text-muted">
                            Опишите свое событие
                        </Form.Text>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Вид спорта</Form.Label>
                        <Form.Select aria-label="Выберите вид спорта" onChange={(e) => setSport(e.target.value)}>
                            <option>Выберите вид спорта</option>
                            <option value="Футбол">Футбол</option>
                            <option value="Волейбол">Волейбол</option>
                            <option value="Баскетбол">Баскетбол</option>
                        </Form.Select>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Выберите дату</Form.Label>
                        <br />
                        <DatePicker
                            selected={startDate}
                            onChange={(date) => setStartDate(date)}
                            dateFormat="dd/MM/yyyy"
                            className="form-control"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Выберите время</Form.Label>
                        <br />
                        <DatePicker
                            selected={startTime}
                            onChange={(time) => setStartTime(time)}
                            showTimeSelect
                            showTimeSelectOnly
                            timeIntervals={15}
                            timeCaption="Время"
                            dateFormat="HH:mm"
                            className="form-control"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Количество игроков в одной команде</Form.Label>
                        <Form.Select aria-label="Выберите количество игроков в одной команде" onChange={(e) => setMaxCount(parseInt(e.target.value))}>
                            <option>Выберите количество игроков в одной команде</option>
                            <option value="3">3 игрока</option>
                            <option value="5">5 игроков</option>
                            <option value="7">7 игроков</option>
                            <option value="9">9 игроков</option>
                            <option value="11">11 игроков</option>
                        </Form.Select>
                    </Form.Group>
                    <Form.Group className="mb-3 text-center">
                        <Button type="submit">
                            Создать
                        </Button>
                    </Form.Group>
                </Form>
            </Container>
            
        </div>
        <PFooter />
        </>
        
    );
};

export default NewEventPage;