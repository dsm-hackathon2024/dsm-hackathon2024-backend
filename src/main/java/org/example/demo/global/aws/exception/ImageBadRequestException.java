package org.example.demo.global.aws.exception;

import org.example.demo.domian.user.exception.PasswordMismatchException;
import org.example.demo.global.error.CustomException;
import org.example.demo.global.error.ErrorCode;

public class ImageBadRequestException extends CustomException {
    public static final CustomException EXCEPTION = new ImageBadRequestException();

    private ImageBadRequestException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
