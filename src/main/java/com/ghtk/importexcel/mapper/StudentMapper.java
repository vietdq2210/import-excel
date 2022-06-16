package com.ghtk.importexcel.mapper;


import com.ghtk.importexcel.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Student.builder()
                .stt(rs.getInt("stt"))
                .primarySchool(rs.getString("primary_school"))
                .district(rs.getString("roll_number"))
                .rollNumber(rs.getString("class"))
                .classStudent(rs.getString("class"))
                .name(rs.getString("name"))
                .day(rs.getInt("day"))
                .month(rs.getInt("month"))
                .year(rs.getInt("year"))
                .gender(rs.getString("gender"))
                .placeOfBirth(rs.getString("placeOfBirth"))
                .nation(rs.getString("nation"))
                .permanentResidence(rs.getString("permanent_residence"))
                .phoneNumber(rs.getString("phone_number"))
                .grade1(rs.getInt("grade_1"))
                .grade2(rs.getInt("grade_2"))
                .grade3(rs.getInt("grade_3"))
                .grade4(rs.getInt("grade_4"))
                .grade5(rs.getInt("grade_5"))
                .gradeFinal(rs.getInt("grade_final"))
                .priorityPoint(rs.getInt("priority_point"))
                .totalPoint(rs.getInt("total_point"))
                .note(rs.getString("note"))
                .build();
    }
}
