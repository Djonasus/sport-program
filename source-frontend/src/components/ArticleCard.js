import { Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import ApiConfig from "../ApiConfig";
import "./ArticleCard.css";

const ArticleCard = (props) => {
    const follow_link = "/article/" + props.id;

    return (
        <Card className="article-card">
            <Card.Img variant="top" src={ApiConfig.remoteAddress + props.preview_image} />
            <Card.Body className="article-card-body">
                <Card.Title className="article-card-title">{props.title}</Card.Title>
                <Card.Text className="article-card-text">
                    {props.create_at}
                </Card.Text>
                <Card.Link as={Link} to={follow_link} className="article-card-link">Подробнее</Card.Link>
            </Card.Body>
        </Card>
    );
};

export default ArticleCard;