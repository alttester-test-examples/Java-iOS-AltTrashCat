package altunity.alttrashcatj;

import ro.altom.altunitytester.AltUnityDriver;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AltUnityDriver driver = new AltUnityDriver("127.0.0.1",13000);
    }
}
