package com.ghtk.importexcel.repository;

import com.ghtk.importexcel.entity.Student;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface StudentRepository {
    List<Student> findALl() throws DataAccessException;
    List<Student> findByName() throws DataAccessException;
    List<Student> findByRollNumber() throws DataAccessException;
    boolean update(Student obj) throws DataAccessException;
    int insert(Student obj) throws DataAccessException;
    List<Student> search(String textSearch) throws DataAccessException;
}
