import { Button, Container, Form } from "react-bootstrap"
import Header from "../components/Header"
import PFooter from "../components/PFooter"
import DatePicker from "react-datepicker";
import { useState } from "react";
import "react-datepicker/dist/react-datepicker.css";
import ApiConfig from "../ApiConfig";
import axios from "axios";
import { useParams } from "react-router-dom";

const NewEventPage = () => {

    const params = useParams();
    
    const idCoord = params.id

    const userId = localStorage.getItem('user_id')

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
                
            }
        } catch (error) {
            console.error("Ошибка при создании события:", error);
            
        }
    };

    return (
        <>
            <Header/>
            <Container>
                <h1 className="text-center">Новое событие</h1>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3">
                        <Form.Label>Название</Form.Label>
                        <Form.Control type="text" placeholder="Название события"  onChange={(e) => setTitle(e.target.value)}/>
                        <Form.Text className="text-muted">
                            Введите название события. 
                        </Form.Text>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Описнаие</Form.Label>
                        <Form.Control as="textarea" aria-label="Описание" onChange={(e) => setDescription(e.target.value)}/>
                        <Form.Text className="text-muted text-center" >
                            Опишите свое событие
                        </Form.Text>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Вид спорта</Form.Label>
                        <Form.Select aria-label="ыберите вид спорта" onChange={(e) => setSport(e.target.value)}>
                            <option>Выберити вид спорта</option>
                            <option value="Футбол">Футбол</option>
                            <option value="Воллейбол">Воллейбол</option>
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
                        <Form.Label>Колличество играков в одной команде</Form.Label>
                        <Form.Select aria-label="Default select example" onChange={(e) => setMaxCount(parseInt(e.target.value))}>
                            <option>Выберити количество играков в одной команде</option>
                            <option value="3">3 игрока</option>
                            <option value="5">5 играков</option>
                            <option value="7">7 играков</option>
                            <option value="9">9 играков</option>
                            <option value="11">11 играков</option>
                        </Form.Select>
                    </Form.Group>
                    <Form.Group className="mb-3 text-center">
                        <Button type="submit">
                            Создать 
                        </Button>
                    </Form.Group>
                </Form>
            </Container>
            <PFooter/>
        </>
    )
}

export default NewEventPage;