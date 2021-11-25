<?php
    require "connection.php";
    
   $bookRecords = "INSERT INTO `bookDetails` (`book_name`, `author`, `availability`, `date_borrowed`, `date_returned`, `library_id`) VALUES
   ('To Kill a Mockingbird','Harper Lee', '1', '-','-', '52'),
   ('The Great Gatsby','F. Scott Fitzgerald', '0', '2021-10-5','2021-10-10', '45'),
   ('The Catcher in the Rye','E. Michael Mitchell', '1', '-','-', '15'),
   ('Languages of Truth: Essays 2003-2020','Salman Rushdie', '0', '2021-10-10','2021-10-24', '63'),
   ('Skill It, Kill It','Ronnie Screwvala', '0', '2021-9-10','2021-9-24', '33'),
   ('Home in the World','Amartya Sen', '1', '-','-', '22'),
   ('Pride and Prejudice','Jane Austen', '0', '2021-7-10','2021-7-24', '13'),
   ('Beloved','Toni Morrison', '1', '-','-', '14'),
   ('Monk in a Merc','Ashok Pangariya','1', '-','-', '24'),
   ('The 7 Sins of Being a Mother','Tahira Kashyap Khurrana', '0', '2021-4-19','2021-5-2', '73'),
   ('Habba Khatoon','Kajal Suri', '0', '2021-10-10','2021-10-24', '33'),
   ('What is Consciousness?','Dr Vipin Gupta','1', '-','-', '29'),
   ('What is Para Consciousness?','Dr Vipin Gupta', '0', '2021-6-13','2021-6-27', '43'),
   ('The Christmas Pig','Jane Austen', '0', '2021-10-10','2021-10-24', '23'),
   ('Karunanidhi: A Life','AS Pannerselvan', '0', '2021-6-17','2021-6-24', '31'),
   ('Hunchprose','Ranjit Hoskote','1', '-','-', '22'),
   ('Undertow','Jahnavi Barua', '0', '2021-7-15','2021-7-29', '23'),
   ('My Experiments with Silence','Samir Soni', '1', '-','-', '52'),
   ('Yearbook','Seth Rogen', '0', '2021-8-13','2021-8-27', '13'),
   ('Seth Rogen','Priyanka Chopra Jonas', '1', '-','-', '20');";

   $borrowRecords = "INSERT INTO `borrowBooks` (`library_id`, `book_id`, `book_name`, `author`,`date_borrowed`, `date_toreturn`) VALUES
   ('001','1','To Kill a Mockingbird','Harper Lee', '2021-10-15','2021-10-29'),
   ('002','3','The Catcher in the Rye','E. Michael Mitchell', '2021-10-10','2021-10-24');";

   $returnRecords = "INSERT INTO `returnBooks` (`library_id`, `book_id`, `book_name`, `author`) VALUES
   ('005', '1', 'The Great Gatsby','F. Scott Fitzgerald'),
   ('003', '4', 'Pride and Prejudice','Jane Austen'),
   ('004', '5', 'Beloved','Toni Morrison');";

   $usersRecords ="INSERT INTO `users` (`username`,`password`) VALUES
   ('101010', 'happypeople'),
   ('202020', 'ilovecomputing'),
   ('303030', 'markspls'),
   ('404040', 'mrhenrydabest');";

    if ($conn->query($returnRecords)) {
        echo "returnRecords added successfully!";
    } else {
        echo "<br>Error adding return records: " . $conn -> error;
    }

    if ($conn->query($bookRecords)) {
        echo "<br>bookRecords added successfully!";
    } else {
        echo "<br>Error adding book records: " . $conn -> error;
    }

    if ($conn->query($borrowRecords)) {
        echo "<br>borrowRecords added successfully!";
    } else {
        echo "<br>Error adding borrowed records: " . $conn -> error;
    }

    if ($conn->query($usersRecords)) {
        echo "<br>usersRecords added successfully!";
    } else {
        echo "<br>Error adding users records: " . $conn -> error;
    }


   $conn -> close()
   
?>