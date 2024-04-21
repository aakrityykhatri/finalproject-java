package courseManagementSystem;


public class Encrypt {
	
	public static String getEncryptedValue(String value, int secret_key) {
	    String encrypt = "";

	    for (int i = 0; i < value.length(); i++) {
	        char ch = value.charAt(i);
	        ch += secret_key;
	        encrypt = encrypt + ch;
	    }

	    return encrypt; 
	}

	public static String getDecryptedValue(String encryptedValue, int secret_key) {
	    String decrypt = "";

	    for (int i = 0; i < encryptedValue.length(); i++) {
	        char ch = encryptedValue.charAt(i);
	        ch -= secret_key;
	        decrypt = decrypt + ch;
	    }

	    return decrypt;
	}


	public static void main(String[] args) {
			
		
	}

}
