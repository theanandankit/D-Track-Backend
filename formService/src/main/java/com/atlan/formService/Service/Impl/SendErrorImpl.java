package com.atlan.formService.Service.Impl;

import com.atlan.formService.APICalls.RestAsyncTask;
import com.atlan.formService.Models.DTO.ErrorDTO.ErrorDTORequest;
import com.atlan.formService.Service.SendError;
import okhttp3.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class SendErrorImpl implements SendError {

    @Override
    public void SendError(ErrorDTORequest errorDTO) {

        RequestBody requestBody = new FormBody.Builder()
                .add("message", errorDTO.getMessage())
                .add("className", errorDTO.getClassName())
                .add("instancePort", String.valueOf(8088))
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8097/sendError")
                .post(requestBody)
                .build();

        RestAsyncTask.sendError().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("eee");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println("sucess");

            }
        });

    }
}
