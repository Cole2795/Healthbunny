/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ayesha Khan
 */
public class ServiceValidator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validInputLogin(String username, String password) {

        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();

    }

    //Validates multiple parameters
    public boolean validateParam(String... params) {

        return params != null && params.length > 0;
    }

    //Validates Single parameters
    public boolean validate(String param) {

        return param != null && !param.isEmpty();
    }
}
