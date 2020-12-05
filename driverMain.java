import java.util.*;


public class driverMain
 {

    public static void main(String[] args)  
    {
    	Scanner scan = new Scanner(System.in);
        int tubes=0;
        int ballsIntube=0;
        int completedTubes=0;

        String [] input = args;

        if(input.length<3){
            System.out.println("You must input 3 items.");
            System.exit(1);
        }

        //in order, user inputted # of tubes, # of balls per tube, # of tubes filled
        tubes =Integer.parseInt(args[0]);
        ballsIntube = Integer.parseInt(args[1]);
        completedTubes = Integer.parseInt(args[2]);


        //using paramaters given in instructions:
        while(tubes<4||tubes>12)
        {
            System.out.println("That is an invalid 3 of tubes. Please type a number between 4 and 12:");
            tubes=scan.nextInt();
        }
        while(ballsIntube<4||ballsIntube>8)
        {
            System.out.println("That is an invalid number of balls. Please type a number ranging from 4 to 8:");
            ballsIntube=scan.nextInt();
        }

        int maxValidFilled = tubes-2;
        while(completedTubes<2||completedTubes>maxValidFilled)
        {
            System.out.println("That is an invalid number of tubes to be filled. Please type a number ranging from 2 to " + (maxValidFilled) );
            completedTubes=scan.nextInt();
        }

        System.out.println("There will be " + tubes + " tubes, " + ballsIntube + " balls in each tube, and " + completedTubes + " filled tubes.\n");
        String separator = "============";
        TowersOfFourOrMore tower=new TowersOfFourOrMore(ballsIntube,tubes,completedTubes);
        tower.fill();
        System.out.println("Unsolved Board: ");
        tower.print();
        System.out.println();
        System.out.println(separator + "\nMoves:");
        tower.solve();
        System.out.println(separator + "\n");
        System.out.println("Solved Board: ");
        tower.print();
    }

}