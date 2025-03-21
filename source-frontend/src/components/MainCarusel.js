import { Carousel, Image } from "react-bootstrap";
import "./MainCarusel.css";
import { useEffect, useState } from "react";
import axios from "axios";
import ApiConfig from "../ApiConfig";

const MCarousel = () => {
    const [news, setNews] = useState([]);

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getArticles + '?limit=3&shuffle=true')
            .then(response => setNews(response.data.children))
            .catch(err => console.error(err));
    }, []);

    return (
        <Carousel className="main-carousel">
            {news.map((newsEl, index) => (
                <Carousel.Item key={index}>
                    <Image className="MainCarousel__Picture" src={ApiConfig.remoteAddress + newsEl.preview} />
                    <Carousel.Caption>
                        <h3>{newsEl.title}</h3>
                        <p>{newsEl.create_at}</p>
                    </Carousel.Caption>
                </Carousel.Item>
            ))}
        </Carousel>
    );
};

export default MCarousel;