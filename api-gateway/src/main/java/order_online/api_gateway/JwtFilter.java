//package order_online.api_gateway;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final String SECRET = "SECRET"; //TO DO - REMOVER EM PROD
//
//    private final List<String> openEndpoints = List.of(
//            "/api/v1/user/login",
//            "api/v1/user"
//    );
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String path = request.getRequestURI();
//
//        if (openEndpoints.contains(path)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        try {
//            String token = authHeader.replace("Bearer ", "");
//            Algorithm algorithm = Algorithm.HMAC256(SECRET);
//            DecodedJWT decodedToken = JWT.require(algorithm).withIssuer("ORDER-ONLINE-MS-SERVICE").build().verify(token);
//
//            request.setAttribute("userEmail", decodedToken.getSubject());
//            filterChain.doFilter(request, response);
//
//        } catch (Exception e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//}
