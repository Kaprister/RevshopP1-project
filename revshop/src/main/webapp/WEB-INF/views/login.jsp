<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>
        :root {
            --background: #1a1a2e; /* fallback color */
            --color: #ffffff;
            --primary-color: #0f3460;
        }

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: "Poppins", sans-serif;
            background: url('image/background.jpg') no-repeat center center fixed; /* Set your background image */
            background-size: cover; /* Cover the entire background */
            color: var(--color);
            letter-spacing: 1px;
        }
        
        .video-background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            object-fit: cover; /* Cover the entire background */
            z-index: -1; /* Make sure the video is behind other elements */
        }

        .container {
            width: 90%;
            max-width: 400px;
            background: rgba(255, 255, 255, 0.1); /* Slightly transparent background */
            border-radius: 10px;
            padding: 2rem;
            backdrop-filter: blur(15px); /* Glass effect */
            box-shadow: 0 0 36px rgba(0, 0, 0, 0.2);
            margin: 2rem auto; /* Center the container */
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        label {
            margin-bottom: 0.5rem;
            display: block;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background: rgba(255, 255, 255, 0.2); /* Transparent input background */
            color: var(--color);
            font-size: 1rem;
            margin-top: 0.5rem;
            transition: background 0.2s;
        }

        input:focus,
        select:focus {
            background: rgba(255, 255, 255, 0.3); /* More opaque on focus */
            outline: none;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }

        button {
            background-color: var(--primary-color);
            color: var(--color);
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 1rem;
            transition: background 0.3s;
        }

        button:hover {
            background-color: darken(var(--primary-color), 10%);
        }

        .text-center {
            text-align: center;
            margin-top: 10px;
        }

        .error-message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<video class="video-background" autoplay muted loop>
        <source src="/video/registerbackground.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
        <div class="container">
            <div class="text-center">
                <h1>Login Here</h1>
            </div>
            <form action="user-register" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" name="email" placeholder="Enter email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Enter Password" required>
                </div>
                
                <div class="form-group">
                    <button type="submit">Login</button>
                </div>
                <div class="text-center">
                    <p>Don't have an account? <a href="/index">Register</a></p>
                </div>
            </form>
       
        </div>
</body>
</html>