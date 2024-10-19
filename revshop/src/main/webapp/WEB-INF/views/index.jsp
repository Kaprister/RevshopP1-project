<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RevShop</title>
    <style>
       body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-image: url('/images/indexback.jpg'); /* Correct path */
    background-size: cover; /* Ensures the image covers the entire background */
    background-position: center; /* Centers the image */
}



        h1 {
            font-size: 3em;
            margin-bottom: 0.5em;
            color: #2c3e50;
        }

        h2 {
            font-size: 1.5em;
            margin-bottom: 2em;
            color: #7f8c8d;
        }

        form {
            margin: 0.5em;
        }

        button {
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 1.2em;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2980b9;
        }

        @media (max-width: 600px) {
            h1 {
                font-size: 2.5em;
            }

            h2 {
                font-size: 1.2em;
            }

            button {
                font-size: 1em;
                padding: 8px 16px;
            }
        }
    </style>
</head>
<body>
    <h1 style="color:white;">Welcome to RevShop</h1>
    <h2 style="color:white;">Please select an option:</h2>
    
    <form action="/register/buyer" method="get">
        <button type="submit">Register Buyer</button>
    </form>
    
    <form action="/register/seller" method="get">
        <button type="submit">Register Seller</button>
    </form>
</body>
</html>
