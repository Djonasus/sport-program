import { Container, Spinner } from "react-bootstrap";
import ArticleCard from "../components/ArticleCard";
import Header from "../components/Header";
import PFooter from "../components/PFooter";

import { useState, useEffect } from "react";
import axios from "axios";

import ApiConfig from '../ApiConfig';

const ArticlesPage = () => {

    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(true);

    // const shuffle_postfix = "shuffle=false";
    // const limit_postfix = ;
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`
    useEffect(
      () => {
        axios.get(ApiConfig.remoteAddress+ApiConfig.getArticles+"?shuffle=true").then(response => {
            setArticles(response.data.children);
            console.log(response);
            setLoading(false);
        }).catch(error => {
            console.log(error);
        });
      }  
    ,[]);

    return (
        <>
        <Header />
        <Container>
            <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
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
        </Container>
        <PFooter />
        </>
    )
}

export default ArticlesPage;