import { useEffect, useState } from "react";
import ApiConfig from "../ApiConfig";
import Header from "../components/Header"

import UserPanel from "../components/UserPanel"
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Spinner } from "react-bootstrap";
import AdminPanel from "../components/AdminPanel";


const Profile = () => {

    const [profile, setProfile] = useState()
    const id = localStorage.getItem('user_id')

    const role = localStorage.getItem('role')

    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress+ApiConfig.getProfile+id).then(response => {
            setProfile(response.data);
            console.log(response);
        }).catch(error => {
            console.log(error);
        });
      },[]);

    return (
        <>
            <Header/>
            {profile ? 
            <UserPanel profile={profile}/> 
            : 
            <div className="text-center" style={{marginTop: '25em'}}>
                <Spinner animation="border"/>
            </div>
            }
            {role == 'Admin' ? <AdminPanel/> : null}
            
            
        </>
    )
}

export default Profile;