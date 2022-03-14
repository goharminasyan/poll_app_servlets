package com.epam.db.service;

import com.epam.db.model.Poll;
import com.epam.db.model.Question;

import java.util.List;

public interface QuestionService extends PollService<Question> {

    List<Question> findByPollId(long pollId);
}
