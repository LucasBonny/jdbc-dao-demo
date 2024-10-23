package application;

import java.util.Date;

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
		
		System.out.println("==== TEST 2: seller Insert ====");
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com",new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido com id: " + newSeller.getId());
		
		
	}

}
