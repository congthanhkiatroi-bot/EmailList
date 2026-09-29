<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Join Our Email List</title>

    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="page">

    <div class="card">

        <!-- HEADER -->

        <div class="card-header">

            <div class="logo-box">
                ✉
            </div>

            <h1>Join our email list</h1>

            <p>
                Stay connected with us and receive the latest
                news, updates, and useful information directly
                in your inbox.
            </p>

        </div>


        <!-- BODY -->

        <div class="card-body">

            <h2 class="section-title">
                Create your subscription
            </h2>

            <p class="section-description">
                Enter your information below to join our email list.
                It only takes a few seconds.
            </p>


            <%
                String errorMessage =
                        (String) request.getAttribute("errorMessage");

                if (errorMessage != null) {
            %>

            <div class="error-message">
                <strong>Registration failed.</strong>
                <br>
                <%= errorMessage %>
            </div>

            <%
                }
            %>


            <form action="emailList" method="post">


                <!-- EMAIL -->

                <div class="form-group">

                    <label for="email">
                        Email address
                    </label>

                    <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder="example@gmail.com"
                            required>

                </div>


                <!-- FIRST NAME -->

                <div class="form-group">

                    <label for="firstName">
                        First name
                    </label>

                    <input
                            type="text"
                            id="firstName"
                            name="firstName"
                            placeholder="Enter your first name"
                            required>

                </div>


                <!-- LAST NAME -->

                <div class="form-group">

                    <label for="lastName">
                        Last name
                    </label>

                    <input
                            type="text"
                            id="lastName"
                            name="lastName"
                            placeholder="Enter your last name"
                            required>

                </div>


                <!-- BUTTON -->

                <button
                        type="submit"
                        class="primary-button">

                    Join the Email List

                </button>

            </form>

        </div>


        <!-- FOOTER -->

        <div class="card-footer">

            Your information will only be used
            for this email subscription.

        </div>

    </div>

</div>

</body>

</html>