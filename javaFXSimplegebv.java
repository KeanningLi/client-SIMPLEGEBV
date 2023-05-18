package com.example.step;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Optional;

import static javafx.application.Platform.exit;
import static javafx.application.Platform.setImplicitExit;

public class javaFXTry extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(javaFXTry.class.getResource("JavaFX_try.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SIMPLEGEBV");
        stage.getIcons().add(new Image("/Icon_image.png"));

//        String root = System.getProperty("user.dir");
//        System.out.println(root);

        setImplicitExit(false);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("退出程序");
            alert.setHeaderText(null);
            alert.setContentText("您是否要退出程序");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                exit();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

class numberPheRead {
    private String path;
    int number = 0;

    public numberPheRead(String path) throws IOException {
        this.path = path;
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path));
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber();
        number = lineNumber;
    }

}

class numberSNPRead {

    static int lineNumber = 0;
    int columNumber =0;

    public numberSNPRead(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while(reader.ready()) {
                lineNumber = lineNumber + 1;
                if (lineNumber == 1) {
                    String line = reader.readLine();
                    int columnNumber = line.length();
                    columNumber = (columnNumber + 1) / 2;
                }else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

