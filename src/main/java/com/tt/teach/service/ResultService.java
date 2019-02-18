package com.tt.teach.service;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;

import java.util.List;

public interface ResultService {
    List<Result> findResAll();

    int deleteResult(Integer resultNo);

    int updateResult(Result result2);

    int addResult(Result result2);

    List<Subject> getSubjectAll();
}
