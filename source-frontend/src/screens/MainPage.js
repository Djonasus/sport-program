import { Container } from "react-bootstrap";
import Articles from "../components/Articles";
import PMap from "../components/PMap";

const MainPage = () => {
    return (
        <>
            <Container>
                <Articles />
            </Container>
            <PMap/>
        </>
        
    )
}

export default MainPage;