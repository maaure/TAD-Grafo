import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

    public static void main(String[] args) {
        String mazeString = getFileAsString(
            openFile("./labitinto.path")
        );

        Integer m[][] = getMazeStringAsMatrix(mazeString);
        //System.out.println(maze);

        Maze maze = new Maze(m);

        printMatrix(m);
    }

    private static BufferedReader openFile(String path){
        try {
            return new BufferedReader(new FileReader(new File("./labirinto.dat")));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    private static String getFileAsString(BufferedReader bf) {
        String data = "";
        String st;
        try {
            while((st = bf.readLine()) != null)
                data += st + "\n";
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        return data;
    }

    private static Integer[][] getMazeStringAsMatrix(String maze) {
        String[] lines = maze.split("\n");

        Integer[][] m = new Integer[lines.length][lines[0].length()];

        for(int i = 0; i < lines.length; i++) {
            for(int j = 0; j < lines[0].length(); j++) {
                m[i][j] = Character.getNumericValue(lines[i].charAt(j));
            }
        }

        return m;
    }

    private static void printMatrix(Object[][] m) {
        for(int i = 0; i < m.length; i++) {
            for(int j = 0 ; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}