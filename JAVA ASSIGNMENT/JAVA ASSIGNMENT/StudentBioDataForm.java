import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentBioDataForm extends Frame implements ActionListener {
    private TextField nameField, ageField, genderField;
    private Button saveButton;
    private Connection connection;
    private Statement statement;

    public StudentBioDataForm() {
        setTitle("Student Bio-data Form");
        setSize(400, 200);
        setLayout(new FlowLayout());

        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label genderLabel = new Label("Gender:");

        nameField = new TextField(30);
        ageField = new TextField(10);
        genderField = new TextField(10);

        saveButton = new Button("Save");
        saveButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(genderField);
        add(saveButton);

        try {
          
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password"); 
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == saveButton) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();

            try {
               
                String insertQuery = "INSERT INTO student_info (name, age, gender) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, gender);
                preparedStatement.executeUpdate();

            
                nameField.setText("");
                ageField.setText("");
                genderField.setText("");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentBioDataForm form = new StudentBioDataForm();
        form.setVisible(true);
    }
}
