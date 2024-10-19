package com.example.csc325_firebase_webview_auth.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AccessFBView {
    private FirebaseAuth mAuth;

    @FXML
    private TextField emailField; // New email field
    @FXML
    private TextField passwordField; // New password field

    // Initialize Firebase Auth in the constructor
    public AccessFBView() {
        mAuth = FirebaseAuth.getInstance();
    }

    // Handle user sign-in
    @FXML
    public void handleSignIn() {
        String email = emailField.getText(); // Get email from the text field
        String password = passwordField.getText(); // Get password from the text field
        
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome " + user.getEmail());
                } else {
                    showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password.");
                }
            });
    }

    // Show registration form
    @FXML
    public void showRegisterForm() {
        // Example code to show a registration form dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setHeaderText("Registration Form");
        alert.setContentText("This is where the registration form will be displayed.");
        alert.showAndWait();
    }

    // Display alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    // Placeholder for delete user functionality
    @FXML
    public void deleteUser() {
        // Implement delete user logic here
    }
    
    // Placeholder for showing about dialog
    @FXML
    public void showAbout() {
        // Implement about dialog logic here
    }
}
