package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Department department = new Department(2,null);
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("==== TEST 2: seller findByDepartment ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("==== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for(Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com",new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido com id: " + newSeller.getId());
		
		System.out.println("==== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Matha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		

		System.out.println("==== TEST 6: seller delete ====");
		sellerDao.deleteById(17);
		sellerDao.deleteById(18);
	}

}
