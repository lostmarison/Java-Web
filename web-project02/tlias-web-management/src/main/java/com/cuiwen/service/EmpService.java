package com.cuiwen.service;

import com.cuiwen.pojo.Emp;
import com.cuiwen.pojo.EmpQueryParam;
import com.cuiwen.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> getPage(EmpQueryParam empQueryParam);
}
