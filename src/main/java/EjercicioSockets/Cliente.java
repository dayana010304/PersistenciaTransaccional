/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dayan
 */

public class Cliente {
    public static void main (String[] args){
    
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            Socket sc = new Socket (HOST, PUERTO);
            
            in = new DataInputStream(sc.getInputStream()); //Recibir los mensajes del cliente
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Hola mundo desde el cliente");
            
            String mensaje = in.readUTF();
            
            System.out.println(mensaje);
            
            sc.close();
            
                 
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
