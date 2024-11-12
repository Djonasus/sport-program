import { Button, Spinner } from "react-bootstrap";
import ArticleCard from "./ArticleCard";

import { BsArrowRight } from "react-icons/bs";

import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import ApiConfig from "../ApiConfig";

// import { Link } from "react-router-dom";

const Articles = (props) => {
    const navigate = useNavigate();

    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(true);

    const shuffle_postfix = "shuffle="+props.shuffle;
    const limit_postfix = "limit="+props.limit;

    useEffect(
      () => {
        axios.get(ApiConfig.remoteAddress+ApiConfig.getArticles+"?"+limit_postfix+"&"+shuffle_postfix).then(response => {
            setArticles(response.data.children);
            console.log(response);
            setLoading(false);
        }).catch(error => {
            console.log(error);
        });
      }  
    ,[]);

    return (
        <div>
            <Button onClick={() => {navigate("/article")}} style={{margin:"20px 20px"}} to="/articles">Все статьи <BsArrowRight /></Button>
            <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px"}}>
            {
            loading ? (
                    <Spinner animation="border" />
                ) : (
                    articles.map((article, key) => (
                        <ArticleCard 
                            id = {article.id}
                            key = {key}
                            title={article.title} 
                            preview_image={article.preview} 
                            create_at={article.create} 
                        />
                    ))
                )
            }
            </div>
        </div>
    )
}

export default Articles;