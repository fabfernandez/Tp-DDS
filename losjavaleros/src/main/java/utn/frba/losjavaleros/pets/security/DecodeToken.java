package utn.frba.losjavaleros.pets.security;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class DecodeToken {

    public static Integer location = 0;

    public static Integer extractPayload(String prefix, String header, String secret, HttpServletRequest request) {
        String jwtToken = request.getHeader(header).replace(prefix, "");
        Claims claims = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwtToken).getBody();
        location = Integer.parseInt(claims.get("authorities").toString().replace("[", "").replace("]", ""));
        return location;
    }
}