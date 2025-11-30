
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;

public class LoginController {

    // --- Sekme ve Panel Tanımlamaları ---
    @FXML private VBox studentTabButton;
    @FXML private VBox teacherTabButton;
    @FXML private VBox adminTabButton;
    @FXML private AnchorPane studentLoginPane;
    @FXML private AnchorPane teacherLoginPane;
    @FXML private AnchorPane adminLoginPane;

    // --- Student Form Elemanları (Güncellendi) ---
    @FXML private TextField studentUsernameField;
    @FXML private ComboBox<String> studentLessonComboBox; // PasswordField yerine bu geldi
    @FXML private Button studentLoginButton;

    // --- Teacher Form Elemanları ---
    @FXML private TextField teacherUsernameField;
    @FXML private PasswordField teacherPasswordField;
    @FXML private Button teacherLoginButton;

    // --- Admin Form Elemanları ---
    @FXML private TextField adminUsernameField;
    @FXML private PasswordField adminPasswordField;
    @FXML private Button adminLoginButton;

    // Yardımcı listeler
    private List<Node> loginPanes;
    private List<Node> tabButtons;

    @FXML
    public void initialize() {
        loginPanes = Arrays.asList(studentLoginPane, teacherLoginPane, adminLoginPane);
        tabButtons = Arrays.asList(studentTabButton, teacherTabButton, adminTabButton);

        // --- YENİ EKLENDİ: ComboBox'ı derslerle doldur ---
        studentLessonComboBox.setItems(FXCollections.observableArrayList(
                "Math",
                "Physics",
                "Chemistry",
                "Biology",
                "Literature",
                "Deutsch"
        ));

        // Varsayılan olarak Student sekmesini aktif yap
        setActiveTab(studentTabButton);
    }

    @FXML
    private void handleTabClick(MouseEvent event) {
        Node clickedTab = (Node) event.getSource();
        setActiveTab(clickedTab);
    }

    private void setActiveTab(Node activeTab) {
        for (Node pane : loginPanes) pane.setVisible(false);
        for (Node tab : tabButtons) {
            tab.getStyleClass().remove("tab-active");
            tab.getStyleClass().add("tab-inactive");
        }

        if (activeTab == studentTabButton) {
            studentLoginPane.setVisible(true);
            studentTabButton.getStyleClass().remove("tab-inactive");
            studentTabButton.getStyleClass().add("tab-active");
        } else if (activeTab == teacherTabButton) {
            teacherLoginPane.setVisible(true);
            teacherTabButton.getStyleClass().remove("tab-inactive");
            teacherTabButton.getStyleClass().add("tab-active");
        } else if (activeTab == adminTabButton) {
            adminLoginPane.setVisible(true);
            adminTabButton.getStyleClass().remove("tab-inactive");
            adminTabButton.getStyleClass().add("tab-active");
        }
    }

    // --- Giriş Butonu Aksiyonları (Student metodu güncellendi) ---

    @FXML
    void handleStudentLogin(ActionEvent event) {
        String username = studentUsernameField.getText();
        String selectedLesson = studentLessonComboBox.getValue(); // Şifre yerine seçilen dersi al

        System.out.println("Student Login Tıklandı!");
        System.out.println("Kullanıcı Adı: " + username);
        System.out.println("Seçilen Ders: " + selectedLesson);

        // --- BURAYA STUDENT GİRİŞ KONTROL KODUNUZU EKLEYİN ---
        if (username.isEmpty() || selectedLesson == null) {
            System.out.println("Hata: Kullanıcı adı ve ders seçimi zorunludur!");
            // Burada kullanıcıya bir hata mesajı gösterebilirsiniz (opsiyonel)
        } else {
            // Test başlatma işlemleri...
        }
    }

    @FXML
    void handleTeacherLogin(ActionEvent event) {
        String username = teacherUsernameField.getText();
        String password = teacherPasswordField.getText();
        System.out.println("Teacher Login Tıklandı!");
        System.out.println("Kullanıcı Adı: " + username);
        System.out.println("Şifre: " + password);
        // --- BURAYA TEACHER GİRİŞ KONTROL KODUNUZU EKLEYİN ---
    }

    @FXML
    void handleAdminLogin(ActionEvent event) {
        String username = adminUsernameField.getText();
        String password = adminPasswordField.getText();
        System.out.println("Admin Login Tıklandı!");
        System.out.println("Kullanıcı Adı: " + username);
        System.out.println("Şifre: " + password);
        // --- BURAYA ADMIN GİRİŞ KONTROL KODUNUZU EKLEYİN ---
    }
}