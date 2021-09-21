package com.atlan.DatabaseExportService.Controller.Impl;

import com.atlan.DatabaseExportService.Controller.FormController;
import com.atlan.DatabaseExportService.GoogleSheet.GoogleCredentialHelperClass;
import com.atlan.DatabaseExportService.Models.DTO.FormDTOResponse;
import com.atlan.DatabaseExportService.Models.DTO.GoogleSheetDTOResponse;
import com.atlan.DatabaseExportService.Models.DTO.QuestionDTOResponse;
import com.atlan.DatabaseExportService.Models.DTO.ResponseDTOResponse;
import com.atlan.DatabaseExportService.Models.ExportDTO.FormExport;
import com.atlan.DatabaseExportService.Repositories.FormRepository;
import com.atlan.DatabaseExportService.Service.FormService;
import com.atlan.DatabaseExportService.Service.QuestionService;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class FormControllerImpl implements FormController {

    @Autowired
    private FormService service;

    @Autowired
    private QuestionService questionService;

    private List<FormDTOResponse> list;

    private static Sheets sheets;

    private static String APPLICATION_NAME = "Google Sheets Example";

    private static String SPREADSHEET_ID = "10HExvi0xY8uwQO99px--SyasbIc_-aCd-jZTHPi1B1Y";

    private static String BASE_URL_SHEET = "https://docs.google.com/spreadsheets/d/";

    @Override
    @GetMapping("download/forms")
    public void getAllFormInfo(HttpServletResponse response) throws IOException {

        response.setContentType("csv/text");
        response.setHeader("Content-Disposition", "attachment; filename=File.csv");

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvBeanWriter.writeHeader(FormExport.formExportDisplayName);

        list = service.getAllResult();

        if (!list.isEmpty()) {

            Integer count = 1;

            for (FormDTOResponse formDTOResponse : list) {

                for (QuestionDTOResponse questionDTOResponse : formDTOResponse.getQuestionList()) {

                    for (ResponseDTOResponse responseDTOResponse : questionDTOResponse.getResponseList()) {

                        FormExport formExport = new FormExport(count, formDTOResponse.getId(), formDTOResponse.getTitle(),
                                formDTOResponse.getCreated(), questionDTOResponse.getId(), questionDTOResponse.getValue(),
                                questionDTOResponse.getAnswer(), responseDTOResponse.getId(), responseDTOResponse.getValue(),
                                responseDTOResponse.getCreated());

                        csvBeanWriter.write(formExport, FormExport.formExportName);
                        count++;

                    }
                }
            }
            csvBeanWriter.close();
        }


    }

    @Override
    @GetMapping("/download/form")
    public void getFormInfoByFormAndQuestionId(HttpServletResponse response, @RequestParam(value = "form", required = false) Integer formId, @RequestParam(value = "question", required = false) Integer questionId) throws IOException {

        System.out.println("aaaa");

        response.setContentType("csv/text");
        response.setHeader("Content-Disposition", "attachment; filename=File.csv");

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvBeanWriter.writeHeader(FormExport.formExportDisplayName);

        list = service.getAllResult();

        if (!list.isEmpty()) {

            Integer count = 1;

            for (FormDTOResponse formDTOResponse : list) {

                for (QuestionDTOResponse questionDTOResponse : formDTOResponse.getQuestionList()) {

                    for (ResponseDTOResponse responseDTOResponse : questionDTOResponse.getResponseList()) {

                        FormExport formExport = new FormExport(count, formDTOResponse.getId(), formDTOResponse.getTitle(),
                                formDTOResponse.getCreated(), questionDTOResponse.getId(), questionDTOResponse.getValue(),
                                questionDTOResponse.getAnswer(), responseDTOResponse.getId(), responseDTOResponse.getValue(),
                                responseDTOResponse.getCreated());

                        if (formExport != null && formDTOResponse.getId().equals(formId)) {
                            csvBeanWriter.write(formExport, FormExport.formExportName);
                        }

                        if (questionId != null && questionDTOResponse.getId() == questionId) {
                            csvBeanWriter.write(formExport, FormExport.formExportName);
                        }
                        count++;

                    }
                }
            }
            csvBeanWriter.close();
        }
    }

    @Override
    @GetMapping("/download/google")
    public ResponseEntity<GoogleSheetDTOResponse> getGoogleSheet() throws IOException, GeneralSecurityException {

        String createdSheet = createSheet();

        List<QuestionDTOResponse> questionDTOResponses = questionService.getAll();

        ValueRange valueRange = new ValueRange();

        List<List<String>> value = new ArrayList<>();

        questionDTOResponses.forEach( temp -> {
            List<String> question = new ArrayList<>();
            question.add("Question ID : " + temp.getId());
            question.add(temp.getValue());
            question.add((""));
            temp.getResponseList().forEach( response -> {
                question.add(response.getValue());
            });
            value.add(question);
        });

        valueRange.setValues(transform(value));

        sheets = GoogleCredentialHelperClass.getSheetsService();

        AppendValuesResponse appendValuesResponse = sheets.spreadsheets().values()
                .append(createdSheet, "A1", valueRange)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("OVERWRITE")
                .setIncludeValuesInResponse(true)
                .execute();

        if (appendValuesResponse != null) {
            return ResponseEntity.ok().body(new GoogleSheetDTOResponse(BASE_URL_SHEET + appendValuesResponse.getSpreadsheetId(), new Date().toString()));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String createSheet() throws IOException, GeneralSecurityException {
        Spreadsheet spreadsheet = new Spreadsheet()
                .setProperties(new SpreadsheetProperties()
                .setTitle("Atlan Backed Example"));

        spreadsheet = GoogleCredentialHelperClass.getSheetsService().spreadsheets().create(spreadsheet)
                .setFields("spreadsheetId")
                .execute();

        return spreadsheet.getSpreadsheetId();
    }

    private List<List<Object>> transform(List<List<String>> list) {

        Integer size = list.size();

        int max = Integer.MIN_VALUE;

        for (int a = 0; a < size; a++) {
            max = Math.max(max, list.get(a).size());
        }

        List<String>[] arr = new List[max];

        for (int a = 0; a < max; a++) {
            List<String> temp = new ArrayList<>();

            for (int b = 0; b < size; b++) {

                if (list.get(b).size() <= a) {
                    temp.add(" ");
                } else {
                    temp.add(list.get(b).get(a));
                }
            }

            arr[a] = temp;
        }

        List<List<Object>> result = new ArrayList<>();

        for (int a = 0; a < max; a++) {
            result.add(new ArrayList<Object>(arr[a]));
        }

        return result;
    }
}
