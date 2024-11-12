import { Button } from "react-bootstrap";
import ArticleCard from "./ArticleCard";

import { BsArrowRight } from "react-icons/bs";

// import { Link } from "react-router-dom";

const Articles = () => {
    return (
        <div>
            <Button style={{margin:"20px 20px"}} to="/articles">Все статьи <BsArrowRight /></Button>
            <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px"}}>
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
            </div>
        </div>
    )
}

export default Articles;