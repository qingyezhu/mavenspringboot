package com.wangzhu.springboot.fileio;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by wangz on 2024/7/31 15:57.
 **/
public class FileIOTest {

    @Test
    public void testReader1() {
        try (FileReader fr = new FileReader("file.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void testReader2() {
        try (FileInputStream fis = new FileInputStream("file.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void testWriter1() {
        try (FileWriter fw = new FileWriter("file.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("");
        } catch (Exception e) {

        }
    }

    @Test
    public void testWriter2() {
        try (FileOutputStream fos = new FileOutputStream("file.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write("");
        } catch (Exception e) {

        }
    }

    @Test
    public void testScanner() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                String str = cin.nextLine();
                System.out.println(str);
            }
        }
    }


}
