<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <form name="user" action="/create" method="post">
            <div>
                <label for="name">Name</label>
                <input type="text" name="name" />
            </div>
            <div>
                <label for="email">Email</label>
                <input type="email" name="email" />
            </div>
            <div>
                <label for="age">Age</label>
                <input type="text" name="age" />
            </div>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>