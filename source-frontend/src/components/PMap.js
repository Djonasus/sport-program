import { YMaps, Map, Placemark, Clusterer} from '@pbe/react-yandex-maps';
import { Container, ListGroup } from 'react-bootstrap';
import { Accordion } from 'react-bootstrap';
import { useRef, useState } from 'react';

import "./PMap.css"

const points = [
    { id: 1, coords: [55.751574, 37.573856], name: "Москва", description: "ddddddddddddddddddffffffffffff"},
    { id: 2, coords: [59.934280, 30.335099], name: "Санкт-Петербург", description: "dqafsafas"},
    { id: 3, coords: [56.326894, 44.005986], name: "Нижний Новгород", description: "ffwefewefw"},
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
            <ListGroup>
                {points.map((point) => (
                    <ListGroup.Item key={point.id} onClick={() => moveToPoint(point.coords)} className='listIteam'> 
                        {point.name}
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </Container>
    )
}

export default PMap;