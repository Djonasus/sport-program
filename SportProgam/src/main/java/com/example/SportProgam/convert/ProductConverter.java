package com.example.SportProgam.convert;

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

}
