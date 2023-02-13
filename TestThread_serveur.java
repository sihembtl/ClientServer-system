package serveur;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/*creation de la classe du thread de l'ecoute pour le serveur*/
public class TestThread_serveur {
    Socket obj;//creation d'un objet socket service
    private BufferedReader fluxEntreeSocket;
    
public TestThread_serveur(String name,Socket obj){
   
    this.obj = obj;

}
static char[] alphabet1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
// fonction de decryptage
public static String dechiffrement(int n, String sIn)  {
        
         char[] charSIn = sIn.toCharArray();
         char[] charSOut = new char[charSIn.length];   
         int pos1, pos2;      
         for(int i = 0; i < charSIn.length; i++) {
            pos1 = posChar(charSIn[i], alphabet1);    
            pos2 = newPos(pos1, -n);    
            if(pos2 == -1) charSOut[i] = ' '; // si -1, c'est que ce n'est pas une lettre, on met un espace à la place    
            else charSOut[i] = alphabet1[pos2];   
        }   
        return new String(charSOut); // on fait un string avec le tableau de char  
    }   
private static int posChar(char c, char[] tab)  {
       for(int i = 0; i < tab.length; i++)   { 
           if(tab[i] == c) return i;
       }   return -1; 
    }  
private static int newPos(int pos,int n)  {
        int pos2 = pos;
        if(pos <= -1) { // -1 signifie que le caractere n'a pas été trouvé dans l'alphabet (caractere spécial, chiffre, espace, etc.)
            pos2 = -1;   
        } else {
            int i = 0;
            while(i < abs(n)) {
                if(n < 0) {
                    if(pos2 - 1 == -1) pos2 = 25;
                    else pos2--;
                } else {
                    if(pos2 + 1 > 25) pos2 = 0;
                    else pos2++;
                }
                i++;
            }
        }
        return pos2;
    }
public static int abs(int a)  {
        if(a >= 0) return a;
        else return -a;
    }

/*la fonction run pour executerle thread_serveur et lire le message du client*/ 
public void run(){
    try {
        for(int i = 0; i < 10; i++)
        
        fluxEntreeSocket = new BufferedReader(new InputStreamReader(obj.getInputStream()));
        
        String msg_recu= fluxEntreeSocket.readLine();
        System.out.println(msg_recu);/* on affiche le message chifré */
        msg_recu = dechiffrement(3,msg_recu);
        System.out.println(msg_recu);/* on affiche le message en clair  */
               

    } catch (Exception e) {
    }


}

    
}
