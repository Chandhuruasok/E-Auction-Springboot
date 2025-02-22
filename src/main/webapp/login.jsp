<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Bidderboy Auction Website</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<style>
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

body {
    background-image: url('images/bidimage.jpg'); 
    background-size: cover;
    background-position: center;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

nav {
    background-color:rgb(50, 50, 167);
    overflow: hidden;
    top: 0;
    width: 100%;
    position: fixed;
    z-index: 1000; 
}

nav ul {
    list-style-type: none;
    display: flex;
    align-items: center;
}

nav ul li {
    flex: 1;
    height: 60px;
    width: auto;
    margin: 10px;
}



nav ul li a {
    display: block;
    color: white;
    text-align: center;
    padding: 15px 20px;
    text-decoration: none;
}

nav ul li a:hover {
    background-color: #111;
}

.container {
    background-color: rgba(255, 255, 255, 0.8);
    padding: 20px;
    width: 300px;
    margin: 100px auto;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-form h2 {
    text-align: center;
    margin-bottom: 30px;
}

.form-group {
    margin-top: 20px;
}

.form-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.form-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

button {
    width: 100%;
    padding: 10px;
    border: none;
    margin-top: 10px;
    background-color: rgb(50, 50, 167);
    color: white;
    font-size: 18px;
    cursor: pointer;
    border-radius: 5px;
}

button:hover {
    background-color: #4cae4c;
}

.redirect-text {
    text-align: center;
    margin-top: 15px;
}

.redirect-text a {
    color: blue;
    text-decoration: none;
}

.redirect-text a:hover {
    text-decoration: underline;
}

.foot {
    background-color: rgb(50, 50, 167);
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
}

.foot p {
    padding: 10px 0;
    color: white;
}
nav ul li h2 {
    color: white;
}

</style>
</head>
<body>
<nav>
    <ul>
    	<li><h2>BidderBoy</h2></li>
        
        <li><a href="homePage.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
        
        <li><a href="about.jsp"><i class="fas fa-info-circle"></i> About</a></li>
    </ul>
</nav>
<a href="homePage.jsp" class="previous">&laquo;previous</a>
<div class="container">
<% if (request.getAttribute("error") != null) { %>
        <div class="error-message"><%= request.getAttribute("error") %></div>
        <% } %>
    <form action="/login" method="post" class="login-form">
        <h2>Login Form</h2>
        
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required><br>
        </div>
        <div class="form-group">
            <label for="username">User Name</label>
            <input type="text" id="username" name="username" required><br>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&]).{5,}" required ><br>
        </div>

        <input type="hidden" name="action" value="login">
        <button type="submit">Login</button>
        <div class="redirect-text">
            <p>Don't have an account? <a href="register.jsp">Register</a></p>
        </div>
    </form>
</div>
<div class="foot">
    <footer>
        <p>&copy;2024 e-Auction. All rights reserved.</p>
    </footer>
</div>
</body>
</html>
