package com.ghtk.importexcel.repository.impl;

import com.ghtk.importexcel.entity.Student;
import com.ghtk.importexcel.mapper.StudentMapper;
import com.ghtk.importexcel.repository.IRepositoryQuery;
import com.ghtk.importexcel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findALl() throws DataAccessException {
        return jdbcTemplate.query(FIND_ALL,new StudentMapper());
    }

    @Override
    public List<Student> findByName() throws DataAccessException {
        return jdbcTemplate.query(FIND_BY_NAME,new StudentMapper());
    }

    @Override
    public List<Student> findByRollNumber() throws DataAccessException {
        return jdbcTemplate.query(FIND_BY_ROLL_NUMBER,new StudentMapper());
    }

    @Override
    public boolean update(Student obj) throws DataAccessException {
        return jdbcTemplate.update(
                STUDENT_UPDATE_ONE,
                obj.getPrimarySchool(),
                obj.getDistrict(),
                obj.getRollNumber(),
                obj.getClassStudent(),
                obj.getName(),
                obj.getDay(),
                obj.getMonth(),
                obj.getYear(),
                obj.getGender(),
                obj.getPlaceOfBirth(),
                obj.getNation(),
                obj.getPermanentResidence(),
                obj.getPhoneNumber(),
                obj.getGrade1(),
                obj.getGrade2(),
                obj.getGrade3(),
                obj.getGrade4(),
                obj.getGrade5(),
                obj.getGradeFinal(),
                obj.getPriorityPoint(),
                obj.getTotalPoint(),
                obj.getNote()
        ) > 0;
    }

    @Override
    public int insert(Student obj) throws DataAccessException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(STUDENT_INSERT_ONE, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, obj.getPrimarySchool());
            ps.setObject(2, obj.getDistrict());
            ps.setObject(3, obj.getRollNumber());
            ps.setObject(4, obj.getClassStudent());
            ps.setObject(5, obj.getName());
            ps.setObject(6, obj.getDay());
            ps.setObject(7, obj.getMonth());
            ps.setObject(8, obj.getYear());
            ps.setObject(9, obj.getGender());
            ps.setObject(10, obj.getPlaceOfBirth());
            ps.setObject(11, obj.getNation());
            ps.setObject(12, obj.getPermanentResidence());
            ps.setObject(13, obj.getPhoneNumber());
            ps.setObject(14, obj.getGrade1());
            ps.setObject(15, obj.getGrade2());
            ps.setObject(16, obj.getGrade3());
            ps.setObject(17, obj.getGrade4());
            ps.setObject(18, obj.getGrade5());
            ps.setObject(19, obj.getGradeFinal());
            ps.setObject(20, obj.getPriorityPoint());
            ps.setObject(21, obj.getTotalPoint());
            ps.setObject(22, obj.getNote());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Student> search(String textSearch) throws DataAccessException {
        return jdbcTemplate.query(SEARCH_BY_NAME, new StudentMapper(),"%" + textSearch + "%");
    }
}
