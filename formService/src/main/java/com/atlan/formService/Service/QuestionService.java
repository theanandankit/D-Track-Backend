package com.atlan.formService.Service;

import com.atlan.formService.Models.Form;
import com.atlan.formService.Models.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getByForm(Form form);

    Question add(Question question);
}
