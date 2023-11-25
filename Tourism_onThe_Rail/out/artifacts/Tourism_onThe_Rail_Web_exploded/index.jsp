<html lang="en">
<head>
    <link rel="icon" href= image/free-icon-picture-9035018.ico>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tourism on The Rail</title>
    <link rel="stylesheet" href="index.css">

</head>
<body>
<header>

    <h1>Tourism on The Rail</h1>
</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="Contact.html">Contact</a>
    <a href="About.html">About Us</a>
    <a href="Sign.html">Sign Up</a>
</nav>

<section>
    <h2>Welcome to Tourism on The Rail</h2>
    <p>Explore the beauty of destinations via our comfortable trains. Plan your journey with us!</p>
    <div class="info-block" style="background: linear-gradient(to right, rgba(255,230,230,0.29), #99c2ff)">
        <h3>Why Choose Us?</h3>
        <p>We are committed to providing the best travel experience. Here are some reasons to choose Tourism on The Rail:</p>
        <ul>
            <li>Comfortable and modern trains</li>
            <li>Scenic routes to beautiful destinations</li>
            <li>Excellent customer service</li>
            <li>Flexible travel options</li>
        </ul>
    </div>
    <div class="email-input">
        <h3>Leave your feedback</h3>
        <form action="${pageContext.request.contextPath}/submit-feedback" method="post">
            <label>
                Email:
                <input type="email" name="email" placeholder="Enter your email" style="width: 10%;">
            </label>

            <label>
                Message:
                <textarea name="message" placeholder="Enter your message" style="width: 50%"></textarea>
            </label>

            <button type="submit">Submit Feedback</button>
        </form>
    </div>
</section>

<footer>
    &copy; 2023 Tourism on The Rail. All rights reserved.
</footer>
</body>
</html>
