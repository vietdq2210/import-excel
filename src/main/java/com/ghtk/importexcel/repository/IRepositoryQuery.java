package com.ghtk.importexcel.repository;

public interface IRepositoryQuery {
    String STUDENT_UPDATE_ONE = "UPDATE students.student " +
            "SET primary_school = ?, district = ?, roll_number = ?, class = ?, " +
            "name = ?, day = ?, month = ?, year = ?, gender = ?, placeOfBirth = ?, " +
            "nation = ?, permanent_residence = ?, phone_number = ?, " +
            "grade_1 = ?, grade_2 = ?, grade_3 = ?, grade_4 = ?, grade_5 = ?, grade_final = ?, " +
            "priority_point = ?, total_point = ?, note = ? WHERE stt = ?";

    String STUDENT_INSERT_ONE = "INSERT INTO students.student (primary_school, district, roll_number, " +
            "class, name, day, month, year, gender, placeOfBirth, nation, permanent_residence, phone_number, " +
            "grade_1, grade_2, grade_3, grade_4, grade_5, grade_final, priority_point, total_point, note) " +
            "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String FIND_ALL = "SELECT * FROM student";
    String FIND_BY_NAME = "SELECT * FROM student where name = ?";

    String FIND_BY_ROLL_NUMBER = "SELECT * FROM student where roll_number = ?";

    String SEARCH_BY_NAME = "SELECT * FROM student where name LIKE ?";
}
