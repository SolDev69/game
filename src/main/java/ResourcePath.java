public class ResourcePath {
    private String path;
    ResourcePath(String arg) {
        path = "src/main/resources/" + arg;
    }


    String getPath() {
        return path;
    }

    ResourcePath png() {
        path += ".png";
        return this;
    }
}
