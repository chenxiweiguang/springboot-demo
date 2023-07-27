package com.test.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用@Data自动生成需要的get、set
@Data
//使用@AllArgsConstructor自动生成有参构造
@AllArgsConstructor
//使用@NoArgsConstructor自动生成无参构造
@NoArgsConstructor
public class useInfo implements Serializable{
    private static final long serialVersionUID = -1L;  //redis序列化
    private Integer id;
    private String name;
    private String age;
}
