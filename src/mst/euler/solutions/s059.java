package mst.euler.solutions;

import mst.euler.Solution;

import java.util.List;

import static mst.euler.Lib.readFile;

public class s059 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s059().run());
    }

    @Override
    public String solve() {

        List<String> fileContent = readFile("src/mst/euler/resources/p059_cipher.txt");
        String encryptedText = "";
        String decryptedText, key;
        int sum=0;
        for (String sign : fileContent.get(0).split(",")) {
            encryptedText += (char) Integer.parseInt(sign);
        }
        for (char s0 = 'a'; s0 <= 'z'; s0++) {
            for (char s1 = 'a'; s1 <= 'z'; s1++) {
                for (char s2 = 'a'; s2 <= 'z'; s2++) {
                    key = "" + s0 + s1 + s2;
                    decryptedText = decrypt(encryptedText, key);
                    if (decryptedText.contains(" the ") && decryptedText.contains(" a ") && decryptedText.contains(" and ")) {
                        System.out.println("KEY:" + key);
                        System.out.println(decryptedText);
                        for(char c : decryptedText.toCharArray())
                        {
                            sum += c;
                        }
                        return String.valueOf(sum);
                    }
                }
            }
        }
        return null;
    }

    private String decrypt(String encryptedText, String key) {
        String text = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            text += (char) (((int)encryptedText.charAt(i)) ^ ((int)key.charAt(i%key.length())));
        }
        return text;
    }
}
