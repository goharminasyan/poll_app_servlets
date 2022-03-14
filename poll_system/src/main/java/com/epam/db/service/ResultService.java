package com.epam.db.service;

import com.epam.db.model.Result;
import com.epam.db.model.Users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ResultService extends PollService<Result> {

    List<Result> findByPollId(long pollId);

    Result findByScore(long pollId, long score);

}
