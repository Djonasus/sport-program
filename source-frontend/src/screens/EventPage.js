import { Container, Spinner } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { useLocation, useParams } from "react-router-dom";
import Event from "../components/Event";
import ApiConfig from "../ApiConfig";
import { useEffect, useState } from "react";
import axios from "axios";
import PMap from "../components/PMap";

const EventPage = () => {
    
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`

    const location = useLocation();
    const params = useParams();

    const id = params.id

    const param = new URLSearchParams(location.search);

    const coords = param.get('coords');

    const [ event, setEvent ] = useState();

    const token = localStorage.getItem('token')

    const fetchEvent = async () => {
        try {
            const response = await axios.get(ApiConfig.remoteAddress + ApiConfig.getEvent + id);
            setEvent(response.data);
        } catch (error) {
            console.error("Ошибка при загрузке события:", error);
        }
    };

    useEffect(() => {
        fetchEvent();
    }, [id]);


    return (
        <>
            <Header/>
            <Container>
                {event ? (<Event  
                    title={event.title}
                    description={event.description}
                    team1={event.team1}
                    team2={event.team2}
                    date={event.date}
                    time={event.time}
                    eventId={id}
                    onUpdate={fetchEvent}
                />) : (
                    <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
                        <Spinner animation="border"/>
                    </div>
                    
                ) }
                <PMap cor={coords}/>
            </Container>
            <PFooter/>
        </>
    )
}

export default EventPage;