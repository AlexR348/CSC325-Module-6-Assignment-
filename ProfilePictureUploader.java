import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import javafx.stage.FileChooser;
import java.io.File;

public class ProfilePictureUploader {

    private StorageReference storageRef;

    public ProfilePictureUploader() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }

    public void uploadProfilePicture() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            StorageReference profilePicRef = storageRef.child("profilePictures/" + file.getName());
            UploadTask uploadTask = profilePicRef.putFile(file.toURI());
            
            uploadTask.addOnSuccessListener(taskSnapshot -> {
                System.out.println("Profile picture uploaded successfully.");
            }).addOnFailureListener(e -> {
                System.out.println("Failed to upload profile picture: " + e.getMessage());
            });
        }
    }
}
