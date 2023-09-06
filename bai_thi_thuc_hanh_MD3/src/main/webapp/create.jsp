
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1 style="text-align: center">Create Student</h1>
    <form style="width: 500px; margin: auto"
          action="student-servlet?action=create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control"
                   id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Date of birth</label>
            <input type="date" class="form-control"
                   id="dob" name="dob" required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control"
                   id="address" name="address" required>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control"
                   id="phone" name="phone" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control"
                   id="email" name="email" required>
        </div>

        <label class="form-label">Classroom</label>
        <select name="class" class="form-select" aria-label="Default select example">
            <option selected>Select Classroom</option>
            <c:forEach items="${listC}" var="c">
                <option value="${c.getId()}">
                    <c:out value="${c.getClassName()}"/>
                </option>
            </c:forEach>
        </select>
        <br>
        <button class="btn btn-success" type="submit">Create</button>
        <button class="btn btn-secondary" type="reset">Reset</button>
        <a class="btn btn-info" href="student-servlet">Back to list</a>

    </form>

</div>
</body>
</html>

