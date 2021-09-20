package com.atlan.ErrorDataService.Models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDTORequest {

    private String message;

    private String instancePort;

    private String className;
}
