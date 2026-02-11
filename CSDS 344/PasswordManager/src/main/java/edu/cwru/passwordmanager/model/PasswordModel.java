package edu.cwru.passwordmanager.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PasswordModel {
    private ObservableList<Password> passwords = FXCollections.observableArrayList();

    // !!! DO NOT CHANGE - VERY IMPORTANT FOR GRADING !!!
    static private File passwordFile = new File("passwords.txt");

    static private String separator = "\t";

    static private String passwordFilePassword = "";
    static private byte [] passwordFileKey;
    static private byte [] passwordFileSalt;

    /// You can set this to whatever you like to verify that the password the user entered is correct
    private static String verifyString = "peperomiahope";

    private void loadPasswords() {
        // Replace with loading passwords from file, you will want to add them to the passwords list defined above
        // Tips: Use buffered reader, make sure you split on separator, make sure you decrypt password
        if (!passwordFile.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(passwordFile))) {
            reader.readLine(); // skip first line otherwise it makes a new passcode :/

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(separator);
                String label = parts[0];
                String decrypted = decryptPassword(parts[1], passwordFileKey);

                passwords.add(new Password(label, decrypted));
            }
        } catch (Exception e) {
            //failure
            e.printStackTrace();
        }
    }

    public PasswordModel() {
        loadPasswords();
    }

    static public boolean passwordFileExists() {
        return passwordFile.exists();
    }

    static public void initializePasswordFile(String password) throws IOException {
        passwordFile.createNewFile();
        // Use password to create token and save in file with salt (TIP: Save these just like you would save password)
        passwordFileSalt = generateSalt();
        passwordFileKey = generateKey(password, passwordFileSalt);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(passwordFile))) {
            String saltEncoded = Base64.getEncoder().encodeToString(passwordFileSalt);
            String encryptedVerify = encryptPassword(verifyString, passwordFileKey);

            writer.write(saltEncoded + separator + encryptedVerify);
            writer.newLine();
        } catch (Exception e) {
            //failure
            throw new IOException(e);
        }
    }

    static public boolean verifyPassword(String password) {
        passwordFilePassword = password; // DO NOT CHANGE

        //Location of the file path 
        System.out.println("Password file path: " + passwordFile.getAbsolutePath());

        // Check first line and use salt to verify that you can decrypt the token using the password from the user
        // TIP !!! If you get an exception trying to decrypt, that also means they have the wrong passcode, return false!
        try (BufferedReader reader = new BufferedReader(new FileReader(passwordFile))) {
            String firstLine = reader.readLine();
            String[] parts = firstLine.split(separator);

            passwordFileSalt = Base64.getDecoder().decode(parts[0]);
            passwordFileKey = generateKey(password, passwordFileSalt);

            String decrypted = decryptPassword(parts[1], passwordFileKey);
            return verifyString.equals(decrypted);

        } catch (Exception e) {
            return false;
        }
    }

    public ObservableList<Password> getPasswords() {
        return passwords;
    }

    public void deletePassword(int index) {
        passwords.remove(index);

        // Remove it from file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(passwordFile))) {

            // rewrite salt + token
            writer.write(
                Base64.getEncoder().encodeToString(passwordFileSalt)
                + separator
                + encryptPassword(verifyString, passwordFileKey));
            writer.newLine();

            for (int i = 0; i < passwords.size(); i++) {
                Password p = passwords.get(i);
                String encrypted = encryptPassword(p.getPassword(), passwordFileKey);
                writer.write(p.getLabel() + separator + encrypted);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(Password password, int index) {
        passwords.set(index, password);

        // Update the file with the new password information
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(passwordFile))) {
            String saltLine =
                    Base64.getEncoder().encodeToString(passwordFileSalt)
                            + separator
                            + encryptPassword(verifyString, passwordFileKey);

            writer.write(saltLine);
            writer.newLine();

            for (Password p : passwords) {
                String encrypted = encryptPassword(p.getPassword(), passwordFileKey);
                writer.write(p.getLabel() + separator + encrypted);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPassword(Password password) {
        passwords.add(password);

        // Add the new password to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(passwordFile, true))) {
            String encrypted = encryptPassword(password.getPassword(), passwordFileKey);
            writer.write(password.getLabel() + separator + encrypted);
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tip: Break down each piece into individual methods, for example: generateSalt(), encryptPassword, generateKey(), saveFile, etc ...
    private static byte [] generateSalt() { 
        // 32 byte salt for high security
        byte[] salt = new byte[32];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private static byte[] generateKey(String password, byte [] salt) {
        try {
            // 512 algorithm PBKDF2
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 100000, 256);
            SecretKey secret_key = factory.generateSecret(spec);
            return secret_key.getEncoded();

        } catch (Exception e) {
            // fail!
            throw new RuntimeException(e);
        }
    }

    private static String encryptPassword(String plaintext, byte[] key) throws Exception {
        // Using AES as the cipher 
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


    private static String decryptPassword(String ciphertext, byte[] key) throws Exception {
        // Using AES as the cipher pt 2
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        return new String(cipher.doFinal(decoded));
    }
    // Use these functions above, and it will make it easier! Once you know encryption, decryption, etc works, you just need to tie them in
}
