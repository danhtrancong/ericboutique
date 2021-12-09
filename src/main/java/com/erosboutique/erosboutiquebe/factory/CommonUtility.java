package com.erosboutique.erosboutiquebe.factory;

import com.erosboutique.erosboutiquebe.dto.Problem;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CommonUtility {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    Method thứ 2 là public BCryptPasswordEncoder passwordEncoder()
//    Method này dùng để mã hoá password của người dùng
//    Ví dụ người dùng nhập password là abc@123 thì nó sẽ mã hoá là $2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu.
//    Mọi người có thể đọc cách encode và thư viện encode ở file EncrytedPasswordUtils trong github .

    public Function<String, Problem> createProblem = errorMessage -> {
        Problem problem = new Problem();
        problem.setDetail(errorMessage);
        problem.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        problem.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return problem;

    };
}
