package com.atlan.DatabaseExportService.Models.ExportDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormExport {

    private Integer serialNo;

    private Integer formId;

    private String formTitle;

    private String formCreated;

    private Integer QuestionId;

    private String QuestionValue;

    private String CorrectAnswer;

    private Integer responseId;

    private String responseValue;

    private String responseCreated;

    public static String[] formExportDisplayName = new String[]{"serialNo", "formId", "formTitle", "formCreated", "questionId", "questionValue", "correctAnswer", "responseId", "responseValue", "responseCreated"};

    public static String[] formExportName = new String[]{"serialNo", "formId", "formTitle", "formCreated", "questionId", "questionValue", "correctAnswer", "responseId", "responseValue", "responseCreated"};

}
