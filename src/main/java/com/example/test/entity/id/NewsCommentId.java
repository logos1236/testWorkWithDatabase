package com.example.test.entity.id;

import com.example.test.entity.News;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class NewsCommentId implements Serializable {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "news_id")
    News news;

    @Column(name = "date_create", updatable = false, insertable = false, nullable = false)
    LocalDateTime dateCreate;

    public NewsCommentId(News news) {
        this.news = news;
        this.dateCreate = LocalDateTime.now();
    }
}
