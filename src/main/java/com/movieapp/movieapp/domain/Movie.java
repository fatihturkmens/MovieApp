package com.movieapp.movieapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)  // bunun setterini ayrı tutmuş oldum
    private Long id;

    // film adi boş ve null olamaz o yüzden
    @Column(nullable = false,length = 50) // veritabanında asla boş bırakılamayacıgını ve uzunlugun max 50 olacagını girdim
    private String movieName;

    @Column
    private double movieScore;


    @Column(nullable = false,length = 30)
    private String movieDirector;


    @Column(nullable = false,length = 30)
    private int movieYear;
}
