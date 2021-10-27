package com.inetum.dto;

import lombok.Data;

@Data
public class UserDTO {

    private long id;

    private String username;

    private String password;

    private String status;

    private int statusCode;

}
