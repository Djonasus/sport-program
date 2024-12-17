import { Container, Table } from "react-bootstrap"
import Header from "../components/Header"
import PFooter from "../components/PFooter"
import { TfiCup } from "react-icons/tfi";

const Rank = () => {
    
    // const [ rating, setRating ] = useState([])
    const rating = [
        { user_id: 1, user_name: 'Fortech', rank: 100000 },
        { user_id: 2, user_name: 'GruopSoup', rank: 90000 },
        { user_id: 3, user_name: 'CONTINUE', rank: 80000 },
        { user_id: 4, user_name: 'TechWarrior', rank: 75000 },
        { user_id: 5, user_name: 'CodeMaster', rank: 70000 },
        { user_id: 6, user_name: 'PixelPusher', rank: 65000 },
        { user_id: 7, user_name: 'CyberKnight', rank: 60000 },
        { user_id: 8, user_name: 'DevSquad', rank: 55000 },
        { user_id: 9, user_name: 'CodePhantom', rank: 50000 },
        { user_id: 10, user_name: 'HackMaverick', rank: 46000 },
        { user_id: 11, user_name: 'QuantumByte', rank: 42000 },
        { user_id: 12, user_name: 'ByteRunner', rank: 40000 },
        { user_id: 13, user_name: 'NetGenX', rank: 38000 },
        { user_id: 14, user_name: 'TechMaster', rank: 35000 },
        { user_id: 15, user_name: 'DigitalKnight', rank: 32000 },
        { user_id: 16, user_name: 'WebGuru', rank: 30000 },
        { user_id: 17, user_name: 'CloudSmith', rank: 28000 },
        { user_id: 18, user_name: 'DataSlinger', rank: 25000 },
        { user_id: 19, user_name: 'NetworkSage', rank: 22000 },
        { user_id: 20, user_name: 'AppTrekker', rank: 20000 }
    ];

    const highlightedUserId = 3
    return (
        <>
            <Header/>
            
            <Container style={{marginTop: '25px', textAlign:'center'}}>
                <h1 style={{textAlign: 'center'}}>Рейтинг</h1>
                <Table>
                    <thead>
                        <tr>
                            <th style={{backgroundColor: '#0d6efd', color:'white'}}>Место</th>
                            <th  style={{backgroundColor: '#0d6efd', color:'white'}}>Никнейм</th>
                            <th  style={{backgroundColor: '#0d6efd', color:'white'}}>Рейтинг</th>
                        </tr>
                    </thead>
                    {rating.map((user, key) => (
                        <tbody key={user.user_id} >
                            <tr>
                                <td style={user.user_id === highlightedUserId ? { backgroundColor: '#79AFFE' } : {}}>{key < 3 ? <TfiCup /> : ""} {key + 1}</td>
                                <td style={user.user_id === highlightedUserId ? { backgroundColor: '#79AFFE' } : {}}>{user.user_name}</td>
                                <td style={user.user_id === highlightedUserId ? { backgroundColor: '#79AFFE' } : {}}>{user.rank}</td>
                            </tr>
                        </tbody>
                    ))}
                </Table>
                
                
            </Container>
            <PFooter/>
        </>
    )
}

export default Rank;