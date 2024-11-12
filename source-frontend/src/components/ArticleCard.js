import { Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const ArticleCard = (props) => {

    const follow_link = "/article/"+props.id;

    return (
        <Card style={{width:"14em"}}>
            <Card.Img style={{maxWidth:"18em", maxHeight:"10em", objectFit:"cover"}} variant="top" src={props.preview_image} />
            <Card.Body>
                <Card.Title>{props.title}</Card.Title>
                <Card.Text>
                    {props.create_at}
                </Card.Text>
                <Card.Link as={Link} to={follow_link}>Подробнее</Card.Link>
            </Card.Body>
        </Card>
    )
}

export default ArticleCard;