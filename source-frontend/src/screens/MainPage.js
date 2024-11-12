
import MCarousel from "../component/MainCarusel";
import PFooter from "../component/PFooter";

import Header from "../componets/Header";

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