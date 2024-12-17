import { Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import ApiConfig from "../ApiConfig";

const ArticleCard = (props) => {

    const follow_link = "/article/"+props.id;

    return (
        <Card style={{width:"18em"}}>
            <Card.Img style={{maxWidth:"18em", maxHeight:"10em", objectFit:"cover"}} variant="top" src={ApiConfig.remoteAddress+props.preview_image} />
            <Card.Body>
                <Card.Title>{props.title}</Card.Title>
                <Card.Text>
                    {props.create_at}
                </Card.Text>
                <Button as={Link} to={follow_link}>Подробнее</Button>
            </Card.Body>
        </Card>
    )
}

export default ArticleCard;