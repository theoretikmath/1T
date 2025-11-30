import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage mainwindow) throws IOException {
        mainwindow.setTitle("OneT");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        mainwindow.setScene(new Scene(root));
        mainwindow.show();
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println("tech");

    }
}