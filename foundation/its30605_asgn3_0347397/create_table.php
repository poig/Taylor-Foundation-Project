<?php
    require "connection.php";

    $bookDetails = "CREATE TABLE IF NOT EXISTS `bookDetails` (
        `book_id`           INT NOT NULL AUTO_INCREMENT,
        `book_name`         VARCHAR(1000) NOT NULL,
        `author`            VARCHAR(1000) NOT NULL,
        `availability`      BOOLEAN NOT NULL,
        `date_borrowed`     VARCHAR(100) NOT NULL,
        `date_returned`     VARCHAR(100) NOT NULL,
        `library_id`        INT NOT NULL, 

    PRIMARY KEY(`book_id`)
    );";

    $borrowBooks = "CREATE TABLE IF NOT EXISTS `borrowBooks` (
        `library_id`        INT NOT NULL, 
        `book_id`           INT NOT NULL,
        `book_name`         VARCHAR(1000) NOT NULL,
        `author`            VARCHAR(1000) NOT NULL,
        `date_borrowed`     VARCHAR(100) NOT NULL,
        `date_toreturn`     VARCHAR(100) NOT NULL
    
    );";

    $returnBooks = "CREATE TABLE IF NOT EXISTS `returnBooks` (
        `library_id`        INT NOT NULL,
        `book_id`           INT NOT NULL,
        `book_name`         VARCHAR(1000) NOT NULL,
        `author`            VARCHAR(1000) NOT NULL
        
    );";

    $users = "CREATE TABLE IF NOT EXISTS `users` (
        `username`      VARCHAR(50) NOT NULL,
        `password`      VARCHAR(100) NOT NULL
        
    );";


    if ($conn->query($bookDetails)) {
        echo "bookDetails table created successfully!<br>";
    } else {
        echo "Error creating bookDetails table: " . $conn -> error;
    }

    if ($conn->query($borrowBooks)) {
        echo "borrowBooks table created successfully!<br>";
    } else {
        echo "Error creating borrowBooks table: " . $conn -> error;
    }

    if ($conn->query($returnBooks)) {
        echo "returnBooks table created successfully!<br>";
    } else {
        echo "Error creating returnBooks table: " . $conn -> error;
    }

    if ($conn->query($users)) {
        echo "users table created successfully!<br>";
    } else {
        echo "Error creating users table: " . $conn -> error;
    }

    $conn -> close()
?>

