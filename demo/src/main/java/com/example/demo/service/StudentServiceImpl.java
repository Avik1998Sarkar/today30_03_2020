package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.model.Address;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private AddressDao addressDao;

	@Override
	public int create(Student student) {
		int add = addressDao.create(student.getAddress());
		int stu = studentDao.create(student);
		if (add > 0 && stu > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int update(Student student) {
		int add = addressDao.update(student.getAddress());
		int stu = studentDao.update(student);
		if (add > 0 && stu > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(Student student) {
		int add = addressDao.delete(student.getAddress());
		int stu = studentDao.delete(student);
		if (add > 0 && stu > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Student> findAll() {
		List<Address> addresslist = addressDao.findAll();
		List<Student> studentList = studentDao.findAll();
		List<Student> finalList = new ArrayList<>();
		for (Student student : studentList) {
			if (student.getAddress().getHouseNo() == null) {
				student.getAddress().setHouseNo("-");
				student.getAddress().setCity("-");
			} else {
				for (Address add : addresslist) {
					if (add.getHouseNo().equals(student.getAddress().getHouseNo())) {
						student.getAddress().setCity(add.getCity());
						break;
					}
				}
			}
			finalList.add(student);
		}
		return finalList;
	}
}