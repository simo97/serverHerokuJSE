/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveurjse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SIMO
 */
public class ServeurJSE {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //ServerSocket serverSocket = null;
Socket socket = null;
DataInputStream dataInputStream = null;
DataOutputStream dataOutputStream = null;

ServerSocket serverSocket = new ServerSocket(8888);
        while(true){

            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String chaineRecue = dataInputStream.readUTF();
            StringBuffer chaineRetournee = (new StringBuffer(chaineRecue)).reverse();
            dataOutputStream.writeUTF(chaineRetournee.toString());
        }
    }
}
