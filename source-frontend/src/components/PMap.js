import { YMaps, Map, Placemark, Clusterer} from '@pbe/react-yandex-maps';
import { Button, Carousel, Container, Image, ListGroup, Table } from 'react-bootstrap';
import { Accordion } from 'react-bootstrap';
import { useEffect, useRef, useState } from 'react';

import "./PMap.css"

const points = [
    { id: 1, coords: [55.7515, 37.5738], name: "Москва", description: "город", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}, {dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}, {dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}]},
    { id: 2, coords: [55.762200, 37.617300], name: "Краснопресненская", description: "район", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}] },
    { id: 3, coords: [55.754814, 37.628369], name: "Тверская", description: "улица", event: []  },
    { id: 4, coords: [55.758651, 37.617085], name: "Площадь Революции", description: "площадь", event: []  },
    { id: 5, coords: [55.745884, 37.565125], name: "Кремль", description: "исторический", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}]  },
    { id: 6, coords: [55.758472, 37.602304], name: "ГУМ", description: "торговый центр", event: []  },
    { id: 7, coords: [55.769126, 37.635222], name: "Цветной бульвар", description: "бульвар", event: []  },
    { id: 8, coords: [55.750446, 37.618738], name: "Петровка", description: "улица", event: []  },
    { id: 9, coords: [55.775115, 37.631886], name: "Синдикат", description: "жилой район", event: [{dataTime: "27/01/2025 17:00", name: "футбольный матч", type: "футбол"}]  },
    { id: 10, coords: [55.747990, 37.501149], name: "Варшавское шоссе", description: "шоссе", event: []  }
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

    const [userCoords, setUserCoords] = useState(null); // Состояние для хранения координат пользователя

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
            <YMaps>
                <Map instanceRef={mapRef} style={{width: "100%", height: "500px"}} defaultState={{ center: [55.751574, 37.573856], zoom: 11, controls: ["zoomControl", "fullscreenControl"],}} modules={["control.ZoomControl", "control.FullscreenControl"]}>
                    <Clusterer  options={{preset: "islands#invertedVioletClusterIcons",groupByCoordinates: false,}}>
                    {points.map((point) => (
                            <Placemark key={point.id} geometry={point.coords} onClick={() => handlePlacemarkClick(point)}/>
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
                    {points.map((point, key) => (
                        <ListGroup.Item key={point.id} onClick={() => moveToPoint(point.coords)} className='listIteam p-0 rounded'> 
                                <Accordion.Item eventKey={key}>
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
                                        <p style={{marginTop: "10px"}}>{point.description}</p>
                                        {point.event.length > 0 ? (
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
                                                        <td>
                                                            Узнать
                                                        </td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    {point.event.map((evets, key) => (
                                                        <tr key={key}>
                                                            <td>
                                                                {evets.name}
                                                            </td>
                                                            <td>
                                                                {evets.type}
                                                            </td>
                                                            <td>
                                                                {evets.dataTime}
                                                            </td>
                                                            <td>
                                                                <Button id={key}>
                                                                    Посмотреть
                                                                </Button>
                                                            </td>
                                                        </tr>
                                                    ))}
                                                </tbody>
                                            </Table>
                                        ) : null}
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