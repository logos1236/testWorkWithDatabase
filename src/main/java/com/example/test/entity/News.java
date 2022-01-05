package com.example.test.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(generator = "hibernate_seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "hibernate_seq_generator", sequenceName = "hibernate_seq", allocationSize = 1)
    Long id;

    String name;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false, insertable = false)
    @Generated(
            GenerationTime.INSERT
    )
    Date creationDate;

    @Column(name = "update_date", nullable = false, insertable = false, updatable = false)
    @UpdateTimestamp
    LocalDateTime updateDate;
}
