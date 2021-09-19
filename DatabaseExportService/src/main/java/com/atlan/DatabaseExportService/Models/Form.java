package com.atlan.DatabaseExportService.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

}
