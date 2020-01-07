package dev.louiiuol.etin.controllers.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import dev.louiiuol.etin.models.CustomUserDetails;

public class CustomTokenEnhancer implements TokenEnhancer {

    final static String USER_ID_KEY = "userId";

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> additionalInfo = new HashMap<>();
		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
		additionalInfo.put(USER_ID_KEY, user.getId());
		additionalInfo.put("role", user.getAuthorities());
		( (DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
