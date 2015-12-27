<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/app/css/styles.css">
    <style>
        input.inputError {
            background-color: red;
            color: white;
        }

        div.inputError input {
            background-color: red;
            color: white;
        }

        [class$="error"], [id$="errors"] {
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="sampleForm">
    <div>
        <form:input path="name" cssErrorClass="inputError" placeholder="Name"/><form:errors path="name"/>
    </div>
    <spring:bind path="dateOfBirth">
        <div class="${status.error ? 'inputError' : ''}">
            <div>
                Date Of Birth : ${dateOfBirth}
                <form:errors path="dateOfBirth"/>
            </div>
            <div>
                <form:input path="dateOfBirth.year" cssErrorClass="inputError" placeholder="Year"/>
                <form:errors path="dateOfBirth.year"/>
            </div>
            <div>
                <form:input path="dateOfBirth.month" cssErrorClass="inputError" placeholder="Month"/>
                <form:errors path="dateOfBirth.month"/>
            </div>
            <div>
                <form:input path="dateOfBirth.day" cssErrorClass="inputError" placeholder="Day"/>
                <form:errors path="dateOfBirth.day"/>
            </div>
        </div>
    </spring:bind>
    <spring:bind path="dateOfJoin">
        <div class="${status.error ? 'inputError' : ''}">
            <div>
                Date Of Join : ${dateOfJoin}
                <form:errors path="dateOfJoin"/>
            </div>
            <div>
                <form:input path="dateOfJoin.year" cssErrorClass="inputError" placeholder="Year"/>
                <form:errors path="dateOfJoin.year"/>
            </div>
            <div>
                <form:input path="dateOfJoin.month" cssErrorClass="inputError" placeholder="Month"/>
                <form:errors path="dateOfJoin.month"/>
            </div>
            <div>
                <form:input path="dateOfJoin.day" cssErrorClass="inputError" placeholder="Day"/>
                <form:errors path="dateOfJoin.day"/>
            </div>
        </div>
    </spring:bind>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
