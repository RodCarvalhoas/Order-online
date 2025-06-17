package order_online.api_gateway;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtFilter implements WebFilter {

    @Value("${jwt.secret}")
    private String SECRET;

    private final List<String> openEndpoints = List.of(
            "/user-service/api/v1/user/login",
            "/user-service/api/v1/user"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();

        if (openEndpoints.contains(path)) {
            return chain.filter(exchange);
        }

        List<String> authHeaders = request.getHeaders().getOrEmpty("Authorization");
        if (authHeaders.isEmpty() || !authHeaders.get(0).startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        try {
            String token = authHeaders.get(0).replace("Bearer ", "");
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            DecodedJWT decodedToken = JWT.require(algorithm)
                    .withIssuer("ORDER-ONLINE-MS-SERVICE")
                    .build()
                    .verify(token);

            return chain.filter(exchange);
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }
}
