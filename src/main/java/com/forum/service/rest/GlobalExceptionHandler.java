package com.forum.service.rest;

import com.forum.service.constants.MessageConstants;
import com.forum.service.exceptions.CustomException;
import com.forum.service.model.ErrorWrapper;
import com.forum.service.model.ResponseModel;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        ErrorWrapper errorWrapper;

        if (!(e instanceof CustomException)){
            e.printStackTrace();
            errorWrapper = new ErrorWrapper(MessageConstants.ERROR_MESSAGE_INTERNAL_ERROR);
        }else{
            errorWrapper = new ErrorWrapper(e.getMessage());
        }

        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusError();
        responseModel.setBody(errorWrapper);
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(responseModel)
                .build();
    }
}
