package org.example.prefertrywithresources;

import java.io.*;

public class TryWithResources {
    /*
    // try-finally - No longer the best way to close resources!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-finally is ugly when used with mor than one resource!

    // Causes difficulty debugging because one try block overwrites the other in the case of Exception throwing.
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buf)) >= 0) {
                    out.write(buf, 0, bytesRead);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
    */

    // How the same examples looks below using try-with-resources

    // try-with-resources - the best way to close resources!
    static String firstLineOfFile(String path, String defaultValue) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) { // Remember to also use try-catch blocks with resources
            return defaultValue;
        }
    }

    // try-with-resources on multiple resources - short and sweet
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buf)) >= 0) {
                out.write(buf, 0, bytesRead);
            }
        }
    }
}
