import { YMaps, Map, Placemark, Clusterer} from '@pbe/react-yandex-maps';
import { Button, Container, Image, ListGroup } from 'react-bootstrap';
import { Accordion } from 'react-bootstrap';
import { useRef, useState } from 'react';

import "./PMap.css"

const points = [
    { id: 1, coords: [55.7515, 37.5738], name: "Москва", description: "город" },
    { id: 2, coords: [55.762200, 37.617300], name: "Краснопресненская", description: "район" },
    { id: 3, coords: [55.754814, 37.628369], name: "Тверская", description: "улица" },
    { id: 4, coords: [55.758651, 37.617085], name: "Площадь Революции", description: "площадь" },
    { id: 5, coords: [55.745884, 37.565125], name: "Кремль", description: "исторический" },
    { id: 6, coords: [55.758472, 37.602304], name: "ГУМ", description: "торговый центр" },
    { id: 7, coords: [55.769126, 37.635222], name: "Цветной бульвар", description: "бульвар" },
    { id: 8, coords: [55.750446, 37.618738], name: "Петровка", description: "улица" },
    { id: 9, coords: [55.775115, 37.631886], name: "Синдикат", description: "жилой район" },
    { id: 10, coords: [55.747990, 37.501149], name: "Варшавское шоссе", description: "шоссе" }
];

const PMap = () => {
    
    const mapRef = useRef(null); // Создаем реф для карты
    const [balloonData, setBalloonData] = useState(null); // Состояние для хранения данных о баллоне

    // Функция для перемещения карты к точке
    const moveToPoint = (coords) => {
        if (mapRef.current) {
            mapRef.current.setCenter(coords);
        }
    };

    const handlePlacemarkClick = (point) => {
        setBalloonData(point);
        if (mapRef.current) {
            mapRef.current.balloon.open(point.coords, {
                contentHeader: point.name,
                contentBody: point.description,
            });
        }
    };

    return (
        <Container style={{display: "grid", gridTemplateColumns: "70% 30%", marginTop:"50px"}}>   
            <YMaps>
                <Map instanceRef={mapRef} style={{width: "100%", height: "500px"}} defaultState={{ center: [55.751574, 37.573856], zoom: 9, controls: ["zoomControl", "fullscreenControl"],}} modules={["control.ZoomControl", "control.FullscreenControl"]}>
                    <Clusterer  options={{preset: "islands#invertedVioletClusterIcons",groupByCoordinates: false,}}>
                    {points.map((point) => (
                            <Placemark key={point.id} geometry={point.coords} onClick={() => handlePlacemarkClick(point)}/>
                        ))}
                    </Clusterer>
                </Map>
            </YMaps>
            <ListGroup style={{width: "100%", height: "500px", overflow: "auto"}}>
                <Accordion>
                    {points.map((point, key) => (
                        <ListGroup.Item key={point.id} onClick={() => moveToPoint(point.coords)} className='listIteam p-0 rounded'> 
                                <Accordion.Item eventKey={key}>
                                    <Accordion.Header>{point.name}</Accordion.Header>
                                    <Accordion.Body className='p-0 text-center'>
                                        <Image src="/assets/T1.jpg" className="w-100"/>
                                        <p style={{marginTop: "10px"}}>{point.description}</p>
                                        <Button style={{marginBottom: "15px"}}>Участвовать</Button>
                                    </Accordion.Body>
                                </Accordion.Item>
                        </ListGroup.Item>
                    ))} 
                </Accordion>
                
            </ListGroup>
        </Container>
    )
}

export default PMap;