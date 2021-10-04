package com.inetum.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategoryDTO {

     long id;

     String name;

     Timestamp createdDate;

     Timestamp updatedDate;

}
