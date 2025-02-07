import { Container } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { useParams } from "react-router-dom";

const EventPage = (events) => {

    const params = useParams();
    const id = params.id

    console.info(id)

    return (
        <>
            <Header/>
            <Container>

            </Container>
            <PFooter/>
        </>
    )
}

export default EventPage;