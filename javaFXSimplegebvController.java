package com.example.step;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class javaFXTryController {


    @FXML
    private Stage stage;

    @FXML
    private Tab Propare;

    @FXML
    private Tab Bayes;

    @FXML
    private Tab GBLUP;

    @FXML
    public Label label1_P;

    @FXML
    public TextField textInput1_P;

    @FXML
    public Label label2_P;

    @FXML
    public TextField textInput2_P;

    @FXML
    public Button fileChoose1_P;

    @FXML
    public TextField textInput3_P;

    @FXML
    public Button fileChoose2_P;

    @FXML
    public TextField textInput4_P;

    @FXML
    public Button fileChoose3_P;

    @FXML
    public TextField textInput5_P;

    @FXML
    public TextField textInput6_P;

    @FXML
    public Label label3_P;

    @FXML
    public TextArea versionView1_P;

    @FXML
    public Button changeVersion_P;

    @FXML
    public ChoiceBox G_model;

    public Label label4_P;

    @FXML
    public Button runStart1_P;

    @FXML
    public Button runStart2_P;

    @FXML
    public Label label5_P;

    @FXML
    public TextField textInput7_P;

    @FXML
    public Button runStart3_P;

    @FXML
    public Button fileChoose4_P;

    @FXML
    public Button runStart4_P;

    @FXML
    public Button fileChoose1_G;

    @FXML
    public TextField dropFile1_G;

    @FXML
    public Button fileChoose2_G;

    @FXML
    public TextField dropFile2_G;

    @FXML
    public Button fileChoose3_G;

    @FXML
    public TextField dropFile3_G;

    @FXML
    public Button fileChoose4_G;

    @FXML
    public TextField dropFile4_G;

    @FXML
    public Label sign1_G;

    @FXML
    public TextField textInput1_G;

    @FXML
    public Label sign2_G;

    @FXML
    public TextField textInput2_G;

    @FXML
    public Button runStart1_G;

    @FXML
    public Label sign3_G;

    @FXML
    public TextArea versionView;

    @FXML
    public Button changeVersion_G;

    @FXML
    private TextField dropFile1;

    @FXML
    private TextField dropFile2;

    @FXML
    private Button fileChoose1;

    @FXML
    private Button fileChoose2;

    @FXML
    private Button fileChoose3;

    @FXML
    private Button runStart1;

    @FXML
    private Label sign1;

    @FXML
    private Label sign2;

    @FXML
    public Label sign3;

    @FXML
    private TextField textInput1;

    @FXML
    private TextField textInput2;

    @FXML
    private TextField textInput3;

    @FXML
    public TextField textInput4;


    @FXML
    private Label viewLabel1;

    @FXML
    private Label viewLabel2;

    @FXML
    public Label viewLabel3;

    @FXML
    public ChoiceBox B_model;




    final String[] phePath_P = {null};
    @FXML
    void btnAction1_P(ActionEvent event) {
        fileChoose1_P.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                textInput3_P.setText("文件不能为空");
            } else {
                phePath_P[0] = file.getAbsolutePath();
                textInput3_P.setText(phePath_P[0]);
            }
        });
    }

    final String[] savePath_P = {null};
    @FXML
    void btnAction2_P(ActionEvent event) {
        fileChoose2_P.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                textInput4_P.setText("请选择一个文件夹");
            } else {
                savePath_P[0] = file.getAbsolutePath();
                textInput4_P.setText(savePath_P[0]);
            }
        });
    }

    final String[] famPath_P = {null};
    @FXML
    void btnAction3_P(ActionEvent event) {
        fileChoose3_P.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                textInput5_P.setText("文件不能为空");
            } else {
                famPath_P[0] = file.getAbsolutePath();
                String split = famPath_P[0];
                String c2 = split.substring(0,split.indexOf("."));
                famPath_P[0] = c2;
                textInput5_P.setText(famPath_P[0]);
            }
        });
    }

    final String[] grmPath_P = {null};
    @FXML
    void btnAction4_P(ActionEvent event) {
        fileChoose4_P.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                textInput6_P.setText("请选择一个文件夹");
            } else {
                grmPath_P[0] = file.getAbsolutePath();
                textInput6_P.setText(grmPath_P[0]);
            }
        });
    }

    final String[] G_method = {"1"};
    @FXML
    void getSelected_P(ActionEvent event) {
        G_model.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number value, Number new_value) {
                G_method[0] = String.valueOf(new_value);
                label4_P.setText(G_method[0]);
            }
        });
    }

    final String[] fixedEffect = {null};
    @FXML
    void changeListener1_P(ActionEvent event) {

    }

    final String[] covarianceEffect = {null};
    @FXML
    void changeListener2_P(ActionEvent event) {

    }

    @FXML
    void changeListener3_P(ActionEvent event) {

    }

    @FXML
    void changeListener4_P(ActionEvent event) {

    }

    @FXML
    void changeListener5_P(ActionEvent event) {

    }

    @FXML
    void changeListener6_P(ActionEvent event) {

    }

    final String[] chromosomeNumber = {null};
    @FXML
    void changeListener7_P(ActionEvent event) {

    }

    @FXML
    void changeVersion_P(ActionEvent event) {    //与GBLUP模块共用R版本
        changeVersion_P.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                versionView1_P.setText("请设置R语言版本");
            } else {
                rScript[0] = file.getAbsolutePath() + "\\" + "bin" + "\\" + "Rscript.exe";
                versionView1_P.setText(file.getAbsolutePath());
            }
        });
    }

    @FXML
    void setBat1_P(ActionEvent event) {
        fixedEffect[0] = textInput1_P.getText();
        covarianceEffect[0] = textInput2_P.getText();
        String rExe;
        if (rScript[0] != null){
            rExe = rScript[0];
        }else{
            rExe = versionView1_P.getText() + "\\" + "bin" + "\\" + "Rscript.exe";
        }
        String finalRExe = rExe;
        System.out.println(finalRExe);
        runStart1_P.setOnAction(arg0 -> {
            String setBat1_P = savePath_P[0] + "\\" + "pheQC" + "_runtime.bat";
            File setBatFile1_P = new File(setBat1_P);
            try {
                setBatFile1_P.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
//                    String root = System.getProperty("user.dir");
                OutputStreamWriter outputBat1_P = new OutputStreamWriter(new FileOutputStream(setBatFile1_P), "UTF-8");
                BufferedWriter bufferedBat1_P = new BufferedWriter(outputBat1_P);
                bufferedBat1_P.write("@echo off");
                bufferedBat1_P.newLine();
                bufferedBat1_P.write(finalRExe + " " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "rrlm.txt" + " " + savePath_P[0] + " " + phePath_P[0] + " " + fixedEffect[0] + " " +covarianceEffect[0]);
                bufferedBat1_P.newLine();
                bufferedBat1_P.write("echo The program is already done!");
                bufferedBat1_P.newLine();
                bufferedBat1_P.write("pause");
                bufferedBat1_P.flush();
                bufferedBat1_P.close();
                bufferedBat1_P.close();
                String cmd_G = "cmd /c start "+setBat1_P;
                try {
                    Process ps = Runtime.getRuntime().exec(cmd_G);
                    ps.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void setBat2_P(ActionEvent event) {
        chromosomeNumber[0] = textInput7_P.getText();
        String rExe;
        if (rScript[0] != null){
            rExe = rScript[0];
        }else{
            rExe = versionView1_P.getText() + "\\" + "bin" + "\\" + "Rscript.exe";
        }
        String finalRExe = rExe;
        System.out.println(finalRExe);
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String time = date.format(formatter);
        System.out.println(time);
        runStart2_P.setOnAction(arg0 -> {
            String setBat2_P = savePath_P[0] + "\\" + "grm" + "_runtime.bat";
            File setBatFile2_P = new File(setBat2_P);
            try {
                setBatFile2_P.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
//                    String root = System.getProperty("user.dir");
                OutputStreamWriter outputBat2_P = new OutputStreamWriter(new FileOutputStream(setBatFile2_P), "UTF-8");
                BufferedWriter bufferedBat2_P = new BufferedWriter(outputBat2_P);
                bufferedBat2_P.write("@echo off");
                bufferedBat2_P.newLine();
                bufferedBat2_P.write( root + "\\" + "runtime" + "\\" + "bin" + "\\" + "gcta64.exe" + " " + "--bfile " + famPath_P[0] + " --make-grm --make-grm-alg " + G_method[0] + " --autosome-num " + chromosomeNumber[0] + " --out " + savePath_P[0] + "\\" + "grm_out_" + time + " && " + finalRExe + " " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "combine.txt " + savePath_P[0]);
                bufferedBat2_P.newLine();
                bufferedBat2_P.write("echo The program is already done!");
                bufferedBat2_P.newLine();
                bufferedBat2_P.write("pause");
                bufferedBat2_P.flush();
                bufferedBat2_P.close();
                bufferedBat2_P.close();
                String cmd_G = "cmd /c start "+setBat2_P;
                try {
                    Process ps = Runtime.getRuntime().exec(cmd_G);
                    ps.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void setBat3_P(ActionEvent event) {
        fixedEffect[0] = textInput1_P.getText();
        covarianceEffect[0] = textInput2_P.getText();
        chromosomeNumber[0] = textInput7_P.getText();
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String time = date.format(formatter);
        System.out.println(time);
        String rExe;
        if (rScript[0] != null){
            rExe = rScript[0];
        }else{
            rExe = versionView1_P.getText() + "\\" + "bin" + "\\" + "Rscript.exe";
        }
        String finalRExe = rExe;
//        System.out.println(finalRExe);
        String split1 = phePath_P[0];
        String c2 = split1.substring(0,split1.indexOf("."));
//        System.out.println(c2);
        String c3 = c2.substring(c2.lastIndexOf("\\")+1);
//        System.out.println(c3);
        runStart3_P.setOnAction(arg0 -> {
            String setBat3_P = savePath_P[0] + "\\" + "whole" + "_runtime.bat";
            File setBatFile3_P = new File(setBat3_P);
            System.out.println(1111);
            try {
                setBatFile3_P.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
//                    String root = System.getProperty("user.dir");
                OutputStreamWriter outputBat3_P = new OutputStreamWriter(new FileOutputStream(setBatFile3_P), "UTF-8");
                BufferedWriter bufferedBat3_P = new BufferedWriter(outputBat3_P);
                bufferedBat3_P.write("@echo off");
                bufferedBat3_P.newLine();
                bufferedBat3_P.write(finalRExe + " " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "rrlm.txt" + " " + savePath_P[0] + " " + phePath_P[0] + " " + fixedEffect[0] + " " +covarianceEffect[0] + " && " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "gcta64.exe" + " " + "--bfile " + famPath_P[0] + " --make-grm --make-grm-alg " + G_method[0] + " --autosome-num " + chromosomeNumber[0] + " --out " + savePath_P[0] + "\\" + "grm_out_" + time + " && " + finalRExe + " " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "combine.txt " + savePath_P[0] + " && " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "gcta64.exe" + " " + "--grm " + savePath_P[0] + "\\" + "grm_out_" + time + " --pheno " + savePath_P[0] + "\\" + "phe_qc.csv" + " --reml --out " + savePath_P[0] + "\\" + c3 + "_h2_" + time);
                bufferedBat3_P.newLine();
                bufferedBat3_P.write("echo The program is already done!");
                bufferedBat3_P.newLine();
                bufferedBat3_P.write("pause");
                bufferedBat3_P.flush();
                bufferedBat3_P.close();
                bufferedBat3_P.close();
                String cmd_G = "cmd /c start "+setBat3_P;
                try {
                    Process ps = Runtime.getRuntime().exec(cmd_G);
                    ps.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void setBat4_P(ActionEvent event) {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String time = date.format(formatter);
        System.out.println(time);
        String split1 = phePath_P[0];
        String c2 = split1.substring(0,split1.indexOf("."));
        String c3 = c2.substring(c2.lastIndexOf("\\")+1);

        runStart4_P.setOnAction(arg0 -> {
            String setBat4_P = savePath_P[0] + "\\" + "grm" + "_runtime.bat";
            File setBatFile4_P = new File(setBat4_P);
            try {
                setBatFile4_P.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
//                    String root = System.getProperty("user.dir");
                OutputStreamWriter outputBat4_P = new OutputStreamWriter(new FileOutputStream(setBatFile4_P), "UTF-8");
                BufferedWriter bufferedBat4_P = new BufferedWriter(outputBat4_P);
                bufferedBat4_P.write("@echo off");
                bufferedBat4_P.newLine();
                bufferedBat4_P.write( root + "\\" + "runtime" + "\\" + "bin" +"\\" + "gcta64.exe" + " " + "--grm " + grmPath_P[0] + " --pheno " + phePath_P[0] + " --reml --out " + savePath_P[0] + "\\" + c3 + "_h2_" + time);
                bufferedBat4_P.newLine();
                bufferedBat4_P.write("echo The program is already done!");
                bufferedBat4_P.newLine();
                bufferedBat4_P.write("pause");
                bufferedBat4_P.flush();
                bufferedBat4_P.close();
                bufferedBat4_P.close();
                String cmd_G = "cmd /c start "+setBat4_P;
                try {
                    Process ps = Runtime.getRuntime().exec(cmd_G);
                    ps.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }





    //选择文件部分可以写成class再度简化代码
    final String[] savePath_G = {null};
    @FXML
    void btnAction1_G(ActionEvent event) {
        fileChoose1_G.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                dropFile1_G.setText("请选择一个文件夹");
            } else {
                savePath_G[0] = file.getAbsolutePath();
                dropFile1_G.setText(savePath_G[0]);
            }
        });
    }

    final String[] phePath_G = {null};
    @FXML
    void btnAction2_G(ActionEvent event) {
        fileChoose2_G.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                dropFile2_G.setText("文件不能为空");
            } else {
                phePath_G[0] = file.getAbsolutePath();
                dropFile2_G.setText(phePath_G[0]);
            }
        });
    }

    final String[] grmPath_G = {null};
    @FXML
    void btnAction3_G(ActionEvent event) {
        fileChoose3_G.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                dropFile3_G.setText("文件不能为空");
            } else {
                grmPath_G[0] = file.getAbsolutePath();
                dropFile3_G.setText(grmPath_G[0]);
            }
        });
    }

    final String[] famPath_G = {null};
    @FXML
    void btnAction4_G(ActionEvent event) {
        fileChoose4_G.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                dropFile4_G.setText("文件不能为空");
            } else {
                famPath_G[0] = file.getAbsolutePath();
                dropFile4_G.setText(famPath_G[0]);
            }
        });
    }

    final String[] repTimes = {"5"};

    final String[] foldNum = {"5"};
    @FXML
    void changeListener1_G(ActionEvent event) {

    }
    //监听事件待写（不影响）
    @FXML
    void changeListener2_G(ActionEvent event) {

    }

    public String root = System.getProperty("user.dir");
    @FXML
    void setBat1_G(ActionEvent event) {
        String appName_G = "GBLUP";
        repTimes[0] = textInput1_G.getText();
        foldNum[0] = textInput2_G.getText();
        String rExe;
        if (rScript[0] != null){
            rExe = rScript[0];
        }else{
            rExe = versionView.getText() + "\\" + "bin" + "\\" + "Rscript.exe";
        }
        String finalRExe = rExe;
        System.out.println(finalRExe);
        runStart1_G.setOnAction(arg0 -> {
            String setBat_G = savePath_G[0] + "\\" + appName_G + "_runtime.bat";
            File setBatFile_G = new File(setBat_G);
                try {
                    setBatFile_G.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
//                    String root = System.getProperty("user.dir");
                    OutputStreamWriter outputBat_G = new OutputStreamWriter(new FileOutputStream(setBatFile_G), "UTF-8");
                    BufferedWriter bufferedBat_G = new BufferedWriter(outputBat_G);
                    bufferedBat_G.write("@echo off");
                    bufferedBat_G.newLine();
                    bufferedBat_G.write(finalRExe + " " + root + "\\" + "runtime" + "\\" + "bin" +"\\" + "calgebv.txt" + " " + savePath_G[0] + " " + phePath_G[0] + " " + grmPath_G[0] + " " + famPath_G[0] + " " + repTimes[0] + " " + foldNum[0]);
                    bufferedBat_G.newLine();
                    bufferedBat_G.write("echo The program is already done!");
                    bufferedBat_G.newLine();
                    bufferedBat_G.write("pause");
                    bufferedBat_G.flush();
                    bufferedBat_G.close();
                    outputBat_G.close();
                    String cmd_G = "cmd /c start "+setBat_G;
                    try {
                        Process ps = Runtime.getRuntime().exec(cmd_G);
                        ps.waitFor();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });
    }

    //拖拽获取文件路径待写（不影响）
    @FXML
    void textFiledAction1_G(ActionEvent event) {

    }

    @FXML
    void textFiledAction2_G(ActionEvent event) {

    }

    @FXML
    void textFiledAction3_G(ActionEvent event) {

    }

    @FXML
    void textFiledAction4_G(ActionEvent event) {

    }

//    String rVer = root + "\\" + "cache.txt";
    final String[] rScript = {null};
    @FXML
    void changeVersion(ActionEvent event) {
        changeVersion_G.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                versionView.setText("请设置R语言版本");
            } else {
                rScript[0] = file.getAbsolutePath() + "\\" + "bin" + "\\" + "Rscript.exe";
                versionView.setText(file.getAbsolutePath());
            }
        });
    }

//    @FXML 预设R版本 失败
//    void rVersionSelection(ActionEvent event) {
//        GBLUP.setOnSelectionChanged(event1 -> {
//            FileReader file = null;
//            try {
//                file = new FileReader(root + "\\" + "cache.txt");
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            BufferedReader buffer = new BufferedReader(file);
//            try {
//                String line = buffer.readLine();
//                versionView.setText(line);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }

    final String[] phePath = {null};
    final int[] pheNumber = {0};
    @FXML
    void btnAction1(ActionEvent event) {
        fileChoose1.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                dropFile1.setText("文件不能为空");
            } else {
                phePath[0] = file.getAbsolutePath();
                dropFile1.setText(phePath[0]);
                numberPheRead filePathRead = null;
                try {
                    filePathRead = new numberPheRead(phePath[0]);
                    pheNumber[0] = filePathRead.number;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                viewLabel1.setText("表型个数："+String.valueOf(pheNumber[0]));
            }
        });
    }

    final String[] snpPath = {null};
    final String[] snpNumber = {null};
    @FXML
    void btnAction2(ActionEvent event) {
        fileChoose2.setOnAction(arg0 -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("选择文件");
            chooser.setInitialDirectory(new File("C:\\"));
            File file = chooser.showOpenDialog(stage);
            if (file == null){
                dropFile2.setText("文件不能为空");
            } else {
                snpPath[0] = file.getAbsolutePath();
                dropFile2.setText(snpPath[0]);
//                numberSNPRead numberSNPRead = new numberSNPRead(snpPath[0]);
//                snpNumber[0] = numberSNPRead.columNumber;
//                viewLabel2.setText("snp:done"+String.valueOf(snpNumber[0]));
            }
        });
    }

    final String[] savePath = {null};
    @FXML
    void btnAction3(ActionEvent event) {
        fileChoose3.setOnAction(arg0 -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择文件夹");
            File file = directoryChooser.showDialog(stage);
            if (file == null) {
                textInput3.setText("请选择一个文件夹");
            } else {
                savePath[0] = file.getAbsolutePath();
                textInput3.setText(savePath[0]);
            }
        });
    }

    final String[] piValue = {null};

    final String[] heritability = {null};

    @FXML//监听事件无法使用
    void changeListener3(ActionEvent event) {
//        textInput3.textProperty().addListener((observableValue, oldValue, newValue) -> savePath[0] = newValue);
    }


    final int[] B_method = {0};
    final String[] set_B_model = {null};
    @FXML
    public void getSelected_B(ActionEvent event) {
        B_model.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number value, Number new_value) {
                B_method[0] = (int) new_value;
                if (B_method[0] == 0){
                    set_B_model[0] = "BayesA";
                } else if (B_method[0] == 1) {
                    set_B_model[0] = "BayesB";
                } else if (B_method[0] == 2) {
                    set_B_model[0] = "BayesCpi";
                }else {
                    set_B_model[0] = "BayesFB";
                }
                viewLabel3.setText("选择模型：done");
            }
        });
    }

    @FXML
    void setBat1(ActionEvent event) {

        String appName = set_B_model[0];
        piValue[0] = textInput1.getText();
        heritability[0] = textInput2.getText();
        snpNumber[0] = textInput4.getText();

        if (Objects.equals(set_B_model[0], "BayesFB")) {
            runStart1.setOnAction(arg0 -> {
                //TODO 生成TXT文件，bat文件，并完成程序的调用
                String inPara = savePath[0] + "\\" + appName + "_in.txt";
                String setParameterFileName = savePath[0] + "\\" + appName + "_para.txt";
                String setBat = savePath[0] + "\\" + appName + "_runtime.bat";
                File setParameterFile = new File(setParameterFileName);
                File inParameter = new File(inPara);
                File setBatFile = new File(setBat);
                if (inPara != null && setParameterFile != null) {
                    try {
                        setParameterFile.createNewFile();
                        inParameter.createNewFile();
                        setBatFile.createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        OutputStreamWriter outputIn = new OutputStreamWriter(new FileOutputStream(inParameter), "UTF-8");
                        BufferedWriter bufferedIn = new BufferedWriter(outputIn);
                        bufferedIn.write(setParameterFileName);
                        bufferedIn.flush();
                        bufferedIn.close();
                        outputIn.close();

//                String root = System.getProperty("user.dir");

                        OutputStreamWriter outputBat = new OutputStreamWriter(new FileOutputStream(setBatFile), "UTF-8");
                        BufferedWriter bufferedBat = new BufferedWriter(outputBat);
                        bufferedBat.write("@echo off");
                        bufferedBat.newLine();
//                bufferedBat.write("path = " + "D:\\lkan-history-2021-11-\\temp\\BayesFB");//未完成
                        bufferedBat.write("path = " + root +"\\" + "runtime" + "\\" + "bin");
                        bufferedBat.newLine();
                        bufferedBat.write(appName + ".exe <" + inPara);
                        bufferedBat.newLine();
                        bufferedBat.write("pause");
                        bufferedBat.flush();
                        bufferedBat.close();
                        outputBat.close();

                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(setParameterFile), "UTF-8");
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        bufferedWriter.write(String.valueOf(phePath[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpPath[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_effect_QTL.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_var_QTL.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_gebv.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_degree_Value.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(pheNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(pheNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(piValue[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(piValue[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(heritability[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(heritability[0]));
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStreamWriter.close();
                        String cmd = "cmd /c start " + setBat;
                        try {
                            Process ps = Runtime.getRuntime().exec(cmd);
                            ps.waitFor();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } else if (Objects.equals(set_B_model[0], "BayesA")) {
            runStart1.setOnAction(arg0 -> {
                //TODO 生成TXT文件，bat文件，并完成程序的调用
                String setParameterFileName = savePath[0] + "\\" + appName + "_para.txt";
                String setBat = savePath[0] + "\\" + appName + "_runtime.bat";
                File setParameterFile = new File(setParameterFileName);
                File setBatFile = new File(setBat);
                try{
                    setParameterFile.createNewFile();
                    setBatFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
//                String root = System.getProperty("user.dir");
                        OutputStreamWriter outputBat = new OutputStreamWriter(new FileOutputStream(setBatFile), "UTF-8");
                        BufferedWriter bufferedBat = new BufferedWriter(outputBat);
                        bufferedBat.write("@echo off");
                        bufferedBat.newLine();
//                bufferedBat.write("path = " + "D:\\lkan-history-2021-11-\\temp\\BayesFB");//未完成
                        bufferedBat.write(root+ "\\" + "runtime" + "\\" + "bin" +"\\" + appName + ".exe " + setParameterFileName);
                        bufferedBat.newLine();
                        bufferedBat.write("pause");
                        bufferedBat.flush();
                        bufferedBat.close();
                        outputBat.close();

                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(setParameterFile), "UTF-8");
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        bufferedWriter.write(String.valueOf(phePath[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpPath[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_effect_QTL.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_var_QTL.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_gebv.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(savePath[0] + "\\" + appName + "_log.txt");
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(pheNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(pheNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(snpNumber[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(heritability[0]));
                        bufferedWriter.newLine();
                        bufferedWriter.write(String.valueOf(heritability[0]));
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStreamWriter.close();
                        String cmd = "cmd /c start " + setBat;
                        try {
                            Process ps = Runtime.getRuntime().exec(cmd);
                            ps.waitFor();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

            });
        } else if (Objects.equals(set_B_model[0],"BayesB")) {
            runStart1.setOnAction(arg0 -> {
                //TODO 生成TXT文件，bat文件，并完成程序的调用
                String setParameterFileName = savePath[0] + "\\" + appName + "_para.txt";
                String setBat = savePath[0] + "\\" + appName + "_runtime.bat";
                File setParameterFile = new File(setParameterFileName);
                File setBatFile = new File(setBat);
                try{
                    setParameterFile.createNewFile();
                    setBatFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
//                String root = System.getProperty("user.dir");
                    OutputStreamWriter outputBat = new OutputStreamWriter(new FileOutputStream(setBatFile), "UTF-8");
                    BufferedWriter bufferedBat = new BufferedWriter(outputBat);
                    bufferedBat.write("@echo off");
                    bufferedBat.newLine();
//                bufferedBat.write("path = " + "D:\\lkan-history-2021-11-\\temp\\BayesFB");//未完成
                    bufferedBat.write(root+ "\\" + "runtime" + "\\" + "bin" +"\\" + appName + ".exe " + setParameterFileName);
                    bufferedBat.newLine();
                    bufferedBat.write("pause");
                    bufferedBat.flush();
                    bufferedBat.close();
                    outputBat.close();

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(setParameterFile), "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write(String.valueOf(phePath[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpPath[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_effect_QTL.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_var_QTL.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_gebv.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_log.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(pheNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(pheNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(piValue[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(piValue[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(heritability[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(heritability[0]));
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStreamWriter.close();
                    String cmd = "cmd /c start " + setBat;
                    try {
                        Process ps = Runtime.getRuntime().exec(cmd);
                        ps.waitFor();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        }else {
            runStart1.setOnAction(arg0 -> {
                //TODO 生成TXT文件，bat文件，并完成程序的调用
                String setParameterFileName = savePath[0] + "\\" + appName + "_para.txt";
                String setBat = savePath[0] + "\\" + appName + "_runtime.bat";
                File setParameterFile = new File(setParameterFileName);
                File setBatFile = new File(setBat);
                try{
                    setParameterFile.createNewFile();
                    setBatFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
//                String root = System.getProperty("user.dir");
                    OutputStreamWriter outputBat = new OutputStreamWriter(new FileOutputStream(setBatFile), "UTF-8");
                    BufferedWriter bufferedBat = new BufferedWriter(outputBat);
                    bufferedBat.write("@echo off");
                    bufferedBat.newLine();
//                bufferedBat.write("path = " + "D:\\lkan-history-2021-11-\\temp\\BayesFB");//未完成
                    bufferedBat.write(root+ "\\" + "runtime" + "\\" + "bin" +"\\" + appName + ".exe " + setParameterFileName);
                    bufferedBat.newLine();
                    bufferedBat.write("pause");
                    bufferedBat.flush();
                    bufferedBat.close();
                    outputBat.close();

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(setParameterFile), "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write(String.valueOf(phePath[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpPath[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_effect_QTL.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_var_QTL.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_gebv.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_pi.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(savePath[0] + "\\" + appName + "_log.txt");
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(pheNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(pheNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(snpNumber[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(piValue[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(piValue[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(heritability[0]));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(heritability[0]));
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStreamWriter.close();
                    String cmd = "cmd /c start " + setBat;
                    try {
                        Process ps = Runtime.getRuntime().exec(cmd);
                        ps.waitFor();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }

    @FXML
//    拖拽事件无法使用
    void textFiledAction1(DragEvent ignoredEvent) {
        dropFile1.setOnDragOver(event -> event.acceptTransferModes(TransferMode.ANY));
        dropFile1.setOnDragDropped(dragEvent -> {
            Dragboard dragboard = dragEvent.getDragboard();
            if (dragboard.hasFiles()){
                String path = dragboard.getFiles().get(0).getAbsolutePath();
                phePath[0] = path;
                dropFile1.setText(phePath[0]);
                numberPheRead filePathRead = null;
                try {
                    filePathRead = new numberPheRead(phePath[0]);
                    pheNumber[0] = filePathRead.number;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                viewLabel1.setText("表型个数："+String.valueOf(pheNumber[0]));
            }
        });
    }

    @FXML
    //拖拽事件无法使用
    void textFiledAction2(ActionEvent ignoredEvent) {
        dropFile2.setOnDragOver(event -> event.acceptTransferModes(TransferMode.ANY));
        dropFile2.setOnDragDropped(dragEvent -> {
            Dragboard dragboard = dragEvent.getDragboard();
            if (dragboard.hasFiles()){
                String path = dragboard.getFiles().get(0).getAbsolutePath();
                snpPath[0] = path;
                dropFile2.setText(snpPath[0]);
//                numberSNPRead numberSNPRead = new numberSNPRead(snpPath[0]);
//                snpNumber[0] = numberSNPRead.columNumber;
//                viewLabel2.setText("SNP个数："+String.valueOf(snpNumber[0]));
            }
        });
    }



}
