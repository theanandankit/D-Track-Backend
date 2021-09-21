package com.atlan.DatabaseExportService.Controller;

import com.atlan.DatabaseExportService.Models.DTO.GoogleSheetDTOResponse;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface FormController {

    void getAllFormInfo(HttpServletResponse response) throws IOException;

    void getFormInfoByFormAndQuestionId(HttpServletResponse response, Integer FormId, Integer QuestionId) throws IOException;

    ResponseEntity<GoogleSheetDTOResponse> getGoogleSheet() throws IOException, GeneralSecurityException;

}
