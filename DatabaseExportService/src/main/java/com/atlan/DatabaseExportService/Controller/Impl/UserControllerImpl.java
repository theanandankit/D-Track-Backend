package com.atlan.DatabaseExportService.Controller.Impl;

import com.atlan.DatabaseExportService.Controller.UserController;
import com.atlan.DatabaseExportService.Models.User;
import com.atlan.DatabaseExportService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    private List<User> list;

    @Override
    @GetMapping("/download/users")
    public void getAllUser(HttpServletResponse response) throws IOException {

        System.out.println(response.toString());

        response.setContentType("csv/text");
        response.setHeader("Content-Disposition", "attachment; filename=users.csv");

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvBeanWriter.writeHeader(User.getDisplayName());

        list = userService.getAllUser();

        if (!list.isEmpty()) {
            for (User user : list) {
                csvBeanWriter.write(user, User.getName());
            }

            csvBeanWriter.close();
        }
    }
}
