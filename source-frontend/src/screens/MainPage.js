
import MCarousel from "../components/MainCarusel";
import PFooter from "../components/PFooter";

import Header from "../components/Header";

import { Container } from "react-bootstrap";
import Articles from "../components/Articles";

const MainPage = () => {
    return (
        <>
          <Header />
          <MCarousel/>
          <Container>
            <Articles />
          </Container>

            <PFooter/>
        </>
    )
}

export default MainPage;