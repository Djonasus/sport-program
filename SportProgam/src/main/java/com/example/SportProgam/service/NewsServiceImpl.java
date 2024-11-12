package com.example.SportProgam.service;

import com.example.SportProgam.convert.ProductConverter;
import com.example.SportProgam.dto.AllArticlesResponseDto;
import com.example.SportProgam.dto.ArticleDetailDto;
import com.example.SportProgam.dto.ChildrenResponseDto;
import com.example.SportProgam.model.NewsModel;
import com.example.SportProgam.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ProductConverter converter;

    @Override
    public AllArticlesResponseDto getAllWithLimit(Long limit) {
        List<NewsModel> newsModelList;
        if (limit != null) {
            newsModelList = newsRepository.findAllWithLimitAndNoSorted(limit);
        }else {
            newsModelList = newsRepository.findAll();
        }
        List<ChildrenResponseDto> childrenResponseDtoList = new ArrayList<>();
        for (NewsModel newsModel : newsModelList) {
            childrenResponseDtoList.add(converter.convertToChildren(newsModel));
        }
        return new AllArticlesResponseDto(
                childrenResponseDtoList
        );
    }

    @Override
    public ArticleDetailDto getById(Long id) {

        if (newsRepository.findById(id).isPresent()) {
            NewsModel newsModel = newsRepository.findById(id).get();
            return converter.converterToDetailDto(newsModel);
        } else {
            log.info("optional error");
        }
        return null;
    }
}
