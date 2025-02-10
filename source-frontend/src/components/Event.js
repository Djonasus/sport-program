import { Button, Card, Image, Table } from "react-bootstrap";
import PMap from "./PMap";
import { useEffect, useState } from "react";
import ApiConfig from "../ApiConfig";
import axios from "axios";


const Event = (props) => {

    const [ event, setEvent ] = useState()

    useEffect(
        () => {
          axios.get(ApiConfig.remoteAddress+ApiConfig.getEvent+"?eventId="+props.eventId).then(response => {
              setEvent(response.data.children);
              console.log(response);
          }).catch(error => {
              console.log(error);
          });
        }  
      ,[]);

    return (
        <>
            <div className="mt-5 mb-5">
                <h1 className="text-center mb-3">
                    Футбольный матч
                </h1>
                <p>
                    Команды встретятся на поле, чтобы показать свои навыки и страсть к игре. "Зеленые Драконы", обладая мощным атакующим стилем, стремятся продемонстрировать свою скорость и ловкость. В то время как "Синие Молнии" полагаются на слаженную командную работу и стратегию защиты.
                    Обсуждения, эмоции и поддержка болельщиков создадут атмосферу настоящего спортивного праздника. Не упустите возможность увидеть захватывающие моменты, красивые голы и неожиданные повороты игры.

                </p>
            </div>
            <div className="mt-5 mb-5">
                <h1 className="text-center">
                    Валантер: Вася пупкин
                </h1>
            </div>
            <Card className="p-3">
                <div className="row">
                    <div className="col">
                        <h1 className="text-center mb-3">Команда №1</h1>
                        <Table>
                            <tr>
                                <td> 
                                    <Image src="/assets/T1.jpg" style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
                                </td>
                                <td>
                                    <h3>
                                        Фамилия
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        Фамилия
                                    </h3>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <Image src="/assets/T1.jpg" style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
                                </td>
                                <td>
                                    <h3>
                                        -
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        -
                                    </h3>
                                </td>
                            </tr>
                        </Table>
                        <div className="text-center mt-4">
                            <Button>
                                Присоединиться
                            </Button>
                        </div>
                    </div>
                    <div className="col text-center">
                        <h1>
                            27.01.2025
                        </h1>
                        <h1>
                            VS
                        </h1>
                        <h1>
                            17:00
                        </h1>
                    </div>
                    <div className="col text-end">
                        <h1 className="text-center mb-3">Команда №2</h1>
                        <Table>
                            <tr>
                                <td>
                                    <h3>
                                        Фамилия
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        Фамилия
                                    </h3>
                                </td>
                                <td>
                                    <Image src="/assets/T1.jpg" style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h3>
                                        -
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        -
                                    </h3>
                                </td>
                                <td>
                                    <Image src="/assets/T1.jpg" style={{width: '8em', height: '8em', borderRadius: '100px'}}/>
                                </td>
                            </tr>
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