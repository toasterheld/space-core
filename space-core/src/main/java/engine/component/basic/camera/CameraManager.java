package engine.component.basic.camera;

/**
 * Manages the active camera in the game engine.
 * This class provides functionality to get and set the active camera, which controls the view of the world.
 */
public class CameraManager {

    // The currently active camera
    private static Camera activeCamera;

    /**
     * Returns the currently active camera.
     *
     * @return the active camera
     */
    public static Camera getActiveCamera() {
        return activeCamera;
    }

    /**
     * Sets the specified camera as the active camera.
     *
     * @param activeCamera the camera to set as active
     */
    public static void setActiveCamera(Camera activeCamera) {
        CameraManager.activeCamera = activeCamera;
    }
}
