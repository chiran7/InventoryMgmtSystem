package inventorymgmtsystem.admin.model;

public class Admin {
	
private String usernameAdmin;
private String passwordAdmin;


public String getUsernameAdmin() {
	return usernameAdmin;
}
public void setUsernameAdmin(String usernameAdmin) {
	this.usernameAdmin = usernameAdmin;
}
public String getPasswordAdmin() {
	return passwordAdmin;
}
public void setPasswordAdmin(String passwordAdmin) {
	this.passwordAdmin = passwordAdmin;
}
@Override
public String toString() {
	return "Admin [usernameAdmin=" + usernameAdmin + ", passwordAdmin=" + passwordAdmin + "]";
}




}
