import { Container } from "react-bootstrap";
import ArticleCard from "../components/ArticleCard";

const ArticlesPage = () => {
    return (
        <Container>
            <div className="d-flex flex-wrap" style={{gap:"15px", margin:"20px 0px"}}>
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
            </div>
        </Container>
    )
}

export default ArticlesPage;