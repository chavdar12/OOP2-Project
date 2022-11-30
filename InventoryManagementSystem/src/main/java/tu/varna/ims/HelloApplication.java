package tu.varna.ims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        URL url = Paths.get("src/main/resources/tu/varna/ims/presentation/Registration/RegisterView.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 1600, 900);
        stage.setTitle("IMS");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}