package com.forum.service.model;

import com.forum.service.constants.MessageConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorWrapper {

    private Integer code;
    private String message;

    public ErrorWrapper(String message) {
        this.message = message;
        this.code = MessageConstants.errorCodeOf(message);
    }

}
