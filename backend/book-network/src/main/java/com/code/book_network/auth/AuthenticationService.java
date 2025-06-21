package com.code.book_network.auth;

import com.code.book_network.email.EmailService;
import com.code.book_network.email.EmailTemplateName;
import com.code.book_network.role.Role;
import com.code.book_network.role.RoleRepository;
import com.code.book_network.user.Token;
import com.code.book_network.user.TokenRepository;
import com.code.book_network.user.User;
import com.code.book_network.user.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

import static com.code.book_network.email.EmailTemplateName.ACTIVATE_ACCOUNT;

@Service
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    @Value("${application.mailing.frontend.activation-url}")
    private String activactionUrl;

    public AuthenticationService(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, TokenRepository tokenRepository, EmailService emailService) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    public void register(RegistrationRequest request) throws MessagingException {
        Role role = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalArgumentException("ROLE USER was not initialized"));

        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAccountLocked(false);
        user.setEnabled(false);
        user.setRoles(List.of(role));

        userRepository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generatedAndSaveActivationToken(user);

        emailService.sendEmail(user.getEmail(), user.fullName(), ACTIVATE_ACCOUNT, activactionUrl, newToken, "Account activation");
    }

    private String generatedAndSaveActivationToken(User user) {
        String generatedToken = generatedActivationCode(6);
        var token = new Token();
        token.setToken(generatedToken);
        token.setCreatedAt(LocalDateTime.now());
        token.setExpiresAt(LocalDateTime.now().plusMinutes(15));
        token.setUser(user);

        tokenRepository.save(token);
        return generatedToken;
    }

    private String generatedActivationCode(int length) {
        String characters = "123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randonIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randonIndex));
        }

        return codeBuilder.toString();
    }
}
