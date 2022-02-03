package org.peut;

public class Point {
    private int x;
    private int y;

    private int hits;

    public Point( int x, int y){
        this.x = x;
        this.y = y;
        this.hits = 0;
    }

    public int increaseHits(){
        this.hits++;
        return this.hits;
    }

    public void log(){
        System.out.printf( "x: %d, y: %d %n", this.x, this.y);
    }

    public boolean equalPos( Point b){
        if ( this.x == b.x && this.y == b.y ) return true;
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
