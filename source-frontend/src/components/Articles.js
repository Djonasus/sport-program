import { Button, Spinner } from "react-bootstrap";
import ArticleCard from "./ArticleCard";
import { BsArrowRight } from "react-icons/bs";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import ApiConfig from "../ApiConfig";
import "./Articles.css";

const Articles = (props) => {
    const navigate = useNavigate();

    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(true);

    const shuffle_postfix = "shuffle=" + props.shuffle;
    const limit_postfix = "limit=" + props.limit;
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;

    useEffect(() => {
        axios.get(ApiConfig.remoteAddress + ApiConfig.getArticles + "?" + limit_postfix + "&" + shuffle_postfix)
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
        <div className="articles-container">
            <Button className="articles-button" onClick={() => navigate("/article")}>
                Все статьи <BsArrowRight />
            </Button>
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
        </div>
    );
};

export default Articles;