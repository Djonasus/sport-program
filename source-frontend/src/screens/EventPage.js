import { Container, Spinner } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { useLocation, useParams } from "react-router-dom";
import Event from "../components/Event";
import ApiConfig from "../ApiConfig";
import { useEffect, useState } from "react";
import axios from "axios";

const EventPage = () => {

    const location = useLocation();
    const params = useParams();

    const id = params.id

    const param = new URLSearchParams(location.search);

    const coords = param.get('coords');

    const [ event, setEvent ] = useState();

    

    useEffect(() => {
          axios.get(ApiConfig.remoteAddress+ApiConfig.getEvent+id).then(response => {
              setEvent(response.data);
              console.log(response);
          }).catch(error => {
              console.log(error);
          });
        },[id]);


    return (
        <>
            <Header/>
            <Container>
                {event ? (<Event  
                    coord={coords}
                    title={event.title}
                    description={event.description}
                    referee={event.referee}
                    team1={event.team1}
                    team2={event.team2}
                    date={event.date}
                    time={event.time}
                />) : (
                    <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
                        <Spinner animation="border"/>
                    </div>
                    
                ) }
            </Container>
            <PFooter/>
        </>
    )
}

export default EventPage;