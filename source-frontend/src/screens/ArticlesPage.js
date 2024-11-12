import { Container } from "react-bootstrap";
import ArticleCard from "../components/ArticleCard";
import Header from "../componets/Header";

const ArticlesPage = () => {
    return (
        <>
        <Header />
        <Container>
            <div className="d-flex flex-wrap justify-content-center" style={{gap:"15px", margin:"20px auto"}}>
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Женщины - тайна человечества" preview_image="assets/articles/kirk.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
                <ArticleCard title="Топ 10 вещей, которые могут рассказать о вашей ориентации" preview_image="assets/articles/fags.jpg" create_at="1.08.2025" />
            </div>
        </Container>
        </>
    )
}

export default ArticlesPage;