<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.webprogramming.emaillist.model.User" %>

<%
    User user =
            (User) request.getAttribute("user");

    if (user == null) {

        response.sendRedirect("index.jsp");

        return;
    }

    Boolean emailSent =
            (Boolean) request.getAttribute("emailSent");
%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Registration Successful</title>

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

            <h1>Email List</h1>

            <p>
                Your subscription has been processed successfully.
            </p>

        </div>


        <!-- BODY -->

        <div class="card-body">


            <!-- SUCCESS ICON -->

            <div class="success-icon">
                ✓
            </div>


            <h2 class="success-heading">
                You're all set!
            </h2>


            <p class="success-description">

                Thanks for joining our email list.
                Your registration has been completed successfully.

            </p>


            <!-- USER INFORMATION -->

            <div class="information-box">


                <div class="info-row">

                    <div class="info-label">
                        Email
                    </div>

                    <div class="info-value">
                        <%= user.getEmail() %>
                    </div>

                </div>


                <div class="info-row">

                    <div class="info-label">
                        First Name
                    </div>

                    <div class="info-value">
                        <%= user.getFirstName() %>
                    </div>

                </div>


                <div class="info-row">

                    <div class="info-label">
                        Last Name
                    </div>

                    <div class="info-value">
                        <%= user.getLastName() %>
                    </div>

                </div>


            </div>


            <!-- EMAIL STATUS -->

            <%
                if (Boolean.TRUE.equals(emailSent)) {
            %>

            <div class="email-success">

                <strong>✓ Confirmation email sent</strong>

                <br>

                We've sent a confirmation message to
                <strong><%= user.getEmail() %></strong>.

                Please check your inbox.

            </div>

            <%
            } else {
            %>

            <div class="email-warning">

                <strong>Registration successful</strong>

                <br>

                Your information has been saved,
                but we could not send the confirmation email.

            </div>

            <%
                }
            %>


            <p class="return-text">

                Want to register another email address?
                Return to the form below.

            </p>


            <form action="index.jsp" method="get">

                <button
                        type="submit"
                        class="primary-button">

                    Return to Registration

                </button>

            </form>


        </div>


        <!-- FOOTER -->

        <div class="card-footer">

            Thank you for joining our community.

        </div>


    </div>

</div>

</body>

</html>