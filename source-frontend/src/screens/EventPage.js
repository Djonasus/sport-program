import { Container } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { useLocation, useParams } from "react-router-dom";
import Event from "../components/Event";
import ApiConfig from "../ApiConfig";
import { useEffect } from "react";

const EventPage = () => {

    const location = useLocation();
    const params = useParams();

    const id = params.id

    const param = new URLSearchParams(location.search);

    const coords = param.get('coords');

    

    return (
        <>
            <Header/>
            <Container>
                <Event eventId={id} coord={coords}/>
            </Container>
            <PFooter/>
        </>
    )
}

export default EventPage;