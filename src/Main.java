public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String numStr = Integer.toString(num);
        String reversed = "";
        for (int i = numStr.length() - 1; i >= 0; i--) {
            reversed += numStr.charAt(i);
        }
        return reversed;
    }

    // 3. encryptThis
    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        String encrypted = "";

        for (String word : words) {
            char firstChar = word.charAt(0);
            String encryptedWord = (int) firstChar + "";

            if (word.length() > 2) {
                encryptedWord += word.charAt(word.length() - 1);
                encryptedWord += word.substring(2, word.length() - 1);
                encryptedWord += word.charAt(1);
            } else if (word.length() == 2) {
                encryptedWord += word.charAt(1);
            }

            encrypted += encryptedWord + " ";
        }
        return encrypted.trim();
    }

    // 4. decipherThis
    public static String decipherThis(String text) {
        String[] words = text.split(" ");
        String decrypted = "";

        for (String word : words) {
            String number = "";
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                number += word.charAt(i);
                i++;
            }

            char firstChar = (char) Integer.parseInt(number);
            String decryptedWord = firstChar + "";

            if (i < word.length()) {
                int lengthAfterNumber = word.length() - i;
                if (lengthAfterNumber > 2) {
                    decryptedWord += word.charAt(word.length() - 1);
                    decryptedWord += word.substring(i + 1, word.length() - 1);
                    decryptedWord += word.charAt(i);
                } else if (lengthAfterNumber == 2) {
                    decryptedWord += word.charAt(word.length() - 1);
                    decryptedWord += word.charAt(i);
                } else {
                    decryptedWord += word.substring(i);
                }
            }

            decrypted += decryptedWord + " ";
        }
        return decrypted.trim();
    }
}
