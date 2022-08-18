<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<h2>Quiz</h2>


<form method="post" action="${pageContext.request.contextPath}/submit">
<ol type="1">
    <c:forEach var="question"  items="${questions}">
        <li>${question.context}
            <input type="hidden" name="questionId" value="${question.id}">
            <ol type="a">
        <c:forEach var="answer"  items="${questions[0].answers}">
           <li>
               <input type="radio" name="question_${question.id}" value="${answer.id}">

                   ${answer.context}</li>
        </c:forEach>
            </ol>

        </li>
    </c:forEach>
</ol>
    <input type="submit" value="Submit">

</form>
</body>
</html>