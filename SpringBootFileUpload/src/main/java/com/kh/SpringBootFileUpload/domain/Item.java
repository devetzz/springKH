package com.kh.SpringBootFileUpload.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;    
    private int id; 
    private String name;
    private int price;
    private String description;
    // <input type="file" />
    private MultipartFile picture;
    private String pictureUrl;
}
