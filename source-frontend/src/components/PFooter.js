import { AccordionBody, AccordionHeader, AccordionItem, Container } from "react-bootstrap";
import Accordion from "react-bootstrap/Accordion";

import { FaTelegram } from "react-icons/fa";
import {RiVkFill} from "react-icons/ri"
import { AiFillTikTok } from "react-icons/ai";

import "./PFooter.css"

const isMobile = window.matchMedia("(max-width: 768px)").matches

function PFooter() {
    if (!isMobile) {
        return (
            <div className="PFooter">
                <Container style={{display: "grid", gridTemplateColumns: "25% 25% 25% 25%"}}>
                <div className="PFooter__contact contact">
                        <h1 className="contact__head">
                            Контакты
                        </h1>
                        <p className="contact__text">
                           Телефон: +7 (962) 005 93-13
                        </p>
                        <p className="contact__text">
                           Телеграм: @da1ryman
                        </p>
                        <p className="contact__text">
                           Почта: example123@gmail.com
                        </p>
                    </div>
                    
                    <div className="PFooter__about about">
                        <h1 className="about__head">
                            О компании
                        </h1>
                        <p className="about__text">
                            О нас
                        </p>
                        <p className="about__text">
                            Команда
                        </p>
                        <p className="about__text">
                            Карьера
                        </p>
                    </div>
                    <div className="PFooter__link link">
                        <h1 className="link__head">
                            Соцсети
                        </h1>
                        <p className="link__text">
                            <a href="https://telegram.org">Telegram <FaTelegram /></a>
                        </p>
                        <p className="link__text">
                            <a href="https://vk.com/">VK  <RiVkFill /></a>
                        </p>
                        <p className="link__text">
                            <a href="https://www.tiktok.com">Tik Tok <AiFillTikTok /></a>
                        </p>
                    </div>
                    <div className="PFooter__support support">
                        <h1>
                            Поддержка
                        </h1>
                        <p className="support__text">
                            Часто задаваемые вопросы (FAQ)  
                        </p>
                        <p className="support__text">
                            Контактная информация  
                        </p>
                        <p className="support__text">
                            Техническая поддержка   
                        </p>
                    </div>
                </Container>
            </div>
        )
    }   else {
        return (
        <Accordion className="accordions">
            <AccordionItem eventKey="0">
                <AccordionHeader>
                    О компании
                </AccordionHeader>
                <AccordionBody style={{textAlign: "justify"}}>
                    <p className="about__text">
                        О нас
                    </p>
                    <p className="about__text">
                        Команда
                    </p>
                    <p className="about__text">
                        Карьера
                    </p>
                </AccordionBody>
            </AccordionItem>
            <Accordion.Item eventKey="1">
                <Accordion.Header>
                    Соцсети
                </Accordion.Header>
                <Accordion.Body>
                    <p className="link__text">
                    <   a href="https://telegram.org">Telegram <FaTelegram /></a>
                    </p>
                    <p className="link__text">
                        <a href="https://vk.com/">VK  <RiVkFill /></a>
                    </p>
                    <p className="link__text">
                        <a href="https://www.tiktok.com">Tik Tok <AiFillTikTok /></a>
                    </p>
                </Accordion.Body>
            </Accordion.Item>
            <Accordion.Item eventKey="2">
                <Accordion.Header>
                    Поддержка
                </Accordion.Header>
                <Accordion.Body>
                    <p className="support__text">
                        Часто задаваемые вопросы (FAQ)  
                    </p>
                    <p className="support__text">
                        Контактная информация  
                    </p>
                    <p className="support__text">
                        Техническая поддержка   
                    </p>
                </Accordion.Body>
            </Accordion.Item>
            <Accordion.Item eventKey="3">
                <Accordion.Header>
                    Контакты
                </Accordion.Header>
                <Accordion.Body>
                    <p className="contact__text">
                        Телефон: +7 (962) 005 93-13
                    </p>
                    <p className="contact__text">
                        Телеграм: @da1ryman
                    </p>
                    <p className="contact__text">
                        Почта: example123@gmail.com
                    </p>
                </Accordion.Body>
            </Accordion.Item>
        </Accordion>
        )
    }
}

export default PFooter;