
import java.util.Scanner;


class UserAccount {
    private String username;
    private String password;

    
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter 
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


class SecurityValidator {

    
    public boolean isValid(UserAccount user) {
        String password = user.getPassword();

        
        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUppercase = false;

        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
        }

        
        return hasDigit && hasUppercase;
    }
}


public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Password Complexity Validator ---");
        System.out.print("Username: ");
        String uname = scanner.nextLine();

        System.out.print("Password: ");
        String pword = scanner.nextLine();

        // Create UserAccount object
        UserAccount user = new UserAccount(uname, pword);

        // Pass the object to the SecurityValidator
        SecurityValidator validator = new SecurityValidator();

        if (validator.isValid(user)) {
            System.out.println("Password is VALID"); 
        } else {
            System.out.println("Password is INVALID"); 
        }

        scanner.close();
    }
}