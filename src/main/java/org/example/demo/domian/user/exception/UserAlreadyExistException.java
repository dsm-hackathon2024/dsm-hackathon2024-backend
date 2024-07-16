package org.example.demo.domian.user.exception;

import org.example.demo.global.error.CustomException;
import org.example.demo.global.error.ErrorCode;

public class UserAlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new UserAlreadyExistException();
    private UserAlreadyExistException() {
        super(ErrorCode.USER_EXIST);
    }

}
