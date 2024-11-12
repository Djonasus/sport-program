package com.example.SportProgam.convert;

import com.example.SportProgam.dto.ArticleDetailDto;
import com.example.SportProgam.dto.ChildrenResponseDto;
import com.example.SportProgam.model.NewsModel;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {

    public ChildrenResponseDto convertToChildren(NewsModel newsModel) {
        return new ChildrenResponseDto(
                newsModel.getId(),
                newsModel.getTitle(),
                newsModel.getDate(),
                newsModel.getUrl()

        );
    }


    public ArticleDetailDto converterToDetailDto(NewsModel newsModel) {
        return new ArticleDetailDto(
                newsModel.getId(),
                newsModel.getTitle(),
                newsModel.getDate(),
                newsModel.getBody(),
                newsModel.getUrl(),
                newsModel.getAuthor()
        );
    }
}
