import { useState } from "react";



const ApiConfig = {
    getArticles : "/api/article/all",
    getArticleDetail : "/api/article/",
    remoteAddress : "http://26.34.123.216:8082",
    getEvent : "/api/user/event/",
    getPoints : "/api/coordinates/all", 
    singUp : "/api/authentication/SingUp",
    singIn : "/api/authentication/SingIn",
    joinEvent : "/api/user/request/event",
    createEvent : "/api/user/event",
    getProfile : "/api/user/info/",
    newPhoto : "/api/user/image/",
    getEventsUser : "/api/user/event?user_id=",
    postNews : "/api/admin/news",
}

export default ApiConfig;