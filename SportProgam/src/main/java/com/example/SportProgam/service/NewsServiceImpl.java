package com.example.SportProgam.service;

import com.example.SportProgam.convert.ProductConverter;
import com.example.SportProgam.dto.AllArticlesResponseDto;
import com.example.SportProgam.dto.ChildrenResponseDto;
import com.example.SportProgam.model.NewsModel;
import com.example.SportProgam.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ProductConverter converter;

    @Override
    public AllArticlesResponseDto getAllWithLimit(Long limit) {
        List<NewsModel> newsModelList = newsRepository.findAll().stream()
                .limit(limit)
                .toList();
        List<ChildrenResponseDto> childrenResponseDtoList = new ArrayList<>();
        for (NewsModel newsModel : newsModelList) {
            childrenResponseDtoList.add(converter.convertToChildren(newsModel));
        }
        return new AllArticlesResponseDto(
            childrenResponseDtoList
        );
    }
}
