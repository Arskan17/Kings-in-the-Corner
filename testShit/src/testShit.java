import java.util.Scanner;

public class testShit {


    static String username = "test";

    public static void newChatMessage(String username, String chatMessage) {
        System.out.println(username + ":  " + chatMessage);
    }


    public static void onSendChatMessageButtonClick(String textToSend) {
        String sendInputText = textToSend;
            newChatMessage(username, sendInputText);
            receiveChatMessage(sendInputText);
    }

    public static void receiveChatMessage(String messageFromClient){
        String receiveInputText = messageFromClient;
        newChatMessage("Server", receiveInputText);
    }

    public static void main(String[] args){
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Text: ");
            String text = scan.nextLine();

            if(!text.equalsIgnoreCase("exit")){
                onSendChatMessageButtonClick(text);
            } else {
                break;
            }
        }
    }

}
