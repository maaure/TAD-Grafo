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
            Long init = System.nanoTime();
            labirinto.dijkstra();
            Long end = System.nanoTime();
            Double eplasedTime = (end.doubleValue() - init.doubleValue())/1000000;
            System.out.println("Tempo de execucao: " + eplasedTime + "ms");
        } else if (args[1].equalsIgnoreCase("-a")) {
            System.out.println("A*: ");
            Long init = System.nanoTime();
            labirinto.a_star();
            Long end = System.nanoTime();
            Double eplasedTime = (end.doubleValue() - init.doubleValue())/1000000;
            System.out.println("Tempo de execucao: " + eplasedTime + "ms");
        }

        

        labirinto.listarCaminhosSaida();
        labirinto.printLabirinto();
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

}