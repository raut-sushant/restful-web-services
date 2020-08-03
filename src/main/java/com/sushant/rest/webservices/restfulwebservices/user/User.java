package com.sushant.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel (description = "Information about User.")
public class User {

    private Integer id;
    @Size(min = 2, message = "Name should be atleast 2 characters.")
    @ApiModelProperty(notes = "Name should have atleast 2 characters.")
    private String name;

    @Past(message = "Please Enter past date as birthdate.")
    @ApiModelProperty(notes = "Birth date should be in past.")
    private Date birthDate;

    protected User ( ) {

    }

    public User (Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getBirthDate ( ) {
        return birthDate;
    }

    public void setBirthDate (Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString ( ) {
        return super.toString();
    }
}
