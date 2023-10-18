package com.example.wanted.entity;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.swing.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recruiting")
public class Recruiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "compensation")
    private int compensation;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;

}
