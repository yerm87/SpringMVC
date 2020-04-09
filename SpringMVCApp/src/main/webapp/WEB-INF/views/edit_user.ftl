<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <form name="user" action="/update" method="post">
            <input type="hidden" value="${user.id}" name="id" />
            <div>
                <label for="name">Name</label>
                <input type="text" name="name" value="${user.name}" />
            </div>
            <div>
                <label for="email">Email</label>
                <input type="email" name="email" value="${user.email}" />
            </div>
            <div>
                <label for="age">Age</label>
                <input type="text" name="age" value="${user.age}" />
            </div>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>