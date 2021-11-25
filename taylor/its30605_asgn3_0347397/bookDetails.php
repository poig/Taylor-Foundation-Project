<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Library Book Form</title>

        <link rel="stylesheet" href="css/bookdetails.css">
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
        
        <div>
            <h1>Book Records</h1>
            <button class="add" onclick="window.location.href = 'addBooks.php'">Add Books</button>
        </div>
        
        <table>
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Availability</th>
                <th>Date Borrowed</th>
                <th>Date Returned</th>
                <th>Library ID</th>
                <th>Action</th>
            </tr>

            <?php
                require "connection.php";
                
                $sql = "SELECT * FROM `bookdetails`;";
                $sql_run = $conn->query($sql);

                if($sql_run) {	
                    if($sql_run->num_rows > 0) {	
                        while($record = $sql_run->fetch_assoc()) {
            ?>

            <tr>
                <td name='book_id'><?= $record['book_id']; ?></td>
                <td name='book_name'><?= $record['book_name']; ?></td>
                <td name='author'><?= $record['author']; ?></td>
                <td name='availability'><?= $record['availability']; ?></td>
                <td name='date_borrowed'><?= $record['date_borrowed']; ?></td>
                <td name='date_returned'><?= $record['date_returned']; ?></td>
                <td name='library_id'><?= $record['library_id']; ?></td>
                <td>
                    <button class="edit" onclick="document.location.href='edit.php?book_id=<?= $record['book_id'];?>'">Edit</button>
                    <button class="edit" onclick="deleteConfirm(<?= $record['book_id'];?>);">Delete</button>
                </td>
            </tr>

            <?php
                        }
                    } else {
            ?>
            <tr><td colspan="8">No records found.</td></tr>
            <?php
                    }
                } else {
            ?>
            <tr><td colspan="8">Error retrieving table rows: <?= $conn->error; ?></td></tr>
            <?php
            }
        ?>

        </table>

        <br/>
        <hr/>
        <br/>

        <div class="br">
            <button class="edits" onclick="window.location.href = 'borrow.php'">Borrow</button>
            <button class="edits" onclick="window.location.href = 'return.php'">Return</button>
        </div>

        <br/> <br/> <br/> <br/> <br/> 

	</body>

</html>