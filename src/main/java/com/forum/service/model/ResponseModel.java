package com.forum.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private String status;
    private Object body;

    public void withStatusSuccess() {
        this.status = "Success!";
    }

    public void withStatusError() {
        this.status = "Error!";
    }

}
