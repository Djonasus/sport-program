import { Button, Card, Image, Modal, Table } from "react-bootstrap";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import { useState } from "react";
import "./Event.css";

const Event = (props) => {
    const userId = localStorage.getItem('user_id');
    const [showModal, setShowModal] = useState(false);
    const [modalMessage, setModalMessage] = useState("");

    const handleJoin = async (num) => {
        try {
            const response = await axios.post(ApiConfig.remoteAddress + ApiConfig.joinEvent, {
                eventId: props.eventId,
                team: num,
                userId: userId,
            });

            if (response.status === 200) {
                setModalMessage(`Вы успешно присоединились к команде №${num}!`);
                setShowModal(true);
                props.onUpdate();
            } else if (response.status === 441) {
                setModalMessage(`Команда переполнена`);
                setShowModal(true);
            }
        } catch (error) {
            console.error('Ошибка при присоединении:', error);
            setModalMessage("Произошла ошибка при присоединении. Попробуйте снова.");
            setShowModal(true);
        }
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    return (
        <>
            <Card className="event-card">
                <div className="mt-5 mb-5">
                    <h1 className="event-title">
                        {props.title}
                    </h1>
                    <p className="event-description">
                        {props.description}
                    </p>
                </div>
                <div className="row">
                    <div className="col">
                        <h1 className="team-title">Команда №1</h1>
                        <Table className="team-table">
                            <tbody>
                                {props.team1.map((events, key) => (
                                    <tr key={key}>
                                        <td>
                                            <Image src={events.imageApi} className="team-image" />
                                        </td>
                                        <td>
                                            <h3>
                                                {events.name}
                                            </h3>
                                        </td>
                                        <td>
                                            <h3>
                                                {events.lastname}
                                            </h3>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                        <div className="text-center mt-4">
                            <Button className="join-button" onClick={() => handleJoin(1)}>
                                Присоединиться
                            </Button>
                        </div>
                    </div>
                    <div className="col text-center">
                        <h1>
                            {props.date}
                        </h1>
                        <h1 className="vs-section">
                            VS
                        </h1>
                        <h1>
                            {props.time}
                        </h1>
                    </div>
                    <div className="col text-end">
                        <h1 className="team-title">Команда №2</h1>
                        <Table className="team-table">
                            <tbody>
                                {props.team2.map((events, key) => (
                                    <tr key={key}>
                                        <td>
                                            <h3>
                                                {events.lastname}
                                            </h3>
                                        </td>
                                        <td>
                                            <h3>
                                                {events.name}
                                            </h3>
                                        </td>
                                        <td>
                                            <Image src={events.imageApi} className="team-image" />
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                        <div className="text-center mt-4">
                            <Button className="join-button" onClick={() => handleJoin(2)}>
                                Присоединиться
                            </Button>
                        </div>
                    </div>
                </div>
            </Card>

            <Modal show={showModal} onHide={handleCloseModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Статус присоединения</Modal.Title>
                </Modal.Header>
                <Modal.Body>{modalMessage}</Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseModal}>
                        Закрыть
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
};

export default Event;
