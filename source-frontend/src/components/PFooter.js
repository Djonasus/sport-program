import { Container } from "react-bootstrap";
import { FaTelegram, FaEnvelope, FaPhoneAlt } from "react-icons/fa";
import { RiVkFill } from "react-icons/ri";
import { AiFillTikTok } from "react-icons/ai";
import "./PFooter.css";

function PFooter() {
    return (
        <div className="PFooter">
            <Container>
                <div className="row">
                    <div className="col-md-3 col-12">
                        <div className="PFooter__contact contact">
                            <h1 className="contact__head">
                                Контакты
                            </h1>
                            <p className="contact__text">
                                <FaPhoneAlt /> +7 (962) 005 93-13
                            </p>
                            <p className="contact__text">
                                <FaTelegram /> @da1ryman
                            </p>
                            <p className="contact__text">
                                <FaEnvelope /> example123@gmail.com
                            </p>
                        </div>
                    </div>
                    <div className="col-md-3 col-12">
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
                    </div>
                    <div className="col-md-3 col-12">
                        <div className="PFooter__link link">
                            <h1 className="link__head">
                                Соцсети
                            </h1>
                            <p className="link__text">
                                <a href="https://telegram.org"><FaTelegram /> Telegram</a>
                            </p>
                            <p className="link__text">
                                <a href="https://vk.com/"><RiVkFill /> VK</a>
                            </p>
                            <p className="link__text">
                                <a href="https://www.tiktok.com"><AiFillTikTok /> Tik Tok</a>
                            </p>
                        </div>
                    </div>
                    <div className="col-md-3 col-12">
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
                    </div>
                </div>
            </Container>
        </div>
    );
}

export default PFooter;