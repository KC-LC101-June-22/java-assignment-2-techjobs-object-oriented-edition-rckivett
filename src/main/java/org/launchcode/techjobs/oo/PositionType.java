package org.launchcode.techjobs.oo;

public class PositionType extends JobField{


    public PositionType(String value) {
        super(value);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType positionType = (PositionType) o;
        return getId() == positionType.getId();
    }
}