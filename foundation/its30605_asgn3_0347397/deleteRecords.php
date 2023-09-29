<!-- Deletes records upon clicking  --->
<?php
    if (isset($_GET['book_id'])) {

        require 'connection.php';

        $sql = "DELETE FROM `bookdetails` WHERE `book_id` = ?;";
        $stmt = $conn -> prepare ($sql);

        if ($stmt) {
            $stmt -> bind_param ("i", $_GET['book_id']);

            if ($stmt -> execute()) {
                echo "Deleted record with ID: " . $_GET['book_id'];

            } else echo "Unable to delete record #" . $_GET['book_id'] . ": " . $stmt -> error;

        } else echo "Unable to prepare statement: " . $conn -> error;

    } header('Location:bookDetails.php')

?>