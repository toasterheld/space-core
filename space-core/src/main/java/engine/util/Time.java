package engine.util;

public class Time {
    private static final double FPS = 60.0;

    private static double startTime;

    private static double deltaTime;
    private static double lastTime;
    private static double currentTime;

    public static void updateDeltaTime() {
        currentTime = System.nanoTime() / 1000000000.0;
        deltaTime = currentTime - lastTime;
        lastTime = currentTime;
    }

    public static void init() {
        startTime = System.nanoTime() / 1000000000.0;
        lastTime = startTime;
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static double getFPS() {
        return FPS;
    }

    public static double getPassedTime() {
        return currentTime-startTime;
    }
}
