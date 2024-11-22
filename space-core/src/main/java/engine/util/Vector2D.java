package engine.util;

import java.util.Random;

public class Vector2D {

    private double x;
    private double y;


    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }


    public static Vector2D randomVector(double mag) {
        Random rand = new Random();

        // Generate a random angle
        double theta = 2.0 * Math.PI * rand.nextDouble();

        // Convert polar coordinates to Cartesian coordinates
        return new Vector2D(Math.cos(theta)*mag, Math.sin(theta)*mag);
    }


    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2D sub(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2D mult(double n) {
        this.x *= n;
        this.y *= n;
        return this;
    }

    public double dot(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    public Vector2D div(double n) {
        this.x /= n;
        this.y /= n;
        return this;
    }


    public Vector2D reverse() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vector2D normalize() {
        double m = getMag();
        if (m != 0) {
            div(m);
        }
        return this;
    }

    public Vector2D limit(double max) {
        if (getMag() > max) {
            normalize();
            mult(max);
        }
        return this;
    }

    public Vector2D rotate(double angle) {
        double x = this.x * Math.cos(angle) - this.y * Math.sin(angle);
        double y = this.x * Math.sin(angle) + this.y * Math.cos(angle);
        this.x = x;
        this.y = y;
        return this;
    }


    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
        return this;
    }

    public Vector2D setX(double x) {
        this.x = x;
        return this;
    }

    public Vector2D setY(double y) {
        this.y = y;
        return this;
    }

    public Vector2D setMag(double len) {
        normalize();
        mult(len);
        return this;
    }

    public Vector2D setHeading(double angle) {
        double len = getMag();
        x = Math.cos(angle) * len;
        y = Math.sin(angle) * len;
        return this;
    }


    public Vector2D copy() {
        return new Vector2D(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMag() {
        return Math.sqrt(x * x + y * y);
    }

    public double getHeading() {
        return Math.atan2(y, x);
    }
}
