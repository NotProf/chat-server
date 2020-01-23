package com.chat.chat.Models;


import java.util.Date;

public class OutputModel {
    private String outMessage;

    public String getOutMessage() {
        return outMessage;
    }

    public void setOutMessage(String outMessage) {
        this.outMessage = outMessage;
    }

    public OutputModel(InputModel inputModel) {

        this.outMessage = new Date(System.currentTimeMillis()) + inputModel.getMessage();
    }
}
