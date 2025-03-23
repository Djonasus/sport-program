import { Container, Table } from "react-bootstrap";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { TfiCup } from "react-icons/tfi";
import "./Rank.css";

const Rank = () => {
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

    const highlightedUserId = 3;

    return (
        <>
            <Header />
            <Container className="rank-container">
                <h1 className="rank-title">Рейтинг</h1>
                <Table className="rank-table">
                    <thead>
                        <tr>
                            <th>Место</th>
                            <th>Никнейм</th>
                            <th>Рейтинг</th>
                        </tr>
                    </thead>
                    <tbody>
                        {rating.map((user, key) => (
                            <tr key={user.user_id} className={user.user_id === highlightedUserId ? "highlighted" : ""}>
                                <td>
                                    {key < 3 && <TfiCup className="cup-icon" />}
                                    {key + 1}
                                </td>
                                <td>{user.user_name}</td>
                                <td>{user.rank}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </Container>
            <PFooter />
        </>
    );
};

export default Rank;