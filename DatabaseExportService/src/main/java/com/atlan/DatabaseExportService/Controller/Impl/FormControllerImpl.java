package com.atlan.DatabaseExportService.Controller.Impl;

import com.atlan.DatabaseExportService.Controller.FormController;
import com.atlan.DatabaseExportService.Models.DTO.FormDTOResponse;
import com.atlan.DatabaseExportService.Models.DTO.QuestionDTOResponse;
import com.atlan.DatabaseExportService.Models.DTO.ResponseDTOResponse;
import com.atlan.DatabaseExportService.Models.ExportDTO.FormExport;
import com.atlan.DatabaseExportService.Repositories.FormRepository;
import com.atlan.DatabaseExportService.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class FormControllerImpl implements FormController {

    @Autowired
    private FormService service;

    private List<FormDTOResponse> list;

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
}
