package com.inetum.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
@FieldDefaults(level = AccessLevel.PRIVATE)

@Data
public class ProductDTO {

     long id;

     String name;

     String quantity;

     boolean disponibility;

     Timestamp createdDate;

     Timestamp updatedDate;

}
