package com.company;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SqClient {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        try(Socket socket = new Socket("MacBook-Air-Yurii.local", 1025)){
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("Введите сообщение: ");
            outputStream.writeUTF(in.nextLine());
            outputStream.flush();

            System.out.println("Клиент получил ответ от сервера: "+ inputStream.readUTF());
            inputStream.close();
            outputStream.close();
        }
    }
}
