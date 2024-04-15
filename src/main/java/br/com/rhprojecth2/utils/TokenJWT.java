package br.com.rhprojecth2.utils;

import io.jsonwebtoken.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TokenJWT {

    private static Key jwtKey;

    public TokenJWT(Key jwtKey) {
        TokenJWT.jwtKey = jwtKey;
    }

    private static Key generateKey() {
        String keyString = "YzBhZTgwZWM2ZTI5Njk1YzQ3YWIxYzg0ZTk5NjkxZjQ4YzIwZGRkMGVlZWU4NTFiMjhjZDg5NzU5NTFjODQ3ZQ==";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HmacSHA256");
        return key;
    }

    public static Date setExpirationDate(long timeInMinutes) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(timeInMinutes);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String processTokenJWT(String user) {
        Key jwtKey = generateKey();
        TokenJWT token = new TokenJWT(jwtKey);
        Date expirationDate = setExpirationDate(42000L);
        return token.generateToken(user, expirationDate);
    }

    public static boolean validateToken(String token) {
        jwtKey = generateKey();
        boolean validToken = false;
        if (token != null) {
            try {
                Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token);
                validToken = true;
            } catch (ExpiredJwtException e) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Expired token!");
            } catch (MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid token!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid token!");
        }
        return validToken;
    }

    public String generateToken(String userName, Date expirationDate) {
        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setSubject(userName)
                .setIssuer("com")
                .setIssuedAt(new Date())
                .claim("password","sdlkjsdoijonpvf65v4e6fv5e6ver")
                .setExpiration(expirationDate)
                .signWith(jwtKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String recoverySubjectFromToken (String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }

    public String recoveryIssuerFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token);
        return claimsJws.getBody().getIssuer();
    }

    public String recoveryClaimFromToken(String token, String claim) {
        String subject = "";
        if (token != null && !token.equals("")) {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token);
            subject = claimsJws.getBody().get(claim).toString();
        }
        return subject;
    }

}
