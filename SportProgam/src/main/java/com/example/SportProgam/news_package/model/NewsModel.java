package com.example.SportProgam.news_package.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private String url;
    @Column(columnDefinition = "varchar(20000)")
    private String body;
    private String author;


}
