import { Breadcrumb, Container, Image, Spinner } from "react-bootstrap";

import Header from "../components/Header";

import { Link, useParams } from "react-router-dom";
import Markdown from "react-markdown";
import Articles from "../components/Articles";

import axios from "axios";
import ApiConfig from "../ApiConfig";

import { useState, useEffect } from "react";
import PFooter from "../components/PFooter";

const ArticleDetailPage = () => {
    const params = useParams();
    const id = params.id
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`
    useEffect(
        () => {
          axios.get(ApiConfig.remoteAddress+ApiConfig.getArticleDetail+id).then(response => {
              setArticle(response.data);
              console.log(response.data);
              setLoading(false);
          }).catch(error => {
              console.log(error);
          });
        }  
      ,[id]);

    const [article, setArticle] = useState([]);
    const [loading, setLoading] = useState(true);

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
                {
                    loading ? (
                        <Spinner animation="border" />
                    ) : (
                        <>
                            <Breadcrumb>
                                <Breadcrumb.Item active><Link to="/">Главная</Link></Breadcrumb.Item>
                                <Breadcrumb.Item active><Link to="/article">Статьи</Link></Breadcrumb.Item>
                                <Breadcrumb.Item active>{article.title}</Breadcrumb.Item>
                            </Breadcrumb>
                            <Image style={{width:"100%", height:"40em", objectFit:"cover", marginBlockEnd:"40px"}} src={ApiConfig.remoteAddress+article.preview} fluid/>
                            <h1>{article.title}</h1>
                            <Markdown>
                                {article.body}
                            </Markdown>
                            <h1>Читайте также</h1>
                            <Articles shuffle limit={4}/>
                        </>
                    )
                }
            </Container>
            <PFooter />
        </>
    )
}

export default ArticleDetailPage;