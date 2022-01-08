package com.example.test.entity;

import com.example.test.entity.id.NewsCommentId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "news_comment")
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsComment {
    @EmbeddedId
    NewsCommentId id;

    @Column(name = "news_text")
    String text;
}
