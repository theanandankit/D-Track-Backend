package com.atlan.SMSService.Controller.Impl;

import com.atlan.SMSService.Controller.UserSendMessage;
import com.atlan.SMSService.Service.UserService;
import com.atlan.SMSService.Utils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
        Message message = Message.creator(new PhoneNumber(userService.getUserContact(integer)), new PhoneNumber("+17024795696"), "Hello Ankit Your Response has been recorded with our Atlan Backend test Application. Thank you").create();
    }
}
