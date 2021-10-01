package bceao.common.validation.token.connector.internal;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeycloakClientFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakClientFacade.class);

	private String nomRealm;

	private String urlServeur;

	private String clientId;

	private String clientSecret;

	private String username;

	private String password;

	public KeycloakClientFacade( String urlServeur, String nomRealm, String clientId, String clientSecret) {
		this.nomRealm = nomRealm;
		this.urlServeur = urlServeur;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public String getAccessToken(String username, String password) {
		return getAccessTokenString(newKeycloakBuilderWithPasswordCredentials(username, password).build());
	}

	private String getAccessTokenString(Keycloak keycloak) {
		AccessTokenResponse tokenResponse = getAccessTokenResponse(keycloak);
		return tokenResponse == null ? null : tokenResponse.getToken();
	}

	private AccessTokenResponse getAccessTokenResponse(Keycloak keycloak) {
		try {
			return keycloak.tokenManager().getAccessToken();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la récupération d'un token", e);
			return null;
		}
	}

	private KeycloakBuilder newKeycloakBuilderWithPasswordCredentials(String username, String password) {
		return KeycloakBuilder.builder().realm(nomRealm).serverUrl(urlServeur).clientId(clientId)
				.clientSecret(clientSecret).username(username).password(password).grantType(OAuth2Constants.PASSWORD);
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
