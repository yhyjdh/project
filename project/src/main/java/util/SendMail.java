package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
		
	// 매개변수 : 발신자, 수신자, 제목, 내용
	public static void sendMail(String from, String to, String subject, String content) {
		// 1. 메일서버 정보 설정 (property 객체로)
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); // No approriate protocol 에러
		
		// 2. 인증을 위해 Session 객체 생성
		//Authenticator a = new Authenticator(); // 추상클래스 수정안됨 상속받아서 처리 해야하는데 여기만 상용 재정의 
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("yhyjdh","sjf64000"); 
			}		
		});
		session.setDebug(true);
		
		// 3. MimeMessage 객체 생성(발신자, 수신자, 제목, 내용 설정)
		try { // 에러 예외발생 출력
			MimeMessage mm = new MimeMessage(session); // 생성자에 session 객체 넣어
			mm.setFrom(new InternetAddress(from));// 발신자 //변환 고정되면 문자로 고정
			mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 수신자
			mm.setSubject(subject); // 제목
			//mm.setText(content); // 내용 (text)
			mm.setContent(content, "text/html; charset=utf-8"); // 내용 (html)
			
			// 4. 메일 발송
			Transport.send(mm);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// test 출력
	public static void main(String[] args) {
		//sendMail("yhyjdh@naver.com", "y9183@nate.com", "test", "test");  // text	
		//sendMail("yhyjdh@naver.com", "y9183@nate.com", "test", "<b>한글</b>test"); // html
		//임시비밀번호 영문2 숫자2
		String temp = "";
		for(int i = 0; i<2; i++) {
			temp += (char)(Math.random()*26+65);
		}
		for(int i = 0; i<2; i++) {
			temp += (int)(Math.random()*9);
		}
		System.out.println(temp);
	}
}
