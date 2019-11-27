package ru.cs.spring.boot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cs.spring.boot.demo.forms.AuthUserForm;
import ru.cs.spring.boot.demo.models.User;
import ru.cs.spring.boot.demo.models.UserRole;
import ru.cs.spring.boot.demo.models.UserState;
import ru.cs.spring.boot.demo.repositories.UsersRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender sender;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void signUpUser(AuthUserForm form) {

        String confirmLink = UUID.randomUUID().toString();
        String mailText = "<a href='http://localhost:8080/confirm/" + confirmLink + "'>Ссылка</a>";

        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(UserRole.USER)
                .state(UserState.NOT_CONFIRMED)
                .confirmLink(confirmLink)
                .build();
        usersRepository.save(user);

        executorService.submit(() -> {
            MimeMessage message = sender.createMimeMessage();
            try {
                message.setContent(mailText, "text/html");
                MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
                messageHelper.setTo(user.getEmail());
                messageHelper.setSubject("Подтерждение регистрации");
                messageHelper.setText(mailText, true);
                messageHelper.setFrom("noreplyabacustest@gmail.com");
            } catch (MessagingException e) {
                throw new IllegalArgumentException(e);
            }

            sender.send(message);
        });

    }
}
