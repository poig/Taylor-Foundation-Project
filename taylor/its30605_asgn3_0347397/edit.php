<?php
    if (isset($_GET['book_id'])) {
        
        require "connection.php";

        $sql ="SELECT * FROM `bookdetails` WHERE `book_id` = " .$_GET['book_id'] .";";
        $sql_run = $conn -> query ($sql);

        if ($sql_run) {

            if ($sql_run -> num_rows > 0) {

                $record= $sql_run -> fetch_assoc();

            } else echo "No record found for ID: " . $_GET['book_id'];

        } else echo "Error retrieving records: " . $conn -> error;

    } 
?>
                   
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Records</title>
        <link rel="stylesheet" href="css/Form.css">
        <link rel="stylesheet" href="css/bookdetails.css">
        <link rel="stylesheet" href="css/nav.css">
    </head>

    <body>
        <nav>
            <div class="logo">LIBRARY SYSTEM</div>
            <ul id="nav-links">
                <li><button id="link" onclick="window.location.href = 'about_page.html'">About Us</button></li>
                <li><button id="link" onclick="window.location.href = 'bookDetails.php'">Book Records</button></li>
                <li><button id="link" onclick="window.location.href = 'fine.php'">Fines</button></li>
                <li><button class="logout" onclick="window.location.href = 'logout.php'" id="Login">Log out</button></li>
            </ul>
        </nav>

        <h1>Update Book Records</h1>
        
        <form action="updateRecord.php" method="POST">
            
            <input type ="hidden" name="book_id" value = "<?= $_GET['book_id']?>">

            <table>

                <tr class="headerrow">
                    <th colspan="2">Book ID: <?= $_GET['book_id'] ?></th>
                </tr>

                <tr>
                    <th>Book Name</th>
                    <td><input type="text" id="bookname" name="book_name" 
                    <?php
                        if (isset($_GET['book_id'])) {
                            ?>value = "<?= $record['book_name'] ?>" <?php }
                    ?>></td>
                </tr>

                <tr>
                    <th>Author</th>
                    <td><input type="text" id="author" name="author"
                    <?php
                        if (isset($_GET['book_id'])) {
                            ?>value = "<?= $record['author'] ?>" <?php }
                    ?>></td>
                </tr>

                <tr >
                    <td colspan="2" class="bottom">
                        <input type="submit" class="button">
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="reset" class="button">
                    </td>
                </tr>

            </table>

        </form>
       
    </body>

</html>
