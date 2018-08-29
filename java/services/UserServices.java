/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Business.User;
import DAO.UserDao;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayesha Khan
 */
public class UserServices {

    /**
     * Author Ayesha
     *
     * @return byte[] of salt generated using the SecureRandom function with
     * SHA-1 instance
     * @throws NoSuchAlgorithmException Requested crypto algorithm not
     * available, the exception is thrown
     */
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Generate a 16 byte (128 bit) salt
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;

    }

    /**
     * Author Ayesha
     *
     * @param passwordString user entered String
     * @param salt salt generated using SecureRandom Function - call
     * generateSalt() to get salt
     * @return return the byte array of secret key generated - Returns the key
     * in its primary encoding format
     * @throws NoSuchAlgorithmException Requested crypto algorithm not
     * available, the exception is thrown
     * @throws InvalidKeySpecException Invalid Key Specification
     */
    public byte[] getEncryptedPassword(String passwordString, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String algorithm = "PBKDF2WithHmacSHA512";
        // SHA-512 generates 256 bit hashes, so that's what makes sense here
        int derivedKeyLength = 256;
        // Pick an iteration. Usually iteration over 1000
        int iterations = 20000;
        KeySpec spec = new PBEKeySpec(passwordString.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm); //create a key factory of PBKDF2
        return keyFactory.generateSecret(spec).getEncoded();
    }

    public boolean register(String enteredUserName, String enteredPassword, String firstName, String lastName) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ServiceValidator serviceValidator = new ServiceValidator();

        if (serviceValidator.validateParam(enteredUserName, enteredPassword, firstName, lastName)) {
            if (serviceValidator.validateEmail(enteredUserName) == true) {
                User user = new User(); // just repeat same thing here 
                user.setEmail(enteredUserName);
                //user.setIsAdmin(false);
                user.setFirstName(firstName);
                user.setLastName(lastName);

                byte[] salt = generateSalt();
                user.setPassword(Base64.encode(getEncryptedPassword(enteredPassword, salt)));
                user.setPasswordSalt(Base64.encode(salt));
                UserDao userDao = new UserDao();
                return userDao.addUser(user);
            }else{
                return false;
            }

        } else {
            return false;
        }
    }

    public User login(String enteredUserName, String enteredPassword) throws IOException { // this is login method using validator
        /*  For Testing Only
        System.out.println("In Login UserCommand Execute");
        System.out.println("User " + enteredUserName + "Pass " + enteredPassword);
            System.out.println("Valid user name Etc");*/
        try {
            //Use the UserAssist class to login...
            ServiceValidator serviceValidator = new ServiceValidator();
            if (serviceValidator.validInputLogin(enteredUserName, enteredPassword)) {

                if (serviceValidator.validateEmail(enteredUserName)) {
                    UserDao userDao = new UserDao("healthybunny");
                    User logingUser = userDao.getUserbyUserName(enteredUserName);
                    if (logingUser != null) {
                        byte[] storedPasswordSalt = Base64.decode(logingUser.getPasswordSalt());
                        if (storedPasswordSalt != null) {
                            byte[] encryptedEnteredPassword = getEncryptedPassword(enteredPassword, storedPasswordSalt);
                            //Encrypt the user entered password with the salt stored in database
                            byte[] storedPassword = Base64.decode(logingUser.getPassword());
                            if (Arrays.equals(storedPassword, encryptedEnteredPassword)) {
                                //Log the current user logged in into a file and the time logged in
                                return logingUser;
                            } else {
                                return null;
                            }
                        } else {
                            return null;
                        }
                    }

                } else {
                    return null;
                }

            } else {
                return null;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | Base64DecodingException ex) {
//            Log4JLog test = new Log4JLog();
//            test.WriteLogOfLogin(ex);
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    
}
