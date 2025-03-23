package com.example.SportProgam.news_package.convert;

import com.example.SportProgam.ApiConfig;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;
import com.example.SportProgam.news_package.dto.ChildrenResponseDto;
import com.example.SportProgam.news_package.model.NewsModel;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {

    private final String IMAGE_URL = "http://" + ApiConfig.SERVER_IP + ":" + ApiConfig.SERVER_PORT + "/api/image/";

    public ChildrenResponseDto convertToChildren(NewsModel newsModel) {
        return new ChildrenResponseDto(
                newsModel.getId(),
                newsModel.getTitle(),
                newsModel.getDate(),
                IMAGE_URL + newsModel.getUrl()

        );
    }


    public ArticleDetailDto converterToDetailDto(NewsModel newsModel) {
        return new ArticleDetailDto(
                newsModel.getId(),
                newsModel.getTitle(),
                newsModel.getDate(),
                newsModel.getBody(),
                IMAGE_URL + newsModel.getUrl(),
                newsModel.getAuthor()
        );
    }
}
