package DATN.example.demo.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class EmailOtpService {
    JavaMailSender javaMailSender;

    public void sentOtpEmail(String toEmail,String otp){
//        try{
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(toEmail);
//            message.setSubject("Vui lòng xác thực tài khoản của bạn, mã OTP có hiệu lực 1 phút");
//            message.setText("Mã OTP của bạn là: " + otp);
//            javaMailSender.send(message);
//        }
//        catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("1. Chuẩn bị gửi mail");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Vui lòng xác thực tài khoản");
        message.setText("OTP: " + otp);

        System.out.println("2. Trước send()");
        javaMailSender.send(message);
        System.out.println("3. Sau send()");
    }
}
