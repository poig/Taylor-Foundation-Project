<?php   
    require "connection.php";

    if ($_SERVER['REQUEST_METHOD']=='POST') { 

        if($_POST["lID"] === "" ||$_POST["bID"] === "" || $_POST["bookname"] === "" || $_POST["author"] === ""  || $_POST["dBorrowed"] === "" || $_POST["dReturned"] === "") {
            ?>

            <cript type="text/javascript">
               s alert ("Invalid input! Please fill in all information.");
                window.location.href = 'borrow.php'
            </script>

            <?php
        } else {

             // Updates bookrecords upon submission of borrow form
            $sql  ="UPDATE `bookdetails` SET  `availability`= ?, `date_borrowed` = ?, `date_returned`= ?,  `library_id`= ? WHERE `book_id` = ?;"; 
            $ava = "0";
            $stmt = $conn -> prepare($sql);
            
            if ($stmt) {

                $bID = intval($_POST['bID']);
                $lID = intval($_POST['lID']);
                
                $stmt -> bind_param("issii", $ava, $_POST["dBorrowed"], $_POST["dReturned"], $lID, $bID);

                if ($stmt -> execute()) {

                    echo "Updated record with ID: " . $bID;

                } else echo "Error updating record #" . $bID . " to table: " . $stmt-> error;

            } else echo "Unable to prepare statement: " . $conn-> error;

            // Inserts inputs from borrow form into table
            $id = array();

            if ($_POST["lID"] !== "") $id["lID"]=($_POST["lID"]);
            if ($_POST["bID"] !== "") $id["bID"]=($_POST["bID"]);
            if ($_POST["bookname"] !== "") $id["bookname"]=($_POST["bookname"]);
            if ($_POST["author"] !== "") $id["author"]=($_POST["author"]);
            if ($_POST["dBorrowed"] !== "") $id["date_borrowed"]=($_POST["dBorrowed"]);
            if ($_POST["dReturned"] !== "") $id["date_toreturn"]=($_POST["dReturned"]);

            $insert = "INSERT INTO borrowbooks (library_id, book_id, book_name, author, date_borrowed, date_toreturn)
            VALUES (" . $id['lID'] . ", " . $id['bID'] . ", '" . $id['bookname'] . "', '" . $id['author'] . "', '" . $id['date_borrowed'] . "', '" . $id["date_toreturn"] . "')";

            if ($conn->query($insert) === TRUE) { ?>

                <script type="text/javascript">
                    alert("<?=$id['bookname']; ?> for id <?=$id["lID"];?> has been borrowed successfully!");
                    window.location.href = 'bookDetails.php'
                </script>
            
                <?php 
            } else echo "Error: " . $insert . "<br>" . $conn->error;
        }

        $conn->close();
    } 

?>
                    