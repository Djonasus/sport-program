import MCarousel from "../components/MainCarusel";
import PFooter from "../components/PFooter";
import Header from "../components/Header";
import { Button, Container } from "react-bootstrap";
import Articles from "../components/Articles";
import PMap from "../components/PMap";
import { Link } from "react-router-dom";
import "./MainPage.css";

const MainPage = () => {
    return (
        <div className="main-page-container">
            <Header />
            <MCarousel />
            <Container>
                <h1 className="main-page-title">Ближайшие спортивные площадки</h1>
                <PMap />
                <Button as={Link} to='/maps' className="map-button">
                    Карта активностей
                </Button>
                <div className="articles-section">
                    <h1 className="articles-title">Смотрите также</h1>
                    <Articles shuffle={false} limit={4} />
                </div>
            </Container>
            <PFooter />
        </div>
    );
};

export default MainPage;