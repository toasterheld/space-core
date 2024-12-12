package engine.util;

/**
 * The Time class is responsible for managing and providing time-related functionality,
 * including delta time, frames per second (FPS), and the elapsed time since the start of the game.
 * It is used to track the passage of time in the game loop.
 */
public class Time {
    // Constant representing the target frames per second (FPS) for the game loop
    private static final double FPS = 60.0;

    // Time variables to track various time-related values
    private static double startTime;
    private static double deltaTime;
    private static double lastTime;
    private static double currentTime;

    /**
     * Updates the delta time, which is the time elapsed between the current and the previous frame.
     * This method should be called on each update to maintain accurate delta time calculations.
     */
    public static void updateDeltaTime() {
        // Get the current time in seconds (converted from nanoseconds)
        currentTime = System.nanoTime() / 1000000000.0;

        // Calculate delta time as the difference between current and last time
        deltaTime = currentTime - lastTime;

        // Update the last time for the next frame
        lastTime = currentTime;
    }

    /**
     * Initializes the time system by setting the start time and the last time.
     * This method should be called once at the beginning of the game or game loop.
     */
    public static void init() {
        // Set the start time based on the system's current time in seconds
        startTime = System.nanoTime() / 1000000000.0;

        // Initialize the last time to the start time
        lastTime = startTime;
    }

    /**
     * Returns the delta time, which is the time elapsed between the previous and current frame.
     *
     * @return The delta time in seconds
     */
    public static double getDeltaTime() {
        return deltaTime;
    }

    /**
     * Returns the target frames per second (FPS) for the game loop.
     * This value is constant and set to 60 FPS.
     *
     * @return The target FPS
     */
    public static double getFPS() {
        return FPS;
    }

    /**
     * Returns the total elapsed time since the game started.
     * This value is the difference between the current time and the start time.
     *
     * @return The total elapsed time in seconds
     */
    public static double getPassedTime() {
        return currentTime - startTime;
    }
}
