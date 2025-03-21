import { Container, Spinner } from "react-bootstrap";
import ArticleCard from "../components/ArticleCard";
import Header from "../components/Header";
import PFooter from "../components/PFooter";
import { useState, useEffect } from "react";
import axios from "axios";
import ApiConfig from '../ApiConfig';
import "./ArticlesPage.css";

const ArticlesPage = () => {
    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(true);

    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getArticles + "?shuffle=true")
            .then(response => {
                setArticles(response.data.children);
                setLoading(false);
            })
            .catch(error => {
                console.error("Ошибка при загрузке статей:", error);
                setLoading(false);
            });
    }, []);

    return (
        <>
        <Header />
        <div className="articles-page-container">
            
            <Container>
                <div className="articles-grid">
                    {loading ? (
                        <div className="spinner-container">
                            <Spinner animation="border" />
                        </div>
                    ) : (
                        articles.map((article, key) => (
                            <ArticleCard
                                id={article.id}
                                key={key}
                                title={article.title}
                                preview_image={article.preview}
                                create_at={article.create}
                            />
                        ))
                    )}
                </div>
            </Container>
            
        </div>
        <PFooter />
        </>
        
    );
};

export default ArticlesPage;