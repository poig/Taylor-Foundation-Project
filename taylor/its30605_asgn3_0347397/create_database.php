<?php
    $servername = "localhost";
    $username = "root";
    $password = "";

    $conn = new mysqli($servername, $username, $password);

    if ($conn -> connect_error) {
        die ("Connection failed: " + $conn -> connect_error);
    }

    echo "Connected successfully<br>";

    $library = "CREATE DATABASE `library_db`;";
    
    if ($conn->query($library)) {
        echo "Database created successfully!";
    } else {
        echo "Error creating library database:" + $conn -> error;
    }

    $conn-> close();

?>