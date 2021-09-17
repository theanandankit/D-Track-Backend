package com.atlan.FormLoadBalanceService.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Form {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String title;

    private String created;

    @OneToOne(cascade = CascadeType.ALL)
    private User createdBy;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;

}
