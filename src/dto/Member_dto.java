package dto;

public class Member_dto {
	private String no, name, birth, gender, age, tel1, tel2, tel3, city, i_code, i_name, i_age, p_date , p_seno;
	private int total_number;
	
	public Member_dto(String no, String name, String birth, String age, String gender, String tel1, String tel2, String tel3,
			String city) {
		super();
		this.no = no;
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.gender = gender;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.city = city;
	}
	
	
		
	
	public Member_dto(String city, String name, int total_number) {
		super();
		this.city = city;
		this.name = name;
		this.total_number = total_number;
	}





	public Member_dto(String p_seno, String no, String name, String i_code, String i_name, String p_date) {
		super();
		this.p_seno = p_seno;
		this.no = no;
		this.name = name;
		this.i_code = i_code;
		this.i_name = i_name;
		this.p_date = p_date;
		
	}



	public Member_dto(String i_code, String i_name, String i_age) {
		super();
		this.i_code = i_code;
		this.i_name = i_name;
		this.i_age = i_age;
	}





	public String getAge() {
		return age;
	}

	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getGender() {
		return gender;
	}
	public String getTel1() {
		return tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public String getCity() {
		return city;
	}
	public String getI_code() {
		return i_code;
	}
	public String getI_name() {
		return i_name;
	}
	public String getI_age() {
		return i_age;
	}
	public String getP_date() {
		return p_date;
	}
	public int getTotal_number() {
		return total_number;
	}
	public String getP_seno() {
		return p_seno;
	}
	
	
	

}
