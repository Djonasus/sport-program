import { Carousel, Image } from "react-bootstrap";
import "./MainCarusel.css";
import { useEffect, useState } from "react";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import { useNavigate } from "react-router-dom";

const MCarousel = () => {
    const [news, setNews] = useState([]);

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getArticles + '?limit=3&shuffle=true')
            .then(response => setNews(response.data.children))
            .catch(err => console.error(err));
    }, []);

    return (
        <Carousel className="main-carousel">
            {news.map((newsEl) => (
                <Carousel.Item key={newsEl.id}>
                    <Image className="MainCarousel__Picture" src={newsEl.preview} />
                    <Carousel.Caption>
                        <h3>{newsEl.title}</h3>
                        <p>{newsEl.date}</p>
                    </Carousel.Caption>
                </Carousel.Item>
            ))}
        </Carousel>
    );
};

export default MCarousel;