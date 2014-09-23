package scanner;

import java.io.*;

/**
 * Scanner for fast line reading. Can only read lines (till <code>'\n'</code>,
 * not till <code>' '</code>).
 * @author Daniyar Itegulov
 * @since %I% %D%
 * @version 1.1
 */
public final class FastLineScanner {
    private String nextLine;
    private BufferedReader br;

    /**
     * Creates scanner, which reads from specified file
     * @throws          java.io.FileNotFoundException
     * @param file      specifies file, which must be read from
     */
    public FastLineScanner(File file) throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException();
        }
        br = new BufferedReader(new FileReader(file));

        try {
            nextLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gives next line from input or prints {@link java.io.IOException}
     * and returns <code>""</code> if occurred.
     * @return          next line, read from input source
     */
    public String next() {
        String s;

        try {
            s = nextLine;
            nextLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        return s;
    }

    /**
     * Checks if input source has more lines to read
     * @return          <code>true</code> if lines are left in input source
     */
    public boolean hasMore() {
        return nextLine != null;
    }
}