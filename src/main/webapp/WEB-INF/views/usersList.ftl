<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>
    <h1>Users List</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>

        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
        </tr>
        </#list>
        </table>
    <a href="/addUser">Add new user</a>
</body>
</html>