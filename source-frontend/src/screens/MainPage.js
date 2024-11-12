import Header from "../componets/header/Header";

import { Container } from "react-bootstrap";
import Articles from "../components/Articles";

const MainPage = () => {
    return (
        <>
          <Header/>
          <Container>
            <Articles />
          </Container>
        </>
    )
}

export default MainPage;