package utn.frba.losjavaleros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending Email...");

        try {
            sendEmailWithAttachment(to, subject, body);
        } catch(MessagingException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Email sent.");
    }

    private void sendEmailWithAttachment(String to, String subject, String body) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(to);

        helper.setSubject(subject);

        // default = text/plain
        // true = text/html
        helper.setText(body, false);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        //helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}
