package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.Member_dto;

public class Member_dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//지역별접종현황
	public ArrayList<Member_dto> getAreaList() {
		ArrayList<Member_dto> dtos = new ArrayList<Member_dto>();	
		
		String query = "select p_city, name, total_number from covid_area_오인환";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String p_city = rs.getString(1);
				String name = rs.getString(2);
				int total_number = rs.getInt(3);
				
				Member_dto dto = new Member_dto(p_city, name, total_number);
				
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getVaccineList() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		
		return dtos;
	}
	
	//지역별 접종건수
	public int getAreaNumber(String city) {
		int num = 0;
		String query = "select count(*) from\r\n" + 
				"(select DISTINCT a.p_city, a.i_code from\r\n" + 
				"(select a.p_city, b.i_code\r\n" + 
				"from covid_cust_오인환 a, covid_order_오인환 b\r\n" + 
				"where a.p_no = b.p_no)a, covid_area_오인환 b)\r\n" + 
				"where p_city= '"+city+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getVaccineNumber() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		return num;
	}
	
	
	//백신별접종현황 
	public ArrayList<Member_dto> getVaccineList(){
		ArrayList<Member_dto> dtos = new ArrayList<Member_dto>();	
		
		String query = "select i_code, i_name, i_age from covid_injection_오인환";
		
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String i_code = rs.getString(1);
				String i_name = rs.getString(2);
				String i_age = rs.getString(3);
				
				Member_dto dto = new Member_dto(i_code, i_name, i_age);
				
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getVaccineList() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}
	//백신별접종건수
		public int getVaccineNumber(String i_code) {
		int num = 0;
		String query = "select count(i_code) from covid_order_오인환\r\n" + 
				"where i_code='"+i_code+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getVaccineNumber() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		return num;
	}
	
	
	//접종자현황 조회;
	public ArrayList<Member_dto> getShotList() {
		ArrayList<Member_dto> dtos = new ArrayList<Member_dto>();
		String query = "select concat(concat(SUBSTR(p_seno, 0, 4), '-'), SUBSTR(p_seno, 5)) as p_seno, \r\n" + 
				"a.p_no, a.p_name, a.i_code, c.i_name, \r\n" + 
				"to_char(a.p_date, 'yyyy-MM-dd') as p_date\r\n" + 
				"from\r\n" + 
				"(select b.p_seno, a.p_no, a.p_name, b.i_code, b.p_date\r\n" + 
				"from covid_cust_오인환 a, covid_order_오인환 b\r\n" + 
				"where a.p_no = b.p_no) a, covid_injection_오인환 c\r\n" + 
				"where a.i_code=c.i_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String p_seno = rs.getString(1);
				String no = rs.getString(2);
				String name = rs.getString(3);
				String i_code = rs.getString(4);
				String i_name = rs.getString(5);
				String p_date = rs.getString(6);
				
				Member_dto dto = new Member_dto(p_seno, no, name, i_code, i_name, p_date);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getShotList() ERROR please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//접종대상자 조회;
	public ArrayList<Member_dto> getMemberList(){
		ArrayList<Member_dto> dtos = new ArrayList<Member_dto>();
		String query="select a.p_no, a.p_name, \r\n" + 
				"to_char(to_date(a.p_birth, 'yyyy-MM-dd'),'YYYY\"년\"MM\"월\"DD\"일\"') as birth,\r\n" + 
				"(2022-to_number(replace(a.p_birth,'0301',null))) as age,\r\n" + 
				"decode(a.p_gender, 'M','남','여')as gender,\r\n" + 
				"a.p_tel1, a.p_tel2, a.p_tel3, c.name as city\r\n" + 
				"from covid_cust_오인환 a, covid_area_오인환 c\r\n" + 
				"where a.p_city = c.p_city";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString(2);
				String birth = rs.getString(3);
				String age = Integer.toString(rs.getInt(4));
				String gender = rs.getString(5);
				String tel1 = rs.getString(6);
				String tel2 = rs.getString(7);
				String tel3 = rs.getString(8);
				String city = rs.getString(9);
				
				Member_dto dto = new Member_dto(no, name, birth, age, gender, tel1, tel2, tel3, city);
				dtos.add(dto);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getMemberList() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	//예방접종등록
	
	public int addInjection(int bun, String no, String inject, String date) {
		int result = 0;
		String query = "insert into covid_order_오인환 \r\n" + 
				"values("+bun+",'"+no+"','"+inject+"','"+date+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ddInjection() ERROR Please check your query : " + query);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

}
