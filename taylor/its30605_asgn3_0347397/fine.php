<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fines</title>
        <link rel="stylesheet" href="css/fines.css">
        <link rel="stylesheet" href="css/nav.css">
        <script src="javascript/autodetails.js"></script>
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

        <h1>Fines </h1>

        <table>
            <tr>
                <th>LIBRARY ID</th>
                <th>FINE</th>
            </tr>

            <?php
            
                require "connection.php";

                $ava = "SELECT `availability`, `date_returned`, `library_id` FROM `bookdetails` WHERE `availability` = '0'";
                $ava_result = $conn->query($ava);

                if($ava_result->num_rows>0) {	 

                    while($fines = $ava_result->fetch_assoc()) {

                        $dateReturn = DateTime::createFromFormat('Y-m-d',$fines['date_returned']);
                        $dateTdy = new DateTime(date('Y-m-d')); 
                        $overdue = $dateReturn -> diff($dateTdy);
                        $diffInDays = $overdue -> d;
                        $totalFine = $diffInDays * 1;

                        $insert = "INSERT INTO fines (library_id, fines)
                        VALUES (" . $fines['library_id']. ", " . $totalFine . ")";

                        if ($conn->query($insert) === TRUE)
                        ?>
                        
                        <tr>
                            <td name='library_id'><?= $fines['library_id']; ?></td>
                            <td name='fines'>RM<?= $totalFine ?>.00</td>
                        </tr>

                        <?php
                    }

                } else { ?>

                    <tr>
                        <td colspan='2'>No records found</td>
                    </tr>

                    <?php 
                } 
            ?>
        </table>
    </body>
</html>
