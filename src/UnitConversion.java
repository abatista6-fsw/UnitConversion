import java.util.Scanner;

public class UnitConversion {

    public static void main(String[] args) {
        //firstUnit is converted to secondUnit; value is given to firstUnit
        String firstUnit;
        String secondUnit;
        double value;

        Scanner inputConverter = new Scanner(System.in);
        //inputs for firstUnit, secondUnit, and value
        System.out.print("Enter the unit you want to convert from: ");
        firstUnit = inputConverter.nextLine();

        System.out.print("Enter the unit you want to convert to: ");
        secondUnit = inputConverter.nextLine();

        System.out.print("Enter the value for the unit you want to convert from: ");
        value = inputConverter.nextDouble();

        //stores the conversion result
        double result = 0;

        //performs the conversion according to the input and output units
        result = convertUnits(firstUnit, secondUnit, value);

        //if result = -1, it means an invalid unit was used
        if (result != -1) {
            System.out.println(value + " " + firstUnit + " equals " + result + " " + secondUnit);
        }
        else {
            System.out.println("The unit entered is invalid. The units allowed are inches, feet, cubits, steps, yards, and miles.");
        }
    }

    //unit conversion is done here
    public static double convertUnits(String firstUnit, String secondUnit, double value) {

        //unit conversion to inches as a base
        double inchesPerFeet = 12.0;
        double inchesPerCubit = 18.0;
        double inchesPerSteps = 30.0;
        double inchesPerYards = 36.0;
        double inchesPerMiles = 63360.0;

        //convert firstUnit to inches first
        double valueInInches = 0;

        switch (firstUnit) {
            case "inches":
                valueInInches = value;
                break;
            case "feet":
                valueInInches = value * inchesPerFeet;
                break;
            case "cubits":
                valueInInches = value * inchesPerCubit;
                break;
            case "steps":
                valueInInches = value * inchesPerSteps;
                break;
            case "yards":
                valueInInches = value * inchesPerYards;
                break;
            case "miles":
                valueInInches = value * inchesPerMiles;
                break;
            //indicates the use of an invalid input unit
            default:
                return -1;
        }

        //convert from inches to desired unit
        switch (secondUnit) {
            case "inches":
                return valueInInches;
            case "feet":
                return valueInInches * inchesPerFeet;
            case "cubits":
                return valueInInches * inchesPerCubit;
            case "steps":
                return valueInInches * inchesPerSteps;
            case "yards":
                return valueInInches * inchesPerYards;
            case "miles":
                return valueInInches * inchesPerMiles;
            //indicates the use of an invalid output unit
            default:
                return -1;
        }
    }
}