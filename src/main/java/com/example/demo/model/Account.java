package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * account
 * @author 
 */
@Data
public class Account implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}