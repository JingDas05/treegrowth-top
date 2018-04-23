package top.treegrowth.single.security.model.response;


import top.treegrowth.single.security.model.ModelBase;

public class AuthenticationResponse extends ModelBase {

	private static final long serialVersionUID = 3571932225923755758L;
	private String token;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
