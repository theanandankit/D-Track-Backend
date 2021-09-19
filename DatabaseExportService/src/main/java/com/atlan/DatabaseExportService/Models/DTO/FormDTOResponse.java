package com.atlan.DatabaseExportService.Models.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FormDTOResponse {

    private Integer id;

    private String title;

    private List<QuestionDTOResponse> questionList;

    private String created;

    public static String[] getDisplayName() {
        return new String[]{"ID", "Title", "Questions", "Created"};
    }

    public static String[] getName() {
        return new String[]{"id", "title", "questionList", "created"};
    }

}
