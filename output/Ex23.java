import java.util.*;

public class Ex23{
    
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int DIAG = 2;

    private static OptMove[][] graph;
    private static char[] seq1;
    private static char[] seq2;

    public static void main(String[] args) {
        Scanner keys = new Scanner(System.in);
        print("Enter first sequence (all caps, no spaces): ");
        seq1 = (keys.nextLine()+"-").toCharArray();

        print("Enter second sequence (all caps, no spaces): ");
        seq2 = (keys.nextLine()+"-").toCharArray();

        graph = new OptMove[seq1.length][seq2.length];

        //fill graph base cases
        for(int i = 0; i < seq1.length; i++){
           graph[seq1.length - i - 1][seq2.length - 1] = new OptMove(i * 2, RIGHT);
        }
        for(int i = 0; i < seq2.length; i++){
            graph[seq1.length - 1][seq2.length - i - 1] = new OptMove(i * 2, DOWN);
        }


        for(int i = 0; i < seq2.length - 1; i++){
            for(int j = 0; j < seq1.length - 1; j++){
                fillGraph(seq1.length - 2 - j, seq2.length - 2 - i);
            }
        }

        printGraph();

        printOptScore();
    }
    /*
    algortihm rule:
    score in cell [i][j] will be min score of one of 3 moves:
    right move [i + 1][j] score + 2
    down move [i][j+1] score + 2
    or diagonal move [i+1][j+1] score + (0 if seq1[i] == seq2[j] or 1 otherwise)
    */

    private static void fillGraph(int i, int j){

        int rmove, dmove, bmove;

        //scores of each move
        rmove = graph[i+1][j].score + 2;
        dmove = graph[i][j+1].score + 2;
        bmove = graph[i+1][j+1].score + (seq1[i] == seq2[j] ? 0 : 1);

        //find min and set the score and opt move
        if(rmove < bmove && rmove < dmove){
            graph[i][j] = new OptMove(rmove, RIGHT);
        }
        else if(dmove < bmove && dmove <= rmove){
            graph[i][j] = new OptMove(dmove, DOWN);
        }
        else{
            graph[i][j] = new OptMove(bmove, DIAG);
        }
    }

    private static void printGraph(){
        for(int i = 0; i < seq1.length; i++){
            tab();
            print(seq1[i]);
        }
        newLine();
        for(int j = 0; j < seq2.length; j++){
            print(seq2[j]);
            for(int i = 0; i < seq1.length; i++){
                tab();
                if(graph[i][j] != null){
                    String nextMove = "";
                    if(graph[i][j].nextMove == RIGHT){
                        nextMove = "→";
                    }
                    else if (graph[i][j].nextMove == DOWN){
                        nextMove = "↓";
                    }
                    else if (graph[i][j].nextMove == DIAG){
                        nextMove = "↘";
                    }
                    print(graph[i][j].score + "" + nextMove + "");
                }
                else
                    print("-");

            }
            newLine();
        }
    }

    private static void printOptScore(){
        int optScore = graph[0][0].score;
        String seq1Final = "";
        String seq2Final = "";
        
        int i = 0;
        int j = 0;
        
        while(i < seq1.length - 1 && j < seq2.length - 1){
            int nextMove = graph[i][j].nextMove;
            if(nextMove == DIAG){
                seq1Final += seq1[i];
                seq2Final += seq2[j];
                i++;
                j++;
            }
            else if (nextMove == DOWN){
                seq1Final += "-";
                seq2Final += seq2[j];
                j++;
            }
            else{
                seq1Final += seq1[i];
                seq2Final += "-";
                i++;
            }
        }

        newLine();
        print("Optimal gap insertion for sequences: ");
        newLine();
        print("1 | " + seq1Final);
        newLine();
        print("2 | " + seq2Final);
        newLine();
        print("For a score of " + optScore);
        newLine();

    }

    private static void print(Object obj){
        System.out.print(obj.toString());
    }
    private static void tab(){
        System.out.print("\t");
    }
    private static void newLine(){
        System.out.println();
    }
}

class OptMove {

    public int score;
    public int nextMove;

    public OptMove(int score, int nextMove){
        this.score = score;
        this.nextMove = nextMove;
    }
}
