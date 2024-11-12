import { Breadcrumb, Container, Image } from "react-bootstrap";
import Header from "../componets/Header";

import { Link, useParams } from "react-router-dom";
import Markdown from "react-markdown";
import Articles from "../components/Articles";

const ArticleDetailPage = () => {
    // const params = useParams();
    // const id = params.id

    const markdown = `
    Сегодня, я узнал про такого замечательного человека как [Вставьте любое имя]! Замечательный человек, который...
    Сайт рыбатекст поможет дизайнеру, верстальщику, вебмастеру сгенерировать несколько абзацев более менее осмысленного текста рыбы на 
    русском языке, а начинающему оратору отточить навык публичных выступлений в домашних условиях. При создании генератора мы 
    использовали небезизвестный универсальный код речей. Текст генерируется абзацами случайным образом от двух до десяти предложений в 
    абзаце, что позволяет сделать текст более привлекательным и живым для визуально-слухового восприятия.

    По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который вызывает 
    у некторых людей недоумение при попытках прочитать рыбу текст. В отличии от lorem ipsum, текст рыба на русском языке наполнит 
    любой макет непонятным смыслом и придаст неповторимый колорит советских времен.`

    return (
        <>
            <Header />
            <Container style={{marginTop: "20px"}}>
                <Breadcrumb>
                    <Breadcrumb.Item active>Главная</Breadcrumb.Item>
                    <Breadcrumb.Item active>Статьи</Breadcrumb.Item>
                    <Breadcrumb.Item active>Хроники Киркорова</Breadcrumb.Item>
                </Breadcrumb>
                <Image style={{width:"100%", height:"40em", objectFit:"cover", marginBlockEnd:"40px"}} src={"/"+"assets/articles/kirk.jpg"} fluid/>
                <h1>Хроники Киркорова</h1>
                <Markdown>
                    {markdown}
                </Markdown>
                <h1>Читайте также</h1>
                <Articles shuffle/>
            </Container>
        </>
    )
}

export default ArticleDetailPage;