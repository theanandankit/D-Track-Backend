package com.atlan.DatabaseExportService.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserController {

    void getAllUser(HttpServletResponse response) throws IOException;

}
