<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Covid Tracker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Covid-19 Tracker</h1>
        <p class="lead">This is a simple application, that list the current number of cases reported across the globe.</p>
        <hr class="my-4">
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" th:text="${totalReportedCase}"></h1>
                <p class="lead"> Total Covid-19 cases as per of today</p>

                <p>
                    <span class="display-4" th:text="${totalNewReportedCase}"></span>
                    <span>     Total new cases</span>
                </p>
            </div>
        </div>
        <form action="saveUser" method="post">
            <table>
                <tr>
                    <td><label>User Name</label></td>
                    <td><input type="text" name="name"></input></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></input></td>
                </tr>
            </table>
        </form>
        <table>
            <tr>
                <td><h4>User Name: </h4></td>
                <td><h4 th:text="${searchboxcountry}"></h4></td>
            </tr>
        </table>
        <br><br>

    </div>

    <table class="table table-striped table-hover">
        <tr class="table-dark">
            <th>State</th>
            <th>Country</th>
            <th>Current Total Cases</th>
            <th>New Cases</th>
        </tr>
        <tr th:each="loop : ${locationStats}">
            <td th:text="${loop.state}"></td>
            <td th:text="${loop.country}"></td>
            <td th:text="${loop.latestDateCase}"></td>
            <td th:text="${loop.diffOfCase}"></td>
        </tr>
    </table>
</div>

</body>

</html>