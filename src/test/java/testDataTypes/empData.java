package testDataTypes;

public class empData {

	public Name name;
	public Photo photo;
	public Boolean loginStatus;
	public Login login;
	
	public class Login {

		public String userName;
		public String password;
		public String status;

		}
	
	public class Name {

		public String fname;
		public String mName;
		public String lName;

		}
	
	public class Photo {

		public Boolean status;
		public String path;

		}
	
	
	
}
