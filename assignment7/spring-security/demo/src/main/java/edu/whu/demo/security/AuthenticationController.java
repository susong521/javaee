package edu.whu.demo.security;

import edu.whu.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import edu.whu.demo.security.DbUserDetailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("authenticate")
public class AuthenticationController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private DbUserDetailService userDetailsService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getId());
        //System.out.println(userDetails);
        if (passwordEncoder.matches(user.getPassword(),userDetails.getPassword())) {
            final String token = jwtTokenUtil.generateToken(userDetails);
            //System.out.println(token);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().body("用户认证未通过");
        }
    }
}