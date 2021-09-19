package com.atlan.DatabaseExportService.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public interface FormController {

    void getAllFormInfo(HttpServletResponse response) throws IOException;

    void getFormInfoByFormAndQuestionId(HttpServletResponse response, Integer FormId, Integer QuestionId) throws IOException;

}
