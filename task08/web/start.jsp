<%--
  Created by IntelliJ IDEA.
  User: kiril
  Date: 11.09.2021
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>XMLParsing</title>
    <link rel="stylesheet" href="assests/css/style.css">
</head>
<body>
<h1 class="heading">Task08: парсинг Xml документов</h1>
<div class="selecting">
    <form method="post" action="XMLParsing" enctype="multipart/form-data">
        <select name="parser">
            <option value="DOM">DOM</option>
            <option value="SAX">SAX</option>
            <option value="STAX">STAX</option>
        </select>
        <b class="text">Select file to upload:</b>
        <input class="file" type="file" name="file" size="60"/>
        <input class="upload" type="submit" value="Загрузить"/>
    </form>
</div>


</body>
</html>
