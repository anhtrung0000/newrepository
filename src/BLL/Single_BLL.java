package BLL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.MySQLconnection;
import DTO.ProductIMG_DTO;
import DTO.Product_DTO;

public class Single_BLL {
	MySQLconnection connect = new MySQLconnection();
	Connection conn = null;
	ResultSet rs = null;
	ProductIMG_DTO detailproduct = null;

	public ArrayList<ProductIMG_DTO> LayDuLieu(int productId) {
		ArrayList<ProductIMG_DTO> list = new ArrayList<ProductIMG_DTO>();
		conn = connect.getConnectiontoSQL();
		try {
			Statement query = conn.createStatement();
			rs = query
					.executeQuery("Select * from tb_DetailProduct where ProductId= "
							+ productId);
			while (rs.next()) {
				detailproduct = new ProductIMG_DTO();
				detailproduct.setImages(rs.getString("Images"));
				list.add(detailproduct);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Product_DTO getinfo (int productId){
		Product_DTO product = new Product_DTO();
		conn=connect.getConnectiontoSQL();
		try{
			Statement query =conn.createStatement();
			rs= query.executeQuery("Select * from tb_Product WHERE ProductId="+ productId);
			while (rs.next()) {
				product.setPrice(Float.parseFloat(rs.getString("Price")) );
				product.setDecription(rs.getString("Decription"));
				product.setProductName(rs.getString("ProductName"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}
	
	public static void main(String args[]){
		Single_BLL single= new Single_BLL();
		Product_DTO infor= single.getinfo(2);
		System.out.println(infor.getPrice());
	}
}
