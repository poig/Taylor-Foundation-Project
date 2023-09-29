<?php
    session_start();

    if ($_SERVER["REQUEST_METHOD"]=="POST") {

        require "connection.php";

        $sql = "SELECT * FROM `users` WHERE `username` = '".$_POST['username']."' AND `password` = '" . $_POST['password'] ."';";
        $sql_run = $conn->query($sql);

        if ($sql_run) {

            if ($sql_run -> num_rows>0) {

                $row = $sql_run->fetch_assoc();

                $_SESSION['username'] = $row['username'];
                $_SESSION['name'] = $row['name'];

                header("Location: bookDetails.php" );

            } else header('Location: log_in.php?invalid=true');
            
        } else echo "Unable to run query: " . $conn->error;
    }
?>