IF EXISTS (SELECT "" FROM form.TABLE WHERE TABLE_NAME = N'user_info')
    BEGIN
        INSERT INTO user_info (id, full_name, contact_no) VALUES (1, "Ankit Kumar", "9024923695");
        INSERT INTO user_info (id, full_name, contact_No) VALUES (2, "sumit Kumar", "9024923695");
        INSERT INTO user_info (id, full_name, contact_no) VALUES (3, "mayank anand", "9024923695");
        INSERT INTO user_info (id, full_name, contact_no) VALUES (4, "Medhavi Srivastava", "9024923695");
        INSERT INTO user_info (id, full_name, contact_No) VALUES (5, "Medhavi kumar", "9024923695");
        INSERT INTO user_info (id, full_name, contact_no) VALUES (6, "Medhavi Anand", "9024923695");
    END