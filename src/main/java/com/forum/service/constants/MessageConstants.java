package com.forum.service.constants;

public class MessageConstants {

    //error messages
    public static final String ERROR_MESSAGE_INTERNAL_ERROR = "Internal error!";
    public static final String ERROR_MESSAGE_DUPLICATE_EMAIL = "This email is already registered in our system!";
    public static final String ERROR_MESSAGE_EMPTY_FIELDS = "Fill all of fields!";
    public static final String ERROR_MESSAGE_INVALID_EMAIL = "Email is invalid!";
    public final static String ERROR_MESSAGE_VALIDATE = "Error validete!";
    public static final String ERROR_MESSAGE_INVALID_PASSWORD = "Password is invalid!";
    public static final String ERROR_MESSAGE_INACTIVE_ACCOUNT = "User is not active! Please check your email to activate account";
    public static final String ERROR_MESSAGE_PASSWORDS_MUST_BE_THE_SAME = "Password and repassword must be the same!";
    public static final String ERROR_MESSAGE_TOPIC_NOT_FOUND = "Topic with given id not found!";
    public static final String ERROR_MESSAGE_USER_NOT_FOUND = "User with given email not found!";

    //success messages
    public static final String SUCCESS_MESSAGE_REGISTRATION = "Registration completed! Please check your email and activate your profile";
    public static final String SUCCESS_MESSAGE_TOPIC_ADDED = "Topic added!";
    public static final String SUCCESS_MESSAGE_COMMENT_ADDED = "Comment added!";

    public static int errorCodeOf(String message) {
        switch (message) {
            case ERROR_MESSAGE_DUPLICATE_EMAIL: //100+ user codes
                return 100;
            case ERROR_MESSAGE_USER_NOT_FOUND:
                return 101;
            case ERROR_MESSAGE_TOPIC_NOT_FOUND: //200+ topic codes
                return 200;
            case ERROR_MESSAGE_INTERNAL_ERROR:
                return 300;
            default:
                return 300;
        }
    }

}