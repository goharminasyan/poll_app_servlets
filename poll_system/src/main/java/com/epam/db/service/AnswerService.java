package com.epam.db.service;

import com.epam.db.model.Answer;

import java.util.List;

public interface AnswerService extends PollService<Answer> {

    List<Answer> findByQuestionId(long questionId);
}
