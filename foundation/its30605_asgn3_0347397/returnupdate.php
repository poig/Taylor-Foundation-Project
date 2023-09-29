<?php 
    require "connection.php";

    if ($_SERVER['REQUEST_METHOD']=='POST') { 
        
        if($_POST["lID"] === "" || $_POST["bID"] === "" || $_POST["bookname"] === "" || $_POST["author"] === "" ) {
            
            ?>
            <script type="text/javascript">
                alert ("Invalid input! Please fill in all information.");
                window.location.href = 'return.php'
            </script>
            
            <?php
            
        } else {
            
            // Updates bookdetails table based on return form
            $sql  ="UPDATE `bookdetails` SET  `availability`= ?, `date_borrowed` = ?, `date_returned`= ?,  `library_id`= ? WHERE `book_id` = ?;"; 
            $ava = "1";
            $date = " - "; 
            $stmt = $conn -> prepare($sql);

            if ($stmt) {
                $bID = intval($_POST['bID']);
                $lID = intval($_POST['lID']);
                
                $stmt -> bind_param("issii", $ava, $date, $date, $lID, $bID);

                if ($stmt -> execute()) {
                    echo "Updated record with ID: " . $bID;
                } else echo "Error updating record #" . $bID . " to table: " . $stmt-> error;

            } else echo "Unable to prepare statement: " . $conn-> error;

            // Inserts new data entry if inputs are field (doesnt display on webpage)
            $id = array();
            if ($_POST["lID"] !== "") $id["lID"]=($_POST["lID"]);
            if ($_POST["bID"] !== "") $id["bID"]=($_POST["bID"]);
            if ($_POST["bookname"] !== "") $id["bookname"]=($_POST["bookname"]);
            if ($_POST["author"] !== "") $id["author"]=($_POST["author"]);

            $insert = "INSERT INTO returnBooks (library_id, book_id, book_name, author)
            VALUES (" . $id['lID'] . ", " . $id['bID'] . ", '" . $id['bookname'] . "', '" . $id['author'] . "')";
            
            if ($conn->query($insert) === TRUE) { ?>

                <script type="text/javascript">
                    alert("<?=$id['bookname']; ?> for id <?=$id["lID"];?> has been returned successfully!");
                    window.location.href = 'bookDetails.php'
                </script>
        
            <?php 
            } else echo "Error: " . $insert . "<br>" . $conn->error;
            
        }
        
        $conn->close();
    }
?>