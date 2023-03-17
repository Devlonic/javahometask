package task1.paralelograms;

public class Rhombus extends Parallelogram {

    enum RhombusState implements ShapeState {
        WRONG_ANGLE("ANGLE sum must be in range (0; 180)");

        private final String description;

        RhombusState(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name(), this.description);
        }
    }


    public Rhombus(double side, double angleDegreeAlpha) {
        super(side, side, angleDegreeAlpha, 180 - angleDegreeAlpha);

        throwOnInvalid();
    }

    @Override
    public ShapeState isValid() {
        var superState = super.isValid();
        if(superState != ShapeState.State.OK)
            return superState;

        if(this.angleDegreeBeta > 180 || this.angleDegreeAlpha > 180)
            return RhombusState.WRONG_ANGLE;

        return ShapeState.State.OK;
    }

    @Override
    public double getArea() {
        var rad = Math.toRadians(angleDegreeAlpha);
        return Math.pow(a, 2) * Math.sin(rad);
    }
}
