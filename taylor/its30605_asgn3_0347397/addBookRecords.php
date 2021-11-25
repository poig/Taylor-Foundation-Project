<?php

    require "connection.php";

    if ($_SERVER['REQUEST_METHOD']=='POST') { 

        if($_POST["bookname"] === "" ||$_POST["author"] === "") {
            ?>

            <script type="text/javascript">
                alert ("Invalid input! Please fill in all information.");
                window.location.href = 'borrow.php'
            </script>

            <?php
        } else { if ($_POST["bookname"] !== "") $id["bookname"]=($_POST["bookname"]);
            if ($_POST["author"] !== "") $id["author"]=($_POST["author"]);?><?php

    // Inserts new book records
    $id = array();
    if ($_POST["bookname"] !== "") $id["bookname"]=($_POST["bookname"]);
    if ($_POST["author"] !== "") $id["author"]=($_POST["author"]);
    
    $ava = "1";
    $empty = "-"; 

    $insert = "INSERT INTO bookDetails (`book_name`, `author`, `availability`, `date_returned`,  `date_borrowed`, `library_id`)
    VALUES ('" . $id['bookname'] . "', '" . $id['author'] . "', '$ava',' $empty',' $empty', '$empty')";

    if ($conn->query($insert) === TRUE) { ?>

        <script type="text/javascript">
            alert("<?=$id['bookname']; ?> has been added successfully!");
            window.location.href = 'bookDetails.php'
        </script>
    
        <?php 
    } else echo "Error: " . $insert . "<br>" . $conn->error;?>
        <script type="text/javascript">
            alert("<?=$id['bookname']; ?> has an error! ");
            //window.location.href = 'bookDetails.php'
        </script>
    <?php
    
    echo "Error: " . $insert . "<br>" . $conn->error;
?>