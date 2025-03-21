import { Card } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom"; // Добавляем useNavigate
import ApiConfig from "../ApiConfig";
import "./ArticleCard.css";

const ArticleCard = (props) => {
    const follow_link = "/article/" + props.id;
    const navigate = useNavigate(); // Хук для навигации

    // Обработчик клика по карточке
    const handleCardClick = () => {
        navigate(follow_link); // Перенаправление по ссылке
    };

    return (
        <Card className="article-card" onClick={handleCardClick}> {/* Добавляем обработчик клика */}
            <Card.Img variant="top" src={ApiConfig.remoteAddress + props.preview_image} />
            <Card.Body className="article-card-body">
                <Card.Title className="article-card-title">{props.title}</Card.Title>
                <Card.Text className="article-card-text">
                    {props.date}
                </Card.Text>
                <Link to={follow_link} className="article-card-link">Подробнее</Link>
            </Card.Body>
        </Card>
    );
};

export default ArticleCard;