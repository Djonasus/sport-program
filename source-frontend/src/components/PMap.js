import { YMaps, Map, Placemark, Clusterer} from '@pbe/react-yandex-maps';
import { Button, Carousel, Container, Image, ListGroup, Spinner, Table } from 'react-bootstrap';
import { Accordion } from 'react-bootstrap';
import { useEffect, useRef, useState } from 'react';

import "./PMap.css"
import { Link } from 'react-router-dom';
import ApiConfig from '../ApiConfig';
import axios from 'axios';

// const points = [
//     { id: 1, coords: [55.7515, 37.5738], name: "Москва", description: "город", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 1}, {dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 2}, {dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 3}]},
//     { id: 2, coords: [55.762200, 37.617300], name: "Краснопресненская", description: "район", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 14}] },
//     { id: 3, coords: [55.754814, 37.628369], name: "Тверская", description: "улица", event: []  },
//     { id: 4, coords: [55.758651, 37.617085], name: "Площадь Революции", description: "площадь", event: []  },
//     { id: 5, coords: [55.745884, 37.565125], name: "Кремль", description: "исторический", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 14}]  },
//     { id: 6, coords: [55.758472, 37.602304], name: "ГУМ", description: "торговый центр", event: []  },
//     { id: 7, coords: [55.769126, 37.635222], name: "Цветной бульвар", description: "бульвар", event: []  },
//     { id: 8, coords: [55.750446, 37.618738], name: "Петровка", description: "улица", event: []  },
//     { id: 9, coords: [55.775115, 37.631886], name: "Синдикат", description: "жилой район", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол", eventsId: 14}]  },
//     { id: 10, coords: [55.747990, 37.501149], name: "Варшавское шоссе", description: "шоссе", event: []  }
// ];


const PMap = (props) => {
    const [ points, setPoints ] = useState();
    const coord = props.cor != null ? props.cor.split(',').map(Number) : null
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`
    console.info(coord)

    const mapRef = useRef(null); // Создаем реф для карты
    const [balloonData, setBalloonData] = useState(null); // Состояние для хранения данных о баллоне
    
    const verf = localStorage.getItem("user_id")

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
        axios.get(ApiConfig.remoteAddress+ApiConfig.getPoints).then(response => {
            setPoints(response.data);
            console.log(response);
        }).catch(error => {
            console.log(error);
        });
      },[]);

    // useEffect(() => {
    //     // Получить геопозицию пользователя
    //     navigator.geolocation.getCurrentPosition(
    //         (position) => {
    //             const coords = [position.coords.latitude, position.coords.longitude];
    //             setUserCoords(coords); // Сохранить координаты пользователя
    //             moveToPoint(coords); // Переместить карту к координатам пользователя
    //         },
    //         (error) => {
    //             console.error("Error getting location", error);
    //         }
    //     );
    // }, []);

    return (
        <Container style={{display: "grid", gridTemplateColumns: "60% 40%", marginTop:"50px"}}> 
            {points ? (
            <>
                <YMaps>
                    <Map instanceRef={mapRef} style={{width: "100%", height: "500px"}} defaultState={{ center: coord != null ? coord : [55.7515, 37.5738], zoom: 13, controls: ["zoomControl", "fullscreenControl"],}} modules={["control.ZoomControl", "control.FullscreenControl"]}>
                        <Clusterer  options={{preset: "islands#invertedVioletClusterIcons",groupByCoordinates: false,}}>
                        {points.map((point) => (
                                <Placemark key={point.coordinateId} geometry={point.coords} onClick={() => handlePlacemarkClick(point)}/>
                            ))}
                            
                        </Clusterer>
                        {/* {userCoords && (
                                <Placemark 
                                    geometry={userCoords} 
                                    properties={{
                                        balloonContent: "Я здесь!" // Сообщение в баллоне
                                    }} 
                                    options={{ preset: "islands#icon", iconColor: "#7D9B90" }} // Настройки маркера
                                />
                            )} */}
                    </Map>
                </YMaps>
            <ListGroup style={{width: "100%", height: "500px", overflow: "auto"}}>
                <Accordion>
                    {points.map((point) => (
                        <ListGroup.Item key={point.coordinateId} onClick={() => moveToPoint(point.coords)} className='listIteam p-0 rounded'> 
                                <Accordion.Item eventKey={point.coordinateId}>
                                    <Accordion.Header>{point.name}</Accordion.Header>
                                    <Accordion.Body className='p-0 text-center'>
                                        <Carousel className="w-100">
                                            <Carousel.Item> 
                                                <Image className="MainCarousel__Picture" src="/assets/T1.jpg" />
                                            </Carousel.Item>
                                            <Carousel.Item>
                                                <Image className="MainCarousel__Picture" src="/assets/T2.jpg"  />
                                            </Carousel.Item>
                                        </Carousel>
                                        <h1>{point.name}</h1>
                                        <p style={{marginTop: "10px"}}>{point.description}</p>
                                        {point.events.length > 0 ? (
                                            <Table>
                                                <thead>
                                                    <tr>
                                                        <td>
                                                            Название
                                                        </td>
                                                        <td>
                                                            Спорт
                                                        </td>
                                                        <td>
                                                            Дата
                                                        </td>
                                                        {verf ? 
                                                            <td>
                                                                Узнать
                                                            </td>
                                                            :
                                                            null
                                                        }
                                                            
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    {point.events.map((events, key) => (
                                                        <tr key={key}>
                                                            <td>
                                                                {events.name}
                                                            </td>
                                                            <td>
                                                                {events.type}
                                                            </td>
                                                            <td>
                                                                {events.dataTime}
                                                            </td>
                                                            {verf ? 
                                                                <td>
                                                                    <Button as={Link} to={`/event/${events.eventId}?coords=${point.coords}`} id={key}>
                                                                        Посмотреть
                                                                    </Button>
                                                                </td> 
                                                                :
                                                                null
                                                            }
                                                            
                                                        </tr>
                                                    ))}
                                                </tbody>
                                            </Table>
                                        ) : null}
                                        {verf ? 
                                            <Button as={Link} to={`/event/new/${point.coordinateId}`} className='mb-3'>
                                                Создать событие
                                            </Button> 
                                            :
                                            null
                                        }
                                        
                                    </Accordion.Body>
                                </Accordion.Item>
                        </ListGroup.Item>
                    ))} 
                </Accordion>
                
            </ListGroup>
            </>
            
            ) : (
                <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
                    <Spinner animation="border"/>
                </div>
                
            ) }  
            
        </Container>
    )
}

export default PMap;