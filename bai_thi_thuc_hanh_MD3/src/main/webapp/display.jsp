
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 style="color: red"><a href="student-servlet">List Student</a></h1>
    <a class="btn btn-primary" href="student-servlet?action=create">Create student</a>
    <form action="student-servlet?action=searchByName" method="post">
        <input type="text" name="search"  placeholder="Search....">
        <input  class="btn btn-primary" type="submit" value="Search"></input>
    </form>
    <br><br>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Classroom</th>
            <th colspan="2" style="text-align: left">Action</th>
        </tr>
        <c:forEach items="${list}" var="p" varStatus="in">
            <tr>
                <td><c:out value="${in.count}"/></td>
                <td><c:out value="${p.getName()}"/></td>
                <td><c:out value="${p.getDob()}"/></td>
                <td><c:out value="${p.getAddress()}"/></td>
                <td><c:out value="${p.getPhoneNumber()}"/></td>
                <td><c:out value="${p.getClassroom().getClassName()}"/></td>
                <td>
                    <a class="btn btn-warning" href="student-servlet?action=update&&id=${p.getId()}">Update</a>
                    <button class="btn btn-danger"   onclick="myFunction(${p.getId()})">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    function myFunction(c) {
        if (confirm("Do you want to delete?")){
            window.location.href = "student-servlet?action=delete&&id=" + c
        }
        else {
            alert("Not delete!")
        }
    }
</script>
</html>

