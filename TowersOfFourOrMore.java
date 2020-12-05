import java.util.*;

public class TowersOfFourOrMore 
{

    int[][] Board;
    int rows;
    int cols;
    int filled;

    public TowersOfFourOrMore(int ballsintube, int numtubes, int fill)
    {
        Board=new int[ballsintube][numtubes];//board size
        rows=ballsintube;
        cols=numtubes;
        filled=fill;
    }



    //solves the game
    public void solve()
    {
        int count1=0;
        int counter0=0;
        int gameCheck=0;
        int count=0;
        int setRow;
        int setCol;
        

        //continues until all -1's are gone
        while(count<filled-1) 
        {
            int z = count + 2;
            for (int i = count; i < z; i++) 
            {
                for (int j = 0; j < rows; j++) 
                {//loops from 0 to # of rows

                    setRow = rows - j - 1;
                    setCol = cols - gameCheck - 1;

                    int m = Board[setRow][setCol];

                    if (Board[j][i] == 0)
                        counter0++;
                    else if (Board[j][i] == 1)
                        count1++;
                    
                    Board[setRow][setCol] = Board[j][i];
                    System.out.println("tube " + i + " - tube " + (setCol));//print move
                    Board[j][i] = m;
                }
                gameCheck++;
            }
            gameCheck = 0;
            int index = count;

            if (counter0 >= count1) 
            {
                int x = 0;
                int y = 0;

                for (int k = cols - 2; k < cols; k++) 
                {
                    for (int l = 0; l < rows; l++) 
                    {
                        if (!isCorrect(index)) 
                        {
                            if (Board[l][k] == 0) 
                            {
                                Board[rows - x - 1][index] = Board[l][k];
                                System.out.println("tube "+k+" - tube "+(index));
                                x++;
                                Board[l][k] = -1;
                            }
                            else 
                            {
                                Board[rows - y - 1][index + 1] = Board[l][k];
                                System.out.println("tube "+k+" - tube "+(index));//print the move made
                                y++;
                                Board[l][k] = -1;
                            }
                        }
                        //then column doesnt match
                        else 
                        {
                            Board[rows - y - 1][index + 1] = Board[l][k];
                            System.out.println("tube "+ k +" - tube "+(index));//print the move made
                            y++;
                            Board[l][k] = -1;                        
                        }
                    }
                }
            }
            else if (counter0 < count1) 
            {

                int x = 0;
                int y = 0;
                for (int k = cols - 2; k < cols; k++) 
                {
                    for (int l = 0; l < rows; l++) 
                    {
                        if (!isCorrect(index)) 
                        {//if the columns dont match, then the following happens:
                            if (Board[l][k] == 1) 
                            {
                                Board[rows - x - 1][index] = Board[l][k];
                                System.out.println("tube "+ k +" - tube "+(index));
                                x++;
                                Board[l][k] = -1;
                            }

                            else 
                            {
                                Board[rows - y - 1][index + 1] = Board[l][k];
                                System.out.println("tube "+ k +" - tube "+(index));
                                y++;
                                Board[l][k] = -1;
                            }
                        }
                        else 
                        {//if column matches
                            Board[rows - y - 1][index + 1] = Board[l][k]; //makes the move and prints it
                            System.out.println("tube " + k + " - tube " + (index ));
                            y++;
                            Board[l][k] = -1;
                        }
                    }
                }
            }
            count++;
            counter0 = 0;
            count1 = 0;
        }
        System.out.println();
    }


    public boolean isCorrect(int column)
    {//makes sure column matches and there is no -1 
        int newValue=Board[0][column];
        boolean alert=true;

        for(int i=0;i<rows;i++)
        {
            if(!(Board[i][column]==newValue && newValue!=-1)) //if this condition is not true, then col doesn't match or there is a -1
            {
                alert = false;
                i = rows;
            }
        }
        return alert;
    }
   
    public void fill()
    {
        
        //initialized board spaces to be -1
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                Board[i][j]=-1;
            }
        }


        int tempListSize = filled*rows;
        ArrayList<Integer> tempList=new ArrayList<>(tempListSize);
        int filler=0;
        for(int i=0;i<filled;i++)
        {
            for(int j=0;j<rows;j++)
            {
                tempList.add(filler);
            }
            if(filler==0)
                filler++;
            else
                filler--;
        }
        int k=0;
    
        while(!(tempList.isEmpty()))
        {
            
            for(int j=0;j<filled;j++){
                
                int rand=new Random().nextInt(tempList.size());
                Board[k][j]=tempList.get(rand); 
                tempList.remove(rand);
            }
            k++;
        }
    }

    //prints the board
    public void print()
    {
        String separator = "============";
        System.out.println(separator);
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(Board[i][j] != -1) //only prints tubes that are filled to some degree
                {
                    System.out.print(Board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(separator);
        for(int i=0; i<cols; i++){
            
                System.out.print(i + " ");
         
        }
        System.out.println();
    }
   
}