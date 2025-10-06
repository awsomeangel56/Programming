import java.util.*;
public class CipherUtils {

  public static String caesarEncrypt(String text, int shift) {
    StringBuilder result=new StringBuilder();
    shift = shift%26;
    for (char c : text.toCharArray()) {
      if (Character.isUpperCase(c)) {
        char ch = (char) ((c - 'A' + shift + 26) % 26 + 'A');
        result.append(ch);
      } else if (Character.isLowerCase(c)) {
        char ch = (char) ((c - 'a' + shift + 26) % 26 + 'a');
        result.append(ch);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
  public static String caesarDecrypt(String text, int shift) {
    return caesarEncrypt(text, -shift);
  }

  public static String substitutionEncrypt(String text, String key) {
    String standard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    text = text.toUpperCase();
    StringBuilder result = new StringBuilder();
    for (char c : text.toCharArray()) {
      if (Character.isLetter(c)){
        int index = standard.indexOf(c);
        result.append(key.charAt(index));
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
  public static String substitutionDecrypt(String text, String key) {
    String standard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    text = text.toUpperCase();
    StringBuilder result = new StringBuilder();
    for (char c : text.toCharArray()) {
      int index = key.indexOf(c);
      result.append(standard.charAt(index));
    }
    return result.toString();
  }

  public static String hillEncrypt(String plaintext, int[][] keyMatrix) {
    plaintext = plaintext.toUpperCase();
    int[] vector = new int[3];
    for (int i = 0; i < 3; i++) {
      vector[i] = plaintext.charAt(i) - 'A';
    }
    int[] result = new int[3];
    for (int i = 0; i < 3; i++) {
      result[i] = 0;
      for (int j = 0; j < 3; j++) {
        result[i] += keyMatrix[i][j] * vector[j];
      }
      result[i] %= 26;
    }
    StringBuilder encrypted = new StringBuilder();
    for (int val : result) {
      encrypted.append((char) (val + 'A'));
    }
    return encrypted.toString();
  }
  public static String hillDecrypt(String ciphertext, int[][] keyMatrix) {
    int det = determinant(keyMatrix);
    int detInv = modInverse(det % 26, 26);
    if (detInv == -1)
      return "Key not invertible. Decryption failed.";
    int[][] adj = adjugate(keyMatrix);
    int[][] inv = new int[3][3];
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++) {
        inv[i][j] = (adj[i][j] * detInv) % 26;
        if (inv[i][j] < 0)
          inv[i][j] += 26;
      }
    ciphertext = ciphertext.toUpperCase();
    int[] vector = new int[3];
    for (int i = 0; i < 3; i++) {
      vector[i] = ciphertext.charAt(i) - 'A';
    }
    int[] result = new int[3];
    for (int i = 0; i < 3; i++) {
      result[i] = 0;
      for (int j = 0; j < 3; j++) {
        result[i] += inv[i][j] * vector[j];
      }
      result[i] %= 26;
    }
    StringBuilder decrypted = new StringBuilder();
    for (int val : result) {
      decrypted.append((char) (val + 'A'));
    }
    return decrypted.toString();
  }
  public static int determinant(int[][] m) {
    return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
        - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
        + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
  }
  public static int modInverse(int a, int m) {
    a = a % m;
    for (int x = 1; x < m; x++) {
      if ((a * x) % m == 1)
        return x;
    }
    return -1;
  }
  public static int[][] adjugate(int[][] m) {
    int[][] adj = new int[3][3];
    adj[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
    adj[0][1] = -(m[1][0] * m[2][2] - m[1][2] * m[2][0]);
    adj[0][2] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    adj[1][0] = -(m[0][1] * m[2][2] - m[0][2] * m[2][1]);
    adj[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]);
    adj[1][2] = -(m[0][0] * m[2][1] - m[0][1] * m[2][0]);
    adj[2][0] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]);
    adj[2][1] = -(m[0][0] * m[1][2] - m[0][2] * m[1][0]);
    adj[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]);
    int[][] transpose = new int[3][3];
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        transpose[i][j] = adj[j][i];
    return transpose;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;
    do {
      System.out.println("\n--- Cipher Menu ---");
      System.out.println("1. Caesar Cipher");
      System.out.println("2. Substitution Cipher");
      System.out.println("3. Hill Cipher (3x3)");
      System.out.println("4. Exit");
      System.out.print("Choose option: ");
      choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          System.out.print("Enter text: ");
          String caesarText = sc.nextLine();
          System.out.print("Enter shift: ");
          int shift = sc.nextInt();
          sc.nextLine();
          String caesarEnc = caesarEncrypt(caesarText, shift);
          String caesarDec = caesarDecrypt(caesarEnc, shift);
          System.out.println("Encrypted: " + caesarEnc);
          System.out.println("Decrypted: " + caesarDec);
          break;
        case 2:
          System.out.print("Enter text: ");
          String subText = sc.nextLine();
          String key = "QWERTYUIOPASDFGHJKLZXCVBNM";
          String subEnc = substitutionEncrypt(subText, key);
          String subDec = substitutionDecrypt(subEnc, key);
          System.out.println("Encrypted: " + subEnc);
          System.out.println("Decrypted: " + subDec);
          break;
        case 3:
          System.out.print("Enter 9-letter key: ");
          String keyStr = sc.nextLine().toUpperCase();
          if (keyStr.length() != 9) {
            System.out.println("Key must be 9 letters.");
            break;
          }
          int[][] matrix = new int[3][3];
          for (int i = 0; i < 9; i++)
            matrix[i / 3][i % 3] = keyStr.charAt(i) - 'A';
          System.out.print("Enter 3-letter plaintext: ");
          String plain = sc.nextLine().toUpperCase();
          if (plain.length() != 3) {
            System.out.println("Plaintext must be 3 letters.");
            break;
          }
          String hillEnc = hillEncrypt(plain, matrix);
          String hillDec = hillDecrypt(hillEnc, matrix);
          System.out.println("Encrypted: " + hillEnc);
          System.out.println("Decrypted: " + hillDec);
          break;
        case 4:
          System.out.println("Exiting.");
          break;
        default:
          System.out.println("Invalid option.");
      }
    } while (choice != 4);
    sc.close();
  }
}