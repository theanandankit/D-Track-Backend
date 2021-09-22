IF EXISTS (SELECT "" FROM form.TABLE WHERE TABLE_NAME =N'form')
    BEGIN
        INSERT INTO form VALUES (1, "Sun Sep 19 10:41:29 IST 2021", "India's Capital Test");
        INSERT INTO form VALUES (2, "Sun Sep 19 11:25:21 IST 2021", "Who many states in india?");
        INSERT INTO form VALUES (3, "Sun Sep 19 11:25:21 IST 2021", "What is your age?");
    END

IF EXISTS (SELECT "" FROM form.TABLE WHERE TABLE_NAME =N'question')
    BEGIN
        INSERT INTO question VALUES (1, "New Delhi","Sun Sep 19 10:41:29 IST 2021", 1,"What is the India's Capital Test?");
        INSERT INTO question VALUES (2, "28","Sun Sep 19 11:25:22 IST 2021", 2, "Who many states in india?");
        INSERT INTO question VALUES (3, " ", "Sun Sep 19 11:25:23 IST 2021", 3, "What is your age?");
        INSERT INTO question VALUES (4, "New Delhi","Sun Sep 19 10:41:24 IST 2021", 1, "what is the Bihar's Capital city name?");
        INSERT INTO question VALUES (5, "28","Sun Sep 19 11:25:25 IST 2021", 2,"Who many Union territories in india?");
        INSERT INTO question VALUES (6, " ", "Sun Sep 19 11:25:26 IST 2021", 3,"What is your Date of Birth?");
    END

IF EXISTS (SELECT "" FROM form.TABLE WHERE TABLE_NAME =N'response')
    BEGIN
        INSERT INTO response VALUES (1, "Sun Sep 19 10:41:29 IST 2021", 1, "Mumbai");
        INSERT INTO response VALUES (2, "Sun Sep 19 11:25:22 IST 2021", 1, "Delhi");
        INSERT INTO response VALUES (3, "Sun Sep 19 11:25:23 IST 2021", 1, "New Delhi");
        INSERT INTO response VALUES (4, "Sun Sep 19 10:41:24 IST 2021", 1, "New Delhi");
        INSERT INTO response VALUES (5, "Sun Sep 19 11:25:25 IST 2021", 1, "Lucknow");
        INSERT INTO response VALUES (6, "Sun Sep 19 11:25:26 IST 2021", 1, "New Delhi");
        INSERT INTO response VALUES (7, "Sun Sep 19 10:41:29 IST 2021", 2, "30");
        INSERT INTO response VALUES (8, "Sun Sep 19 11:25:22 IST 2021", 2, "28");
        INSERT INTO response VALUES (9, "Sun Sep 19 11:25:23 IST 2021", 2, "28");
        INSERT INTO response VALUES (10, "Sun Sep 19 10:41:24 IST 2021", 3, "18");
        INSERT INTO response VALUES (11, "Sun Sep 19 11:25:25 IST 2021", 3, "40");
        INSERT INTO response VALUES (12, "Sun Sep 19 11:25:26 IST 2021", 3, "Patna");
        INSERT INTO response VALUES (13, "Sun Sep 19 10:41:29 IST 2021", 4, "Mumbai");
        INSERT INTO response VALUES (14, "Sun Sep 19 11:25:22 IST 2021", 4, "Delhi");
        INSERT INTO response VALUES (15, "Sun Sep 19 11:25:23 IST 2021", 4, "New Delhi");
        INSERT INTO response VALUES (16, "Sun Sep 19 10:41:24 IST 2021", 4, "Patna");
        INSERT INTO response VALUES (17, "Sun Sep 19 11:25:25 IST 2021", 4, "Patna");
        INSERT INTO response VALUES (18, "Sun Sep 19 11:25:26 IST 2021", 4, "Patna");
        INSERT INTO response VALUES (19, "Sun Sep 19 10:41:29 IST 2021", 4, "Gaya");
        INSERT INTO response VALUES (20, "Sun Sep 19 11:25:22 IST 2021", 4, "Gaya");
        INSERT INTO response VALUES (21, "Sun Sep 19 11:25:23 IST 2021", 4, "Patna");
        INSERT INTO response VALUES (22, "Sun Sep 19 10:41:24 IST 2021", 4, "Patna");
        INSERT INTO response VALUES (23, "Sun Sep 19 11:25:25 IST 2021", 5, "8");
        INSERT INTO response VALUES (24, "Sun Sep 19 11:25:26 IST 2021", 5, "7");
    END