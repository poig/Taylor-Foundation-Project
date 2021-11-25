<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Library Book Form</title>
        <link rel="stylesheet" href="css/Form.css">
        <link rel="stylesheet" href="css/bookdetails.css">
        <link rel="stylesheet" href="css/nav.css">
        <script src="javascript/autodetails.js"></script>
        <script src="box/alertbox.js"></script>
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
        
        <h1>Return Form</h1>

        <form action="returnupdate.php" method="post">
            <table>
                <tr>
                    <th>Library ID</th> 
                    <td><input type="number" id="lID" name="lID"></td>
                </tr>
                
                <tr>
                    <th>Book ID</th> 
                    <td><input type="number" id="bID" name="bID" onkeyup="GetDetails(this.value)"></td>
                </tr>

                <tr>
                    <th>Book Name</th>
                    <td><input type="text" id="bookname" name="bookname" readonly></td>
                </tr>

                <tr>
                    <th>Author</th>
                    <td><input type="text" id="author" name="author" readonly></td>
                </tr>

                <tr >
                    <td colspan="2" class="bottom">
                    <input type="submit" value="Submit" class="button" name="submit" value="submit" onsubmit="submit()">
                    &nbsp; &nbsp; &nbsp; &nbsp; 
                    <input type="reset" class="button">
                    </td>      
                </tr>
                
            </table>
        </form>    
    </body>
</html>



