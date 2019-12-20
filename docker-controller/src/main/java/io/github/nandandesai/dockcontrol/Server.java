package io.github.nandandesai.dockcontrol;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.util.Map;


public class Server extends NanoHTTPD {

    private static String managementModuleBasePath="/var/www/html/My-Cloud-IDE";

    public Server(int port) throws IOException {
        super(port);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nDocker controller is running at http://localhost:"+port);
    }

    public static void main(String[] args) {
        int port=8080;

        for(String arg:args){
            String[] tokens=arg.split("=");
            if(tokens[0].startsWith("--port")){
                port=Integer.parseInt(tokens[1]);
            }else if(tokens[0].startsWith("--management-base-path")){
                managementModuleBasePath=tokens[1];
            }
        }
        System.out.println("Port selected: "+port);
        System.out.println("Management-Base-Path: "+managementModuleBasePath);
        try {
            new Server(port);
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {

        Map<String, String> parms = session.getParms();
        if (parms.get("username") != null) {
            DockerController dockerController=new DockerController(managementModuleBasePath);
            ReturnParameters returnParameters=dockerController.startContainer(parms.get("username"));
            return newFixedLengthResponse(returnParameters.getUrl());
        }else{
            return newFixedLengthResponse("Error");
        }

    }
}
