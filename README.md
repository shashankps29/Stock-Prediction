Stock Price Prediction System

A JavaFX-based application that predicts stock prices using machine learning (Weka) and displays data with an intuitive and modern UI. Built with Java, SQLite, JDBC, and JavaFX, this project combines data visualization with predictive modeling to showcase skills in software development, database management, and machine learning integration.

Features

Add & manage stocks – store stock data (name, date, closing price) in a SQLite database.

View stocks – clean UI with charts and tables for better analysis.

Predict prices – integrated machine learning module (Weka) for forecasting.

Modern UI/UX – gradient backgrounds and card-based design to enhance usability.

Navigation system – switch seamlessly between Home, Add Stock, View Stocks, and Predict screens.

Tech Stack

Java (Core, OOP, Collections, Multithreading)

JavaFX (UI/UX with charts and views)

SQLite + JDBC (database integration)

Weka ML Library (machine learning for stock prediction)

Project Structure
application/
 ├── controller/      # Handles UI events
 ├── dao/             # Data Access Objects for DB operations
 ├── model/           # Stock models/entities
 ├── service/         # Business logic and ML integration
 ├── utils/           # Database connector, initializers
 ├── view/            # FXML files (UI screens)
 ├── Main.java        # Entry point

Getting Started




Set up SQLite (the table initializes automatically with SQLiteInitializer).

Run the project in your IDE (IntelliJ, Eclipse, or VS Code with JavaFX support).

Future Enhancements

Add more ML models for improved accuracy

Import/export stock data using CSV or Excel

Add authentication for multiple users

Package and deploy as a standalone desktop application
License

This project is open-source under the MIT License.
