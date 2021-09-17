package com.atlan.DatabaseExportService.Models;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;
}