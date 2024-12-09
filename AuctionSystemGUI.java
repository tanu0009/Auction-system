import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AuctionSystemGUI extends JFrame {

    public AuctionSystemGUI() {
        // Set the title of the window
        setTitle("Auction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the window

        // Main panel with a custom gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                // Gradient background
                Color color1 = new Color(0, 4, 40);
                Color color2 = new Color(0, 78, 146);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        mainPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering elements
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to the Auction System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(welcomeLabel, gbc);

        // Register Button
        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        registerButton.addActionListener(e -> showRegisterScreen());
        gbc.gridy = 1;
        mainPanel.add(registerButton, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        loginButton.addActionListener(e -> showLoginScreen());
        gbc.gridy = 2;
        mainPanel.add(loginButton, gbc);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        styleButton(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridy = 3;
        mainPanel.add(exitButton, gbc);

        // Set the panel as the content pane
        setContentPane(mainPanel);
    }

    // Button styling method
    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(150, 40));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 78, 146));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(0, 78, 146), 2));
    }

    // Register screen
    private void showRegisterScreen() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setSize(300, 200);
        registerFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Username and password fields
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Please fill in all fields!");
            } else {
                showAlert("Success", "User registered successfully!");
                registerFrame.dispose();
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty space
        panel.add(submitButton);

        registerFrame.add(panel);
        registerFrame.setVisible(true);
    }

    // Login screen
    private void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Username and password fields
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Please fill in all fields!");
            } else {
                showAlert("Success", "Login successful!");
                loginFrame.dispose();
                showHomePage(); // Show the new home page after successful login
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty space
        panel.add(loginButton);

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    // Home page after login
    private void showHomePage() {
        JFrame homeFrame = new JFrame("Auction System - Home");
        homeFrame.setSize(400, 300);
        homeFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons for actions
        JButton listItemsButton = new JButton("List Items for Auction");
        styleButton(listItemsButton);
        listItemsButton.addActionListener(e -> showListItemsPage());

        JButton placeBidButton = new JButton("Place a Bid");
        styleButton(placeBidButton);
        placeBidButton.addActionListener(e -> showPlaceBidPage());

        JButton viewBidsButton = new JButton("View My Bids");
        styleButton(viewBidsButton);
        viewBidsButton.addActionListener(e -> showAlert("View Bids", "Functionality for viewing bids not implemented yet."));

        JButton logoutButton = new JButton("Logout");
        styleButton(logoutButton);
        logoutButton.addActionListener(e -> {
            homeFrame.dispose();
            showLoginScreen();
        });

        // Adding buttons to the panel
        panel.add(listItemsButton);
        panel.add(placeBidButton);
        panel.add(viewBidsButton);
        panel.add(logoutButton);

        homeFrame.add(panel);
        homeFrame.setVisible(true);
    }

    // List Items for Auction page
    private void showListItemsPage() {
        JFrame listItemsFrame = new JFrame("List Items for Auction");
        listItemsFrame.setSize(400, 300);
        listItemsFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Item information fields
        JLabel itemIdLabel = new JLabel("Item ID:");
        JTextField itemIdField = new JTextField();
        JLabel itemNameLabel = new JLabel("Name:");
        JTextField itemNameField = new JTextField();
        JLabel startingPriceLabel = new JLabel("Starting Price:");
        JTextField startingPriceField = new JTextField();
        JLabel highestBidLabel = new JLabel("Highest Bid:");
        JTextField highestBidField = new JTextField();

        // Back button
        JButton backButton = new JButton("Back");
        styleButton(backButton);
        backButton.addActionListener(e -> listItemsFrame.dispose());

        panel.add(itemIdLabel);
        panel.add(itemIdField);
        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(startingPriceLabel);
        panel.add(startingPriceField);
        panel.add(highestBidLabel);
        panel.add(highestBidField);
        panel.add(new JLabel()); // Empty space
        panel.add(backButton);

        listItemsFrame.add(panel);
        listItemsFrame.setVisible(true);
    }

    // Place a Bid page
    private void showPlaceBidPage() {
        JFrame placeBidFrame = new JFrame("Place a Bid");
        placeBidFrame.setSize(400, 200);
        placeBidFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Bid information fields
        JLabel itemIdLabel = new JLabel("Enter Item ID to bid on:");
        JTextField itemIdField = new JTextField();
        JLabel bidAmountLabel = new JLabel("Enter your bid amount:");
        JTextField bidAmountField = new JTextField();

        // Back button
        JButton backButton = new JButton("Back");
        styleButton(backButton);
        backButton.addActionListener(e -> placeBidFrame.dispose());

        panel.add(itemIdLabel);
        panel.add(itemIdField);
        panel.add(bidAmountLabel);
        panel.add(bidAmountField);
        panel.add(new JLabel()); // Empty space
        panel.add(backButton);

        placeBidFrame.add(panel);
        placeBidFrame.setVisible(true);
    }

    // Method to show alerts
    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuctionSystemGUI gui = new AuctionSystemGUI();
            gui.setVisible(true);
        });
    }
}
