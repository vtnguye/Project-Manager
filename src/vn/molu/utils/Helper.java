package vn.molu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Helper {

	public static String bcrypt(String plaintext) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plaintext);
	}

}
