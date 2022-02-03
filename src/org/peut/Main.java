package org.peut;

import java.util.ArrayList;
import java.util.Arrays;

//https://adventofcode.com/2021/day/5

public class Main {

    public static void main(String[] args) {

        int[]  coordinates= {
                0,9,5,9,
                8,0,0,8,
                9,4,3,4,
                2,2,2,1,
                7,0,7,4,
                6,4,2,0,
                0,9,2,9,
                3,4,1,4,
                0,0,8,8,
                5,5,8,2
        };

        ArrayList<Line> hvLines = new ArrayList<>();

        for( int i=0; i < coordinates.length; i += 4){
            Point s = new Point( coordinates[i], coordinates[i+1]);
            Point e = new Point( coordinates[i+2], coordinates[i+3]);

            Line l = new Line( s,e);
            if ( l.isHV() ) {
                l.log();
                hvLines.add(l);
            }
        }

        System.out.printf("Found %d horizontal or vertical lines %n", hvLines.size() );

        ArrayList<Point> foundPoints = new ArrayList<>();

        int totalPoints = 0;
        int hotPoints = 0;

        for( Line l : hvLines ){
            Point[] listPoints = l.getPoints();
            totalPoints += listPoints.length;

            foundPoints.addAll(Arrays.asList(listPoints));
        }

        foundPoints.sort( (a,b) -> { if ( a.equalPos(b)) return 0;
                                     if ( a.getX() < b.getX() ) return(-1) ;
                                     if ( a.getX() ==  b.getX() && a.getY() < b.getY() ) return(-1) ;

                                     return(1);}
                                    );

        System.out.println("foundPoints sorted");
        for ( Point p : foundPoints){
            p.log();
        }

        for ( int i = 0; i < foundPoints.size(); ++i   ){
            int j = i;
            for ( ;j < foundPoints.size() -2  && foundPoints.get(j).equalPos( foundPoints.get(j+1) ) ; ++j);
            if ( j - i > 0 )hotPoints++;
        }
        System.out.println( "found points " + foundPoints.size());
        System.out.printf("Found %d total points %d hotpoints %n", totalPoints, hotPoints);


    }
}
