package com.atlan.SMSService.Controller.Impl;

import com.atlan.SMSService.Controller.UserSendMessage;
import com.atlan.SMSService.Service.UserService;
import com.atlan.SMSService.Utils;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSendMessageImpl implements UserSendMessage {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/userSendMessage")
    public void sendSMS(@RequestParam("user")Integer integer, @RequestParam("body") String value) {

        Twilio.init(Utils.TWILIO_SID, Utils.TWILIO_AUTH);

        System.out.println(integer);
        System.out.println(value);

        System.out.println("aaa");
       //Message message = Message.creator(new PhoneNumber("+919024923695"), new PhoneNumber("+17024795696"), "Hello Ankit Your Response has been recorded with our Atlan Backend test Application. Thank you").create();

        //System.out.println(message.getStatus());
        //System.out.println(message.getBody());
    }
}
