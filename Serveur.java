

package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




public class Serveur {
    
    public static void main(String[] args) throws IOException {
        ServerSocket serveur = new ServerSocket(80);
        Socket socketservice = serveur.accept();
        
        TestThread_serveur s = new  TestThread_serveur("serveur_entree",socketservice);
       TestThread_serveur_sortie s2 =  new TestThread_serveur_sortie("serveur_sortie",socketservice);
       s2.run();
       s.run();
        
    }
    
}
