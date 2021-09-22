IF EXISTS (SELECT "" FROM form.TABLE WHERE TABLE_NAME =N'error')
    BEGIN
        INSERT INTO error VALUES (1, "com.atlan.formService.Controller.Impl.FormControllerImpl", "Sun Sep 19 10:41:29 IST 2021", "8080", "Error caused by nullPointer Exception");
        INSERT INTO error VALUES (2, "com.atlan.formService.Controller.Impl.FormControllerImpl", "Sun Sep 19 11:25:21 IST 2021", "8088", "Error caused by nullPointer Exception at line 5");
        INSERT INTO error VALUES (3, "com.atlan.formService.Controller.Impl.FormControllerImpl", "Sun Sep 19 11:25:26 IST 2021", "8090", "Id not found");
    END