
import MCarousel from "../components/MainCarusel";
import PFooter from "../components/PFooter";

import Header from "../components/Header";

import { Container } from "react-bootstrap";
import Articles from "../components/Articles";
import PMap from "../components/PMap";

const MainPage = () => {
    return (
        <>
          <Header />
          <MCarousel/>
          <Container>
            <h1 style={{marginBlockStart:"50px"}}>Ближайщие спортивные площадки</h1>
            <PMap />
            <h1 style={{marginBlockStart:"50px"}}>Смотртите также</h1>
            <Articles shuffle={false} limit={4}/>
          </Container>

            <PFooter/>
        </>

    )
}

export default MainPage;