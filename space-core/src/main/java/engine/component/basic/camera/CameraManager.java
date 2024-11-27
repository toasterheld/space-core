package engine.component.basic.camera;

public class CameraManager {
    private static Camera activeCamera;


    public static Camera getActiveCamera() {
        return activeCamera;
    }

    public static void setActiveCamera(Camera activeCamera) {
        CameraManager.activeCamera = activeCamera;
    }
}
