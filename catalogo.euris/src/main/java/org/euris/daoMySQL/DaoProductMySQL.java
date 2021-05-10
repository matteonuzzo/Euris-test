package org.euris.daoMySQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.euris.model.Product;
import org.euris.util.BasicDao;
import org.euris.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoProductMySQL extends BasicDao implements IDaoProduct{

	public DaoProductMySQL(
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Product> products() {
		List<Product> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM products");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Product.class, map));
		}
		return ris;
	}

	@Override
	public Product product(int id) {
		return IMappablePro.fromMap(Product.class, getOne("SELECT * FROM products WHERE id = ?", id));
	}

	@Override
	public void add(Product product) {
		execute("INSERT INTO products (nameProduct, price) VALUES (?, ?)", product.getNameProduct(), 
																			product.getPrice());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM products WHERE id = ?", id);
	}

	@Override
	public void edit(Product product) {
		execute("UPDATE products SET nameProduct = ?, price = ? WHERE id = ?", product.getNameProduct(), 
																				product.getPrice(), 
																				product.getId());
	}

	@Override
	public String operation(String operation) {
	   
	    int plusIndex = operation.indexOf("+");
	    int minusIndex = operation.indexOf("-");
	    int moltiplyIndex = operation.indexOf("*");
	    int divisionIndex = operation.indexOf("/");
	        
	    if(plusIndex != -1) {
	        String op1 = operation.substring(0, plusIndex);
	        String op2 = operation.substring(plusIndex+1, operation.length());
	        operation = sum(op1,op2);
	            
	    } else if (minusIndex != -1) {
	     	String op1 = operation.substring(0, minusIndex);
	     	String op2 = operation.substring(minusIndex+1, operation.length());
	       	operation = subtraction(op1,op2);
	        	
	    } else if (moltiplyIndex != -1) {
	        String op1 = operation.substring(0, moltiplyIndex);
	        String op2 = operation.substring(moltiplyIndex+1, operation.length());
	        operation = moltiplication(op1,op2);
	            
	    } else if (divisionIndex != -1) {
	        String op1 = operation.substring(0, divisionIndex);
	        String op2 = operation.substring(divisionIndex+1, operation.length());
	        operation = division(op1,op2);
	    }
	    
	    return operation;

	}

	    private String sum(String v1, String v2){
	        String[] values1 = v1.split(" ");
	        String[] values2 = v2.split(" ");
	        
	        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
	        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
	        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

	        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
	        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
	        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

	        int pence = (p1*240) + (s1*20) + d1;
	        int pence2 = (p2*240) + (s2*20) + d2;
	        
	        int sum = pence + pence2;
	        
	        int ptot = sum / 240;
	        sum = sum % 240;
	        int stot = sum / 12;
	        sum = sum % 12;
	        int dtot = sum;

	        String total = ptot + "p " + stot +"s " + dtot +"d";
	        return total;
	    }
	    
	    private String subtraction (String v1, String v2) {
	        String[] values1 = v1.split(" ");
	        String[] values2 = v2.split(" ");
	        
	        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
	        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
	        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

	        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
	        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
	        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

	        int pence = (p1*240) + (s1*20) + d1;
	        int pence2 = (p2*240) + (s2*20) + d2;
	        
	        int sub = pence - pence2;
	        
	        int ptot = sub / 240;
	        sub = sub % 240;
	        int stot = sub / 12;
	        sub = sub % 12;
	        int dtot = sub;
	        
	        String total = ptot + "p " + stot +"s " + dtot +"d";
	        return total;
	    }
	    
	    private String moltiplication (String v1, String v2) {
	        String[] values1 = v1.split(" ");
	        String[] values2 = v2.split(" ");
	        
	        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
	        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
	        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

	        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
	        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
	        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

	        int pence = (p1*240) + (s1*20) + d1;
	        int pence2 = (p2*240) + (s2*20) + d2;
	        
	        int molty = pence * pence2;
	        
	        int ptot = molty / 240;
	        molty = molty % 240;
	        int stot = molty / 12;
	        molty = molty % 12;
	        int dtot = molty;
	        
	        String total = ptot + "p " + stot +"s " + dtot +"d";
	        return total;
	    }
	    
	    private String division (String v1, String v2) {
	        String[] values1 = v1.split(" ");
	        String[] values2 = v2.split(" ");
	        
	        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
	        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
	        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

	        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
	        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
	        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

	        int pence = (p1*240) + (s1*20) + d1;
	        int pence2 = (p2*240) + (s2*20) + d2;
	        
	        int division = pence / pence2;
	        
	        int ptot = division / 240;
	        division = division % 240;
	        int stot = division / 12;
	        division = division % 12;
	        int dtot = division / 1;
	        division = division %1;
	        
	        String total = ptot + "p " + stot +"s " + dtot +"d";
	        return total;
	        
	    }
	    	
	    
	}
