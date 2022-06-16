package com.ghtk.importexcel.service.impl;

import com.ghtk.importexcel.entity.Student;
import com.ghtk.importexcel.repository.StudentRepository;
import com.ghtk.importexcel.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findALl() throws DataAccessException {
        return studentRepository.findALl();
    }

    @Override
    public List<Student> findByName() throws DataAccessException {
        return studentRepository.findByName();
    }

    @Override
    public List<Student> findByRollNumber() throws DataAccessException {
        return studentRepository.findByRollNumber();
    }

    @Override
    public boolean update(Student obj) throws DataAccessException {
        return studentRepository.update(obj);
    }

    @Override
    public int insert(Student obj) throws DataAccessException {
        return studentRepository.insert(obj);
    }

    @Override
    public void importExcelFile(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Student student = new Student();
        for (int i = 5; i < firstSheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = firstSheet.getRow(i);
            Student s1 = new Student(
                    (int)(row.getCell(0).getNumericCellValue()),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    Integer.parseInt(row.getCell(6).getStringCellValue()),
                    Integer.parseInt(row.getCell(7).getStringCellValue()),
                    Integer.parseInt(row.getCell(8).getStringCellValue()),
                    row.getCell(9).getStringCellValue(),
                    row.getCell(10).getStringCellValue(),
                    row.getCell(11).getStringCellValue(),
                    row.getCell(12).getStringCellValue(),
                    row.getCell(13).getStringCellValue(),
                    (int)(row.getCell(14).getNumericCellValue()),
                    (int)(row.getCell(15).getNumericCellValue()),
                    (int)(row.getCell(16).getNumericCellValue()),
                    (int)(row.getCell(17).getNumericCellValue()),
                    (int)(row.getCell(18).getNumericCellValue()),
                    (int)(row.getCell(19).getNumericCellValue()),
                    (int)(row.getCell(20).getNumericCellValue()),
                    (int)(row.getCell(21).getNumericCellValue()),
                    row.getCell(22).getStringCellValue()
            );
            insert(s1);
        }
    }

    @Override
    public List<Student> search(String textSearch) throws DataAccessException {
        return studentRepository.search(textSearch);
    }
}
