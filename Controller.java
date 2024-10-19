import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Pane splashPane;

    @FXML
    private ImageView splashImage;

    @FXML
    public void initialize() {
        // Load the splash image
        Image image = new Image("path/to/your/image.png");
        splashImage.setImage(image);
        
        // Show splash screen initially
        splashPane.setVisible(true);
    }
    @FXML
public void closeApp() {
    Stage stage = (Stage) yourMenuBar.getScene().getWindow();
    stage.close();
}

public void showRegisterForm() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/RegisterForm.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void hideSplashScreen() {
        splashPane.setVisible(false);
    }
}
