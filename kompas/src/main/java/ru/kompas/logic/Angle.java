package ru.kompas.logic;

public class Angle {

    private String side;
    private int start;
    private int end;

    public Angle(String side,String range) {
        this.side = side;
        String[] betwenAngle = range.split("-");
        this.start = Integer.parseInt(betwenAngle[0]);
        this.end = Integer.parseInt(betwenAngle[1]);
    }

    public String getSide() {
        return side;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
