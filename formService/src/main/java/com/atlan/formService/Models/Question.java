package com.atlan.formService.Models;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

    private String created;

    private String answer;

    private Integer form;
}
