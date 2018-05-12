package com.andy.data.json.jackson;

import com.andy.data.entity.User;
import com.andy.data.service.DataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

/**
 * @author: Mr.ruoLin
 * @createBy: 2018-05-11 23:17
 **/
public class JacksonSeria {

    private static User user = new User(1033L, "james", "admin", new Date(), "andy@gmail.com", 10000.00, "token");

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        ObjectMapper mapper = new ObjectMapper();

        //String json = mapper.writeValueAsString(user);
        //System.out.println(json);

        //User user = mapper.readValue(json, User.class);
        //System.out.println(user);



        String json = mapper.writeValueAsString(DataService.getUsers());
        List<User> users = mapper.readValue(json, new TypeReference<List<User>>() {});

        long end = System.currentTimeMillis();
        System.out.println("一共用了:" + (end - start) + "豪秒！");
    }

}
