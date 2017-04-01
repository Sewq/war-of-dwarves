package pl.sewq.core.security;

import org.mindrot.jbcrypt.BCrypt;

public class CredencialsService {

	private static final String CRYPT_PREFIX = "$2a$";
	private static int WORKLOAD = 12;

	public static String hashPassword(final String password) {
		final String salt = BCrypt.gensalt(WORKLOAD);
		final String hashedPassword = BCrypt.hashpw(password, salt);
		return hashedPassword;
	}

	public static boolean checkPassword(final String password,
	        final String storedPassword) {

		if ((storedPassword == null) || !storedPassword.startsWith(CRYPT_PREFIX)) {
			throw new IllegalArgumentException("Bad hash");
		}
		return BCrypt.checkpw(password, storedPassword);
	}
}
