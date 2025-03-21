import { useEffect, useState } from "react";
import ApiConfig from "../ApiConfig";
import Header from "../components/Header";
import UserPanel from "../components/UserPanel";
import axios from "axios";
import { Spinner } from "react-bootstrap";
import AdminPanel from "../components/AdminPanel";
import "./Profile.css";
import PFooter from "../components/PFooter";

const Profile = () => {
    const [profile, setProfile] = useState();
    const id = localStorage.getItem('user_id');
    const role = localStorage.getItem('role');

    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getProfile + id)
            .then(response => {
                setProfile(response.data);
                console.log(response);
            })
            .catch(error => {
                console.error("Ошибка при загрузке профиля:", error);
            });
    }, [id]);

    return (
        <>
        <Header />
        <div className="profile-container">
            
            {profile ? (
                <>
                    <div className="admin-panel-section">
                        <UserPanel profile={profile} />
                    </div>
                    {role === 'Admin' && (
                        <div className="admin-panel-section">
                            <AdminPanel />
                        </div>
                    )}
                </>
            ) : (
                <div className="profile-loading">
                    <Spinner animation="border" className="spinner" />
                </div>
            )}
        </div>
        <PFooter/>
        </>
        
    );
};

export default Profile;