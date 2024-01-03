package com.example.demo.StudentDao;

import java.util.List;

public interface StudentBatchInterface {

    int batchUpdate(List<Object[]> batchValues);
}
