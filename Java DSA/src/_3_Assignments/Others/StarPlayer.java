package _3_Assignments.Others;
/* rows seasons
columns players
matrix of score
find star player
frequency of repetition of max scores */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class StarPlayer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> seasonStars;
        int numSeasons, numPlayers;
        System.out.println("Enter the number of Seasons: ");
        numSeasons = in.nextInt();
        System.out.println("Enter the number of Players: ");
        numPlayers = in.nextInt();
        double[][] scoreMatrix = new double[numSeasons][numPlayers];
        System.out.println("\nEnter Player Scores for each Season: \n");
        for(int i = 0; i < numSeasons; i++){
            for(int j = 0; j < numPlayers; j++){
                System.out.printf("Player %d, Season %d: ", j+1, i+1);
                scoreMatrix[i][j] = in.nextDouble();
            }
        }
        System.out.println("\n\nScoreboard: ");
        int season = 1;
        for(double[] element:scoreMatrix){
            System.out.println("Season "+season+" "+Arrays.toString(element));
            season++;
        }
        seasonStars = findSeasonPlayers(scoreMatrix);
        declareStarPlayers(seasonStars);
    }

    static ArrayList<Integer> findSeasonPlayers(double[][] scoreMatrix){
        ArrayList<Integer> result = new ArrayList<>();
        int maxIndex;
        for(int i = 0; i < scoreMatrix.length; i++){
            maxIndex = 0;
            for(int j = 0; j < scoreMatrix[i].length; j++){
                if(i == 0){
                    result.add(0);
                }
                if(scoreMatrix[i][j] > scoreMatrix[i][maxIndex]){
                    maxIndex = j;
                }
            }
            for(int j = 0; j < scoreMatrix[i].length; j++){
                if(scoreMatrix[i][j] == scoreMatrix[i][maxIndex]){
                    result.set(j, result.get(j)+1);
                }
            }
        }
        return result;
    }

    static void declareStarPlayers(ArrayList<Integer> seasonStars){
        int maxSeasonIndex = 0;
        for(int i = 0; i < seasonStars.size(); i++){
            if(seasonStars.get(i) > seasonStars.get(maxSeasonIndex))
                maxSeasonIndex = i;
        }
        System.out.println("\nStar Player(s): ");
        for(int i = 0; i < seasonStars.size(); i++){
            if(seasonStars.get(i).equals(seasonStars.get(maxSeasonIndex)))
                System.out.println("Player "+(i+1));
        }
    }
}
