package com.Chat;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;


public class ChatController {

    @FXML ListView<String> ShowChatMessages;
    public void newChatMessage(String username, String chatMessage) {
        ShowChatMessages.getItems().add(username + ":  " + chatMessage);
    }

    @FXML TextField ChatTextField;
    @FXML
    protected void onSendChatMessageButtonClick() {
        String sendInputText = ChatTextField.getText().toString();
        ChatTextField.clear();
        newChatMessage("me:  ", sendInputText);
        //TODO send chatmessage to server
    }
}