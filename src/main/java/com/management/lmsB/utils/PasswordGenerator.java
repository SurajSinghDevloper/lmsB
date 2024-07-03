package com.management.lmsB.utils;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	
	   // Character sets for password generation
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    // Password length
    private static final int PASSWORD_LENGTH = 10;

    // Secure random number generator
    private static final SecureRandom RANDOM = new SecureRandom();

    // Set to keep track of generated passwords to ensure uniqueness
    private static final Set<String> GENERATED_PASSWORDS = new HashSet<>();

    /**
     * Generates a unique 10-character password containing upper and lower case
     * alphabetic characters, numeric characters, and special characters.
     *
     * @return a unique password string
     */
    public static String generateUniquePassword() {
        StringBuilder password;
        do {
            password = new StringBuilder(PASSWORD_LENGTH);

            // Ensure at least one character from each character set is included
            password.append(UPPERCASE.charAt(RANDOM.nextInt(UPPERCASE.length())));
            password.append(LOWERCASE.charAt(RANDOM.nextInt(LOWERCASE.length())));
            password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
            password.append(SPECIAL_CHARACTERS.charAt(RANDOM.nextInt(SPECIAL_CHARACTERS.length())));

            // Fill the rest of the password length with random characters from all sets
            for (int i = 4; i < PASSWORD_LENGTH; i++) {
                password.append(ALL_CHARACTERS.charAt(RANDOM.nextInt(ALL_CHARACTERS.length())));
            }

            // Shuffle the characters in the password to ensure randomness
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int randomIndex = RANDOM.nextInt(PASSWORD_LENGTH);
                char temp = password.charAt(randomIndex);
                password.setCharAt(randomIndex, password.charAt(i));
                password.setCharAt(i, temp);
            }
        } while (!GENERATED_PASSWORDS.add(password.toString())); // Ensure password uniqueness

        return password.toString();
    }
}
