<?php
    $ID = $_REQUEST ['ID'];
    $con = mysqli_connect("localhost", "root", "", "library_db");
    
    if ($ID!=="") {
        $query = mysqli_query($con, "SELECT * FROM `bookdetails` WHERE book_id ='$ID'");
        $row = mysqli_fetch_array($query);
        $book_name = $row["book_name"];
        $author = $row["author"];
    }

    $result = array("$book_name", "$author");
    $myJSON = json_encode($result);
    echo $myJSON;
?>