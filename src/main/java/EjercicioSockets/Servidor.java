/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dayan
 */

public class Servidor{
    
    public static void main (String[] args){

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
        final int PUERTO = 5000;
        
        try {
            servidor = new ServerSocket(PUERTO);
            
            System.out.println("Servidor iniciado");
            
            while(true){
                sc = servidor.accept();
                
                System.out.println("Cliente conectado");
                //Se usa para la comunicion "Puente"
                in = new DataInputStream(sc.getInputStream()); //Recibir los mensajes del cliente
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("Hola mundo desde el servidor");
                
                sc.close();
                System.out.println("Cliente desconectado");
                
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
