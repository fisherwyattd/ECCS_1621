import java.util.Arrays;

public class Workspace {
    public static boolean passwordVerifier(String str) {
        boolean isLongEnough = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        if(str.length() >= 8) { isLongEnough = true; }

        for(int i = 0; i < str.length(); i ++) {
            if(Character.isUpperCase(str.charAt(i))) { hasUpperCase = true; }
            else if(Character.isLowerCase(str.charAt(i))) { hasLowerCase = true; }
            else if(Character.isDigit(str.charAt(i))) { hasDigit = true; }
        }

        return isLongEnough && hasUpperCase && hasLowerCase && hasDigit;
    }


    public static void main(String[] args) {
        String strExample = "isThisgood3nough";
        System.out.println(passwordVerifier(strExample));
    }
}
