import { Breadcrumb, Container, Image, Spinner } from "react-bootstrap";
import Header from "../components/Header";
import { Link, useParams } from "react-router-dom";
import Markdown from "react-markdown";
import Articles from "../components/Articles";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import { useState, useEffect } from "react";
import PFooter from "../components/PFooter";
import "./ArticleDetailPage.css";

const ArticleDetailPage = () => {
    const params = useParams();
    const id = params.id;
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;

    const [article, setArticle] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getArticleDetail + id)
            .then(response => {
                setArticle(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Ошибка при загрузке статьи:", error);
                setLoading(false);
            });
    }, [id]);

    return (
        <>
        <Header />
        <div className="article-detail-container">
            
            <Container>
                {loading ? (
                    <div className="spinner-container">
                        <Spinner animation="border" />
                    </div>
                ) : (
                    <>
                        <Breadcrumb className="article-detail-breadcrumb">
                            <Breadcrumb.Item><Link to="/">Главная</Link></Breadcrumb.Item>
                            <Breadcrumb.Item><Link to="/article">Статьи</Link></Breadcrumb.Item>
                            <Breadcrumb.Item active>{article.title}</Breadcrumb.Item>
                        </Breadcrumb>
                        <Image className="article-detail-image" src={article.preview} fluid />
                        <h1 className="article-detail-title">{article.title}</h1>
                        <div className="article-detail-content">
                            <Markdown>
                                {article.body}
                            </Markdown>
                        </div>
                        <h1 className="related-articles-title">Читайте также</h1>
                        <Articles shuffle limit={4} />
                    </>
                )}
            </Container>
            
        </div>
        <PFooter />
        </>
        
    );
};

export default ArticleDetailPage;