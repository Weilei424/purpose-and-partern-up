package com.masonwang.pnp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

/**
 * Password rules:
 * 1. Must contain last least one uppercase English letter;
 * 2. Must contain last least one lowercase English letter;
 * 3. Must contain last least one number;
 * 4. Must contain last least one symbol from "~`!@#$%^&*()-_+={}[]|;:"<>,./?";
 * 5. Length must not shorter than 8 characters, must not longer than 20 characters;
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final List<Character> numbers = Arrays.asList(
            '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'
    );

    private static final List<Character> uppercase = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
            );

    private static final List<Character> lowercase = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
    );

    private static final List<Character> symbols = Arrays.asList(
            '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+',
            '=', '{', '}', '[', ']', '|', ';', ':', '"', '<', '>', ',', '.', '/', '?'
    );

    private static final int minLength = 8;
    private static final int maxLength = 20;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        if (value.length() < minLength || value.length() > maxLength) return false;

        boolean upperFlag = false;
        boolean lowerFlag = false;
        boolean numbersFlag = false;
        boolean symbolFlag = false;

        for (char c : value.toCharArray()) {
            if (uppercase.contains(c)) upperFlag = true;
            if (lowercase.contains(c)) lowerFlag = true;
            if (numbers.contains(c)) numbersFlag = true;
            if (symbols.contains(c)) symbolFlag = true;
        }

        return upperFlag && lowerFlag && numbersFlag && symbolFlag;
    }

}
