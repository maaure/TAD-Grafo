import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LabirintoMain {

    public static void main(String[] args) {
        String labirintoString = getFileAsString(
            openFile(args[0])
        );

        Integer m[][] = getMazeStringAsMatrix(labirintoString);

        Labirinto labirinto = new Labirinto(m);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if(line.equalsIgnoreCase("-d")) {
            System.out.println("Dijkstra: ");
            labirinto.dijkstra();
            
        } else if (line.equalsIgnoreCase("-a")) {
            System.out.println("A*: ");
            labirinto.a_star();

        }

        

        printMatrix(m);
        //labirinto.printListaVerticesComDistancia();
        labirinto.mostrarCaminhosSaida();
        

    }

    private static BufferedReader openFile(String path){
        try {
            return new BufferedReader(new FileReader(new File(path)));
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
        System.out.print("    ");
        for(int i = 0; i < m[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
        for(int i = 0; i < m.length; i++) {
            System.out.print(((i<10) ? " " : "") + i + "| ");
            for(int j = 0 ; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}