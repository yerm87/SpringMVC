<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th>age</th>
        </tr>
        <#list users as user>
            <tr>
                <td><a href="/user?id=${user.id}">${user.id}</a></td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.age}</td>
                <td><a href="/edit_user?id=${user.id}">edit</a></td>
                <td><a href="/delete?id=${user.id}">delete</a></td>
            </tr>
        </#list>
    </table>
</body>
</html>