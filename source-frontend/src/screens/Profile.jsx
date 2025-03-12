import { Button, Container } from "react-bootstrap"
import Header from "../components/Header"
import logout from "../helper/AuthService"
import AuthService from "../helper/AuthService"
import { useNavigate } from "react-router-dom"

const Profile = () => {

    const navigate = useNavigate();

    const navig = () => {
        AuthService.logout()
        navigate('/');
    }

    return (
        <>
            <Header/>
            <Container>
                
                <Button onClick={navig}>
                    Выйти из аккаунта
                </Button>
                
            </Container>
        </>
    )
}

export default Profile;