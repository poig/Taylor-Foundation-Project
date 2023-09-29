<!--Updates book records based on edit button-->
<?php 
    if ($_SERVER['REQUEST_METHOD']=='POST') { 
        require "connection.php";

        $sql  ="UPDATE `bookdetails` SET `book_name` = ?, `author`=? WHERE `book_id` = ?;"; 

        $stmt = $conn -> prepare($sql);

        if ($stmt) {
            $id = intval($_POST['book_id']);
            
            $stmt -> bind_param("ssi", $_POST['book_name'], $_POST['author'], $id);

            if ($stmt -> execute()) {
                echo "Updated record with ID: " . $_POST['book_id'];
            } else echo "Error updating record #" . $_POST['book_id'] . " to table: " . $stmt-> error;

        } else echo "Unable to prepare statement: " . $conn-> error;
        
        $conn -> close();
    }

    header("Location: bookDetails.php")
?>