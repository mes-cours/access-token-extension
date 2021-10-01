package bceao.common.validation.token.connector.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;

@Operations(AccessTokenOperations.class)
public class AccessTokenConfiguration {

	@Parameter
	private String nomRealm;
	
	@Parameter
	private String urlServeur;
	
	@Parameter
	private String clientId;

	@Parameter
	private String clientSecret;

	@Parameter
	private String username;
	
	@Parameter
	private String password;

	public AccessTokenConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccessTokenConfiguration(String nomRealm, String urlServeur, String clientId, String clientSecret,
			String username, String password) {
		super();
		this.nomRealm = nomRealm;
		this.urlServeur = urlServeur;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.username = username;
		this.password = password;
	}

	public String getNomRealm() {
		return nomRealm;
	}

	public void setNomRealm(String nomRealm) {
		this.nomRealm = nomRealm;
	}

	public String getUrlServeur() {
		return urlServeur;
	}

	public void setUrlServeur(String urlServeur) {
		this.urlServeur = urlServeur;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
