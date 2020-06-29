package com.showLee.utils;

import java.util.UUID;

public class RabbitMqUtils  {

    public static String getMessagerId (){
        UUID uuid = UUID.randomUUID();
        return  uuid.toString().replace("-","");
    }

}
