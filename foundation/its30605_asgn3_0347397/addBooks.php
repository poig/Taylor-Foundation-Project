<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Books</title>
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

        <h1>Add Book Records</h1>
        
        <form action="addBookRecords.php" method="POST">

            <table>

                <tr>
                    <th>Book Name</th>
                    <td><input type="text" name="bookname"></td>
                </tr>

                <tr>
                    <th>Author</th>
                    <td><input type="text" name="author"></td>
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