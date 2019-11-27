<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <h1>РЕГИСТРАЦИЯ</h1>
    <br>
    <form action="/signUp" method="post">
        <input name="email" placeholder="Email">
        <br>
        <input name="password" type="password" placeholder="Password">
        <br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>