import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LabirintoMain {

    public static void main(String[] args) {
        String labirintoString = getFileAsString(
            openFile(args[0])
        );

        Integer m[][] = getMazeStringAsMatrix(labirintoString);

        Labirinto labirinto = new Labirinto(m);


        if(args[1].equalsIgnoreCase("-d")) {
            System.out.println("Dijkstra: ");
            Long init = System.currentTimeMillis();
            labirinto.dijkstra();
            Long end = System.currentTimeMillis();
            System.out.println("Tempo de execucao: " + (end - init));
        } else if (args[1].equalsIgnoreCase("-a")) {
            System.out.println("A*: ");
            Long init = System.currentTimeMillis();
            labirinto.a_star();
            Long end = System.currentTimeMillis();
            System.out.println("Tempo de execucao: " + (end - init));
        }

        

        printMatrix(m, labirinto);
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

    private static void printMatrix(Object[][] m, Labirinto l) {
        Vertice<Integer>[][] vertices = l.vertices();

        System.out.print("    ");
        for(int i = 0; i < m[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
        for(int i = 0; i < m.length; i++) {
            System.out.print(((i<10) ? " " : "") + i + "| ");
            for(int j = 0 ; j < m[0].length; j++) {
                if(Objects.nonNull(vertices[i][j])) {
                    if(vertices[i][j].isVisitada()) {
                        System.out.print("\u001B[41m");
                    } 
                    if(vertices[i][j].isCaminho()) {
                        System.out.println("ok");
                        System.out.print("\u001B[32m");
                    }
                }
                System.out.print(m[i][j] + " \033[0m");
            }
            System.out.println();
        }
        System.out.println();
    }

}