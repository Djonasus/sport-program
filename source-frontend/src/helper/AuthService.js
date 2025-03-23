import axios from 'axios';
import ApiConfig from '../ApiConfig';

const login = (email, password) => {
    return axios.post(ApiConfig.remoteAddress + ApiConfig.singIn, { email, password })
        .then(response => {
            if (response.data) {
                localStorage.setItem('token', response.data.token)
                localStorage.setItem('user_id', JSON.stringify(response.data.user_id));
                localStorage.setItem('role', response.data.role);
                axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`
            }
            return response.data;
        });
};

const register = (email, password, name, lastName) => {
    return axios.post(ApiConfig.remoteAddress + ApiConfig.singUp, { email, password, name, lastName }).then(response => {
        if (response.data) {
            localStorage.setItem('token', response.data.token)
            localStorage.setItem('user_id', JSON.stringify(response.data.user_id));
            localStorage.setItem('role', response.data.role);
            axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`
        }
        return response.data;
    });;
};

const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user_id');
    localStorage.removeItem('role');
};

export default {
    login, 
    register,
    logout
};