import { Carousel, Container, Image } from "react-bootstrap";
import "./MainCarusel.css"

const MCarousel = () => {
    return (
    <Carousel>
        <Carousel.Item>
            <Image className="MainCarousel__Picture" src="/assets/T1.jpg" />
            <Carousel.Caption>
                <h3>Название новости</h3>
                <p>Краткий рассказ</p>
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <Image className="MainCarousel__Picture" src="/assets/T2.jpg"  />
            <Carousel.Caption>
                <h3>Название новости</h3>
                <p>Краткий рассказ</p>
            </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
    )
}
export default MCarousel;