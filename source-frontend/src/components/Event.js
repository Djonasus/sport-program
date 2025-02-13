import { Button, Card, Image, Table } from "react-bootstrap";
import PMap from "./PMap";
import { useEffect, useState } from "react";
import ApiConfig from "../ApiConfig";
import axios from "axios";


const Event = (props) => {

    // const event = {
    //                 title: 'Футбол', 
    //                 description: 'Описание', 
    //                 referee: 'Вася Пупкин', 
    //                 date: '24.11.2025', 
    //                 time: '17:00', 
    //                 team1: [{name: 'sdd', lastname: 'sada', image_api: 'https://avatars.mds.yandex.net/i?id=2a00000194f627b4a614c1d7a8fe4b4c25f2-1648411-fast-images&n=13'}], 
    //                 team2: [{name: 'sdd', lastname: 'sada', image_api: 'https://avatars.mds.yandex.net/i?id=2a00000194f627b4a614c1d7a8fe4b4c25f2-1648411-fast-images&n=13'}]
    //                 }

    
    return (
        <>
            <Card className="p-3">
                <div className="mt-5 mb-5">
                    <h1 className="text-center mb-3">
                        {props.title}
                    </h1>
                    <p>
                        {props.description}
                    </p>
                </div>
                <div className="mt-5 mb-5">
                    <h1 className="text-center">
                        Валантер: {props.referee}
                    </h1>
                </div>
                <div className="row">
                    <div className="col">
                        <h1 className="text-center mb-3">Команда №1</h1>
                        <Table>
                            {props.team1.map((events) => (
                                <tr>
                                    <td> 
                                        <Image src={events.imageApi} style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
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
                        </Table>
                        <div className="text-center mt-4">
                            <Button>
                                Присоединиться
                            </Button>
                        </div>
                    </div>
                    <div className="col text-center">
                        <h1>
                            {props.date}
                        </h1>
                        <h1 id="pageEve">
                            VS
                        </h1>
                        <h1>
                            {props.time}
                        </h1>
                    </div>
                    <div className="col text-end">
                        <h1 className="text-center mb-3">Команда №2</h1>
                        <Table>
                            {props.team2.map((events) => (
                                <tr>
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
                                        <Image src={events.imageApi} style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
                                    </td>
                                </tr>
                            ))}
                        </Table>
                        <div className="text-center mt-4">
                            <Button>
                                Присоединиться
                            </Button>
                        </div>
                    </div>
                </div>
            </Card>
            <PMap cor={props.coord}/>
        </>
        
    );
};

export default Event;