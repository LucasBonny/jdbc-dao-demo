package application;

import java.util.List;

import db.DB;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = new DepartmentDaoJDBC(DB.getConnection());
		
		System.out.println("==== TEST 1: department insert ====");
		Department dep = new Department(1, "Music");
		departmentDao.insert(dep);
		
		System.out.println("==== TEST 2: department findById ====");
		System.out.println(departmentDao.findById(3));

		System.out.println("==== TEST 3: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department dp : list) {
			System.out.println(dp);
		}
		
		System.out.println("==== TEST 4: department update ====");
		dep = new Department(1,"Laboratorio");
		departmentDao.update(dep);
		
		System.out.println("==== TEST 5: department delete ====");
		departmentDao.deleteById(8);
		
		DB.closeConnection();
	}

}
