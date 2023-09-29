<?php
    if(isset($_GET['invalid'])):
    ?>
        <script>
            alert("Credentials are invalid!")
        </script>
    <?php
    endif; 
?>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>login</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>

    <body>

        <h1>Log in</h1>

        <hr />
        <br />
        
        <form class="box" action="auth.php" method="post">
            
            <label for="username">Username</label>
            <br />
            <input type="number" name="username" placeholder="username" value="<?php echo isset($_POST['password']) ? $_POST['password'] : ''; ?>" autofocus/>
            <br />

            <label for="password">Password</label>
            <br />
            <input type="password" name="password" placeholder="password"/>
            <br />

            <input type="submit" name="Login" id="Login" value="Login" />

        </form>

    </body>
    
</html>