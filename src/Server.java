import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        while(true) {
            ServerSocket S = new ServerSocket(2000);
            Socket ss = S.accept();

            BufferedReader brpg = new BufferedReader(new FileReader("index.html"));
            PrintWriter bw = new PrintWriter(new OutputStreamWriter(ss.getOutputStream()), true);

            bw.println("HTTP/1.0 200 OK");

            String l;
            while ((l = brpg.readLine()) != null) {
                bw.println(l);
            }

            System.out.println("Pagina inviata");
            ss.close();
            S.close();
        }
    }
}