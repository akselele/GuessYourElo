package domain.model;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String username;
    private String email;
    private String hashedPassword;

    public Person(String username, String email, String password ) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        setUsername(username);
        setEmail(email);
        setHashedPassword(password);
    }

    public Person() {

    }

    public void setUsername(String userid) {
        if(userid.isEmpty()){
            throw new IllegalArgumentException("No username given");
        }
        this.username = userid;
    }

    public String getUsername() {
        return username;
    }


    public void setEmail(String email) {
        if(email.isEmpty()){
            throw new IllegalArgumentException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    public void setHashedPassword(String password)throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(password.isEmpty()){
            throw new IllegalArgumentException("No password given");
        }
        MessageDigest crypt = MessageDigest.getInstance("SHA-512");
        crypt.reset();

        crypt.update(password.getBytes("UTF-8"));
        hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

}
