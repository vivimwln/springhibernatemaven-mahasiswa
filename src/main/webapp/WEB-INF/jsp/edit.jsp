<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
    <style type="text/css">
        h1 {
            font-family: sans-serif;
            border-bottom: 3px solid #abcae8;
            color: #4d7ba7;
        }

        table {
            border: 2px solid #4d7ba7;
            color: #4d7ba7;
            font-family: arial;
            padding: 5px;
        }

        table td {
            padding: 5px;
            padding-bottom: 10px;
        }

        table input {
            border: 1px solid #4d7ba7;
            padding: 3px;
        }
    </style>
</head>

<body>
    <h1>Edit</h1>
    <form:form modelAttribute="mahasiswa" action="${pageContext.request.contextPath}/edit" method="post">
        <table>
            <form:hidden path="id" />
            <tr>
                <td>NIM</td>
                <td>:</td>
                <td>
                    <form:input path="NIM" value="${mahasiswa.NIM}" />
                </td>
            </tr>
            <tr>
                <td>Nama</td>
                <td>:</td>
                <td>
                    <form:input path="Nama" value="${lagu.Nama}" />
                </td>
            </tr>
            <tr>
                <td>Alamat</td>
                <td>:</td>
                <td>
                    <form:input path="Alamat" value="${lagu.Alamat}" />
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Simpan" /></td>
            </tr>
        </table>
    </form:form>
</body>

</html>
