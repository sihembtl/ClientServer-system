

package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;




public class Client {
    


    
    public static void main(String[] args) throws UnknownHostException, IOException {
      InetAddress adr =  InetAddress.getLocalHost();
              System.out.println(adr.getHostAddress());            
              System.out.println(  adr.getHostName());
      Socket socketclient = new Socket (adr, 80) ;
      TestThread c = new TestThread("client_entree",socketclient);
      testTread_sortie c2 = new testTread_sortie(" client_sortie",socketclient);
      c.run();
      c2.run();
        
      
        
    }
    
}
