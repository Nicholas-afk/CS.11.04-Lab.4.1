public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int balance = 0;
        for (char c : str.toCharArray()) {
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
        return new StringBuilder().append(num).reverse().toString();
    }

    // 3. encryptThis
    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        StringBuilder encrypted = new StringBuilder();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char firstChar = word.charAt(0);
            sb.append((int) firstChar);

            if (word.length() > 2) {
                sb.append(word.charAt(word.length() - 1));
                sb.append(word.substring(2, word.length() - 1));
                sb.append(word.charAt(1));
            } else if (word.length() == 2) {
                sb.append(word.charAt(1));
            }

            encrypted.append(sb).append(" ");
        }
        return encrypted.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String text) {
        String[] words = text.split(" ");
        StringBuilder decrypted = new StringBuilder();

        for (String word : words) {
            StringBuilder number = new StringBuilder();
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                number.append(word.charAt(i));
                i++;
            }

            char firstChar = (char) Integer.parseInt(number.toString());
            StringBuilder sb = new StringBuilder().append(firstChar);

            if (i < word.length()) {
                int lengthAfterNumber = word.length() - i;
                if (lengthAfterNumber > 2) {
                    sb.append(word.charAt(word.length() - 1));
                    sb.append(word.substring(i + 1, word.length() - 1));
                    sb.append(word.charAt(i));
                } else if (lengthAfterNumber == 2) {
                    sb.append(word.charAt(word.length() - 1));
                    sb.append(word.charAt(i));
                } else {
                    sb.append(word.substring(i));
                }
            }

            decrypted.append(sb).append(" ");
        }
        return decrypted.toString().trim();
    }
}
