package org.peut;

public class Line {

    private Point start;
    private Point end;
    private boolean isHV;
    private boolean isH;
    private boolean isV;

    public Line( Point start, Point end){
        this.start = start;
        this.end   = end;
        this.isHV = true;
        if ( start.getX() != end.getX() && start.getY() != end.getY() ){
            this.isHV = false;
        }else{
            this.isH = false;
            this.isV = false;
            if ( start.getX() == end.getX() ){
                this.isV = true;
            }else{
                this.isH = true;
            }
        }

        if ( this.isHV ) {
            if (start.getX() > end.getX() || start.getY() > end.getY()) {
                Point save = this.start;
                this.start = this.end;
                this.end = save;
            }
        }
    }

    public boolean isOnLine( Point q){
        if ( this.isH &&  q.getY() == this.start.getY() && q.getX() >= this.start.getX()  && q.getX() <= this.end.getX() ) return true;
        if ( this.isV &&  q.getX() == this.start.getX() &&  q.getY() >= this.start.getY() && q.getY() <= this.end.getY() ) return true;

        return false;
    }

    public Point[] getPoints(){

        int size = this.isH ?
                this.end.getX() - this.start.getX() + 1:
                this.end.getY() - this.start.getY() + 1;

        Point[] points = new Point[ size ];


        for ( int i = 0; i < size; ++i ){
            points[i] = new Point( isH? this.start.getX() + i : this.start.getX(),
                                   isH? this.start.getY(): this.start.getY() + i
                                 );
        }

        System.out.printf("--- %s line ---%n", this.isH ? "Horizontal":"Vertical");
        for ( Point p : points){
            p.log();
        }
        System.out.println("---");


        return points;
    }

    public boolean isHV() {
        return isHV;
    }

    public void log(){
        if ( this.isV )  System.out.print( "Vertical");
        if ( this.isH )  System.out.print( "Horizontal");
        System.out.println(" line");
        start.log();
        end.log();
    }

    public void display() {
        String s;

        this.log();

        for (int r = 0; r < 10; ++r) {
            for (int c = 0; c < 10; ++c) {
                Point point = new Point(c,r);
                s = ".";
                if ( this.isOnLine(  point ) ) s = "X";
                System.out.print( s);
            }
            System.out.println();
        }
    }

}
