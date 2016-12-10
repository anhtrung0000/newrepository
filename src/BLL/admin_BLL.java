package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.MySQLconnection;
import DTO.Product_DTO;

public class admin_BLL {
	MySQLconnection connect =new MySQLconnection();
	ResultSet rst =null;
	ArrayList<Product_DTO> listpro = null;
	Connection conn= null;
	Product_DTO pro = null;
	public PreparedStatement pres = null;
	
	public int select_CategoryId(String Product){
		int id=0;
		conn= connect.getConnectiontoSQL();
		try{
			Statement query = conn.createStatement();
			rst =query.executeQuery("Select ProductCategoryId from tb_ProductCategory Where Product like '%"+Product+"%'");
			while(rst.next() ){
			id= rst.getInt("ProductCategoryId");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	public ResultSet get_listCategory(){
		conn= connect.getConnectiontoSQL();
		try {
			Statement query= conn.createStatement();
			rst= query.executeQuery("Select Product from tb_ProductCategory");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;	
	}
	
	public ArrayList<Product_DTO> getListProduct(){
		listpro = new ArrayList<Product_DTO>();
		conn=connect.getConnectiontoSQL();
		try {
			Statement query = conn.createStatement();
			rst= query.executeQuery("Select * from tb_Product");
			while(rst.next()){
				pro =new Product_DTO();
				pro.setProductName(rst.getString("ProductName"));
				pro.setPrice(rst.getFloat("Price"));
				pro.setColor(rst.getString("Color"));
				pro.setSize(rst.getString("Size"));
				listpro.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listpro;
	}
	
	public void addProduct(Product_DTO product){
		String img=null;
		conn =connect.getConnectiontoSQL();
		try {
			pres =conn.prepareStatement("Insert Into tb_Product(ProductCategoryId,ProductName,Decription,Price,Color,Size,Images)"
					+ " Values (?,?,?,?,?,?,?)");
			img="images/"+product.getImages();
			pres.setInt(1, product.getProductCategoryId());
			pres.setString(2, product.getProductName());
			pres.setString(3, product.getDecription());
			pres.setFloat(4, product.getPrice());
			pres.setString(5, product.getColor());
			pres.setString(6, product.getSize());
			pres.setString(7, img);
			
			pres.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
