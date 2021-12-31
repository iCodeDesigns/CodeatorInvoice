/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class FileOp {

    private String FileName = "";

    /**
     * Constructor that Reads text file
     *
     * @param file_name
     * @throws Exception
     */
    
    public FileOp(String file_name) {
        // TODO code application logic here
        this.FileName = file_name;
    }
    
    public FileOp(){
        
    }

    /**
     * Method that reads file content
     *
     * @param file_name
     * @throws Exception
     */
    public List<String> ReadFile() throws Exception {
        List<String> Content = new ArrayList<>();
        File file = new File(this.FileName);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

            String st;
            while ((st = br.readLine()) != null) {
                Content.add(st);
            }
        } catch (Exception e) {
            throw new Exception("File Not Exists or file name not in the format fileName.txt");
        }
        return Content;
    }

    public boolean DeleteFile() {
        File file = new File(this.FileName);
        return file.delete();
    }

    /**
     * ReadFile exist in web Applications
     *
     * @return
     * @throws Exception
     */
    public String ReadFileInWebApp() throws Exception {
        String Content = "";
        try {
            FileInputStream F = new FileInputStream(this.FileName);

            InputStream in = new BufferedInputStream(F);
            int ch;
            while ((ch = in.read()) != -1) {
                Content += (char) ch;
            }
            in.close();

        } catch (Exception e) {
            throw new Exception("File Not Exists or file name not in the format fileName.txt");
        }
        return Content;
    }

    /**
     * Method that create file if not exist and write a content for it by line
     * in List<String> lines
     *
     * @param lines content lines
     * @throws Exception
     */
    public void CreateAndWriteFile(List<String> lines) throws Exception {
        try {
            Path file = Paths.get(this.FileName);
            Files.write(file, lines, Charset.forName("UTF-8"));
            //Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (Exception e) {
            throw new Exception("File not in the format fileName.txt");
        }
    }

    /**
     * Method that create file if not exist and write a content for it by line
     * in List<String> lines appended to the previous content
     *
     * @param lines
     * @throws Exception
     */
    public void CreateAndWriteFileAppended(List<String> lines) throws Exception {
        try {
            Path file = Paths.get(this.FileName);
            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (Exception e) {
            throw new Exception("File not in the format fileName.txt");
        }
    }

    public void CreateAndWriteFileOnWebApp(String DirectorPath, String FileName, List<String> lines) throws Exception {
        //new File("C:\\LIC").mkdir();
        new File(DirectorPath).mkdir();
        //FileOp file = new FileOp("C:\\LIC\\LIC.txt");
        FileOp file = new FileOp(DirectorPath + "\\" + FileName);
        boolean FileDeleted = true;
        try {
            file.ReadFile();
            file.DeleteFile();
            throw new Exception();
        } catch (Exception e) {
            file.CreateAndWriteFile(lines);
        }
        if (!FileDeleted) {
            throw new Exception();
        }
    }
}
