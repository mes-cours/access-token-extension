package bceao.common.validation.token.connector.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class AccessTokenOperations {
	
	@MediaType(value = ANY, strict = false)
	@Alias("GetToken")
	@Summary(value = "Chercher un token depuis Keycloak")
	public String getToken(@Config AccessTokenConfiguration configuration) {
		
		String resultToken = null;
		
		KeycloakClientFacade facade = new KeycloakClientFacade(configuration.getUrlServeur(), configuration.getNomRealm(), configuration.getClientId(), configuration.getClientSecret());
		
		resultToken = "Bearer "+ facade.getAccessToken(configuration.getUsername(), configuration.getPassword());
		
		return resultToken;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * KeycloakClientFacade facade = new
	 * KeycloakClientFacade("http://localhost:8380/auth", "MULE",
	 * "composant-agent-service", "eef1ee62-ac72-4be1-bfa5-0be3772f071d");
	 * 
	 * String token = facade.getAccessToken("khalifa", "passer");
	 * System.out.println(token); }
	 */

}

