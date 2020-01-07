package dev.louiiuol.etin.controllers.auth;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/** <p> Provides convenient methods to deal with the currently authenticated user. </p> */
public final class SecurityHelper {

    private SecurityHelper() { }

    /** <p> Returns the currently authenticated user identifier. </p>
     * @return the authenticated user identifier */
    @SuppressWarnings("unchecked")
    public static Long getUserId() {
        Authentication auth = getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
        Map<String, Object> decodedDetails = (Map<String, Object>) details.getDecodedDetails();
        Integer value = (Integer) decodedDetails.get(CustomTokenEnhancer.USER_ID_KEY);
        return value.longValue();
    }

    /** <p> Returns the currently authenticated user username. </p>
     * @return the authenticated user username */
    public static String getUsername() {  return getPrincipal(); }

    /** <p> Returns the currently authenticated user username. </p>
     * @return the authenticated user username */
    public static String getPrincipal() { return (String) getAuthentication().getPrincipal(); }

    /** <p> Returns the {@code Authentication} object associated to the currently authenticated principal, or an authentication request token. </p>
     * @return the Authentication or {@code null} if no authenticationinformation is available */
    public static Authentication getAuthentication() { return SecurityContextHolder.getContext().getAuthentication(); }

}