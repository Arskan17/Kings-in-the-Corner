
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

// A client sends messages to the server, the server spawns a thread to communicate with the client.
// Each communication with a client is added to an array list so any message sent gets sent to every other client
// by looping through it.

public class Client {

    public static ArrayList rooms = new ArrayList();

    public static void main(String[] args){
        rooms.add("404");
        rooms.add("dsf");
        rooms.add("sdcvxx");
        rooms.add("2302");

        addElem("91");

        System.out.println(rooms);

        String[] raum = {"91", "oiweo", "asd"};
        System.out.println(raum[0]);
        System.out.println(raum[1]);
        System.out.println(raum[2]);


        System.out.println(rooms.get(2));
    }

    public static void addElem(String newRoom){
        rooms.add(newRoom);
    }



}
