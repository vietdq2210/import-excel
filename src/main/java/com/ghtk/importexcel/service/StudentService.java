package com.ghtk.importexcel.service;

import com.ghtk.importexcel.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    List<Student> findALl() throws DataAccessException;
    List<Student> findByName() throws DataAccessException;
    List<Student> findByRollNumber() throws DataAccessException;
    boolean update(Student obj) throws DataAccessException;

    int insert(Student obj) throws DataAccessException;

    void importExcelFile(MultipartFile file) throws IOException;

    List<Student> search(String textSearch) throws DataAccessException;
}
