package dock;

import com.google.common.collect.ImmutableMap;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.PortBinding;

import java.net.ServerSocket;
import java.util.Arrays;

public class DockerController {


    DockerController(){}

    public ReturnParameters startContainer(String username){
        //username is related to KLETech Cloud Platform

        try {
            final DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");
            String imgName="php";
            ServerSocket s = new ServerSocket(0);
            int freeHostPort=s.getLocalPort();
            System.out.println("Available host port: "+freeHostPort);
            s.close();
            final HostConfig hostConfig =
                    HostConfig.builder()
                            .appendBinds(HostConfig.Bind.from("/var/www/html/KLETechCloudIDE/user_files/"+username+"/")
                                    .to("/var/www/html")
                                    .readOnly(false)
                                    .build())
                            .portBindings( ImmutableMap.of( "80/tcp", Arrays.asList( PortBinding.of( "", freeHostPort ) ) ) )
                            .build();

            final ContainerConfig containerConfig = ContainerConfig.builder()
                    .hostConfig(hostConfig)
                    .image( imgName )
                    .exposedPorts( "80/tcp" )
                    .build();


            final ContainerCreation creation = docker.createContainer(containerConfig);
            final String id = creation.id();
            System.out.println("Container created");
            // Start container

            docker.startContainer(id);
            System.out.println("Container started");

            System.out.println("Available at: http://localhost:"+freeHostPort+"/raw_IDE");

            String url="http://localhost:"+freeHostPort+"/raw_IDE";
            ReturnParameters returnParameters=new ReturnParameters(url,id);
            return returnParameters;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
