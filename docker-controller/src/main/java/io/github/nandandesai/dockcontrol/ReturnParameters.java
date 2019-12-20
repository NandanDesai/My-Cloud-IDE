package io.github.nandandesai.dockcontrol;

public class ReturnParameters {
    String url;
    String containerID;

    ReturnParameters(String url, String containerID){
        this.url=url;
        this.containerID=containerID;
    }

    public String getUrl() {
        return url;
    }
    public String getContainerID(){
        return containerID;
    }
}