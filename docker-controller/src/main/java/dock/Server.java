package dock;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;


public class Server extends NanoHTTPD {

    public Server() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning at http://localhost:8080/ \n");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {

        Map<String, String> parms = session.getParms();
        if (parms.get("username") != null) {
            DockerController dockerController=new DockerController();
            ReturnParameters returnParameters=dockerController.startContainer(parms.get("username"));
            return newFixedLengthResponse(returnParameters.getUrl());
        }else{
            return newFixedLengthResponse("Error");
        }

    }
}
