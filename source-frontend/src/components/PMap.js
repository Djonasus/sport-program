import { YMaps, Map, Placemark, Clusterer } from '@pbe/react-yandex-maps';
import { Button, Carousel, Container, Image, Spinner } from 'react-bootstrap';
import { useEffect, useRef, useState } from 'react';
import "./PMap.css";
import { Link } from 'react-router-dom';
import ApiConfig from '../ApiConfig';
import axios from 'axios';

const PMap = (props) => {
    const [points, setPoints] = useState();
    const coord = props.cor != null ? props.cor.split(',').map(Number) : null;
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
    console.info(coord);

    const mapRef = useRef(null); // Создаем реф для карты
    const [balloonData, setBalloonData] = useState(null); // Состояние для хранения данных о баллоне

    const verf = localStorage.getItem("user_id");

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
                contentBody: point.field_types,
            });
        }
    };

    const [userCoords, setUserCoords] = useState(null); // Состояние для хранения координат пользователя

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getPoints).then(response => {
            setPoints(response.data);
            console.log(response);
        }).catch(error => {
            console.log(error);
        });
    }, []);

    return (
        <Container fluid className="p-0">
            {points ? (
                <div className="d-flex flex-column flex-md-row">
                    <div className="w-100">
                        <YMaps>
                            <Map 
                                instanceRef={mapRef} 
                                className="map-container" 
                                defaultState={{ 
                                    center: coord != null ? coord : [44.0486, 43.0594], 
                                    zoom: 13, 
                                    controls: ["zoomControl", "fullscreenControl"],
                                }} 
                                modules={["control.ZoomControl", "control.FullscreenControl"]}
                            >
                                {/* <Clusterer options={{ preset: "islands#invertedVioletClusterIcons", groupByCoordinates: false }}> */}
                                    {points.map((point) => (
                                        <Placemark key={point.coordinateId} geometry={point.coords} onClick={() => handlePlacemarkClick(point)} />
                                    ))}
                                {/* </Clusterer> */}
                            </Map>
                        </YMaps>
                    </div>
                    <div className="w-100">
                        <div className="points-list">
                            {points.map((point) => (
                                <div key={point.coordinateId} className="point-card" onClick={() => moveToPoint(point.coords)}>
                                    {/* <Carousel>
                                        <Carousel.Item>
                                            <Image className="MainCarousel__Picture" src="/assets/T1.jpg" />
                                        </Carousel.Item>
                                        <Carousel.Item>
                                            <Image className="MainCarousel__Picture" src="/assets/T2.jpg" />
                                        </Carousel.Item>
                                    </Carousel> */}
                                    <div className="point-card-body">
                                        <h1 className="point-card-title">{point.name}</h1>
                                        <p className="point-card-description">{point.description}</p>
                                        {point.events.length > 0 && (
                                            <div className="point-card-events">
                                                {point.events.map((event, key) => (
                                                    <div key={key} className="event-card">
                                                        <h4>{event.name}</h4>
                                                        <p><strong>Спорт:</strong> {event.type}</p>
                                                        <p><strong>Дата:</strong> {event.dataTime}</p>
                                                        {verf && (
                                                            <div className="event-card-actions">
                                                                <Button as={Link} to={`/event/${event.eventId}?coords=${point.coords}`} size="sm">
                                                                    Подробнее
                                                                </Button>
                                                            </div>
                                                        )}
                                                    </div>
                                                ))}
                                            </div>
                                        )}
                                        {verf && (
                                            <div className="point-card-actions">
                                                <Button as={Link} to={`/event/new/${point.coordinateId}`} className='mb-3'>
                                                    Создать событие
                                                </Button>
                                            </div>
                                        )}
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            ) : (
                <div className="d-flex flex-wrap justify-content-center" style={{ gap: "15px", margin: "20px auto" }}>
                    <Spinner animation="border" />
                </div>
            )}
        </Container>
    );
}

export default PMap;