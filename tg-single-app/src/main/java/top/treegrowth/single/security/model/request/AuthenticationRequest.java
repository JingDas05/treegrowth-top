package top.treegrowth.single.security.model.request;


import top.treegrowth.single.security.model.ModelBase;

public class AuthenticationRequest extends ModelBase {

	private static final long serialVersionUID = -7108167204619680190L;
	private String username;
	private String password;

	public AuthenticationRequest() {
		super();
	}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
