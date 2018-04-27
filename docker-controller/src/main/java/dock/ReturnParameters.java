package dock;

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