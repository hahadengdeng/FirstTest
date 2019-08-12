package Instrument;

public class Regexcheck {
    public static boolean email(String email) {
        return email.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
    }

    public static boolean phone(String phone){
        return phone.matches("^[1][0-9]{10}$");
    }
}
