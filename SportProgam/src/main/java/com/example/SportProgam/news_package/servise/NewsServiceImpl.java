package com.example.SportProgam.news_package.servise;

import com.example.SportProgam.ApiConfig;
import com.example.SportProgam.image_package.service.ImageService;
import com.example.SportProgam.news_package.convert.ProductConverter;
import com.example.SportProgam.news_package.dto.AllArticlesResponseDto;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;
import com.example.SportProgam.news_package.dto.ChildrenResponseDto;
import com.example.SportProgam.news_package.model.NewsModel;
import com.example.SportProgam.news_package.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ProductConverter converter;
    private final ImageService imageService;

    @Override
    public AllArticlesResponseDto getAllWithLimit(Long limit, Boolean shuffle) {
        List<NewsModel> newsModelList;
        if (limit != null) {
            if (shuffle) {
                newsModelList = newsRepository.findAllWithLimitAndNoSorted(limit);
            } else {
                newsModelList = newsRepository.findAllWithLimitAndSorted(limit);
            }
        } else {
            if (shuffle) {
                newsModelList = newsRepository.findAllWithoutLimitAndNoSorted();
            } else {
                newsModelList = newsRepository.findAll();
            }
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

    @Override
    public void createNews(MultipartFile multipartFile, String title, String body, String author) throws IOException {
        Long imageId = imageService.saveNewsImage(multipartFile);
        newsRepository.save(
                new NewsModel(
                        newsRepository.count()+1,
                        title,
                        getTodayDate(),
                        imageId.toString(),
                        body,
                        author
                )
        );
    }

    private String getTodayDate() {
        // Задаем формат даты
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Форматируем дату в строку
        return formatter.format(new Date());
    }
}
