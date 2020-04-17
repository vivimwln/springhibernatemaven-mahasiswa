<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Daftar Mahasiswa</title>

    <style type="text/css">
        h1 {
            font-family: sans-serif;
            border-bottom: 3px solid #abcae8;
            color: #4d7ba7;
        }

        #table {
            border-collapse: collapse;
            color: #4d7ba7;
            font-family: arial;
        }

        #table th {
            padding: 10px;
            border-bottom: 2px solid #4d7ba7;
            text-transform: uppercase;
            font-weight: bold;
        }

        #table td {
            padding: 10px;
            border-bottom: 1px solid #4d7ba7;
            padding-right: 25px;
        }

        #table a {
            text-decoration: none;
            color: #4d7ba7;
        }

        #buttonTambah {
            margin-bottom: 10px;
        }

        #buttonTambah a {
            text-decoration: none;
            color: #ffffff;
            font-family: arial;
            background: #abcae8;
            border: 1px solid antiquewhite;
            padding: 5px;
            border-radius: 8px;
        }
    </style>
</head>

<body>
    <h1>Anggota</h1>
    <div id="buttonTambah">
        <a href="${pageContext.request.contextPath}/tambah">Tambah</a>
    </div>

    <table id="table">
        <thead>
            <tr>
                <th>id</th>
                <th>NIM</th>
                <th>Nama</th>
                <th>Alamat</th>
                <th>Opsi</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${mahasiswas}" var="mahasiswa">
                <tr>
                    <td>
                        <c:out value="${mahasiswa.id}" />
                    </td>
                    <td>
                        <c:out value="${mahasiswa.NIM}" />
                    </td>
                    <td>
                        <c:out value="${mahasiswa.Nama}" />
                    </td>
                    <td>
                        <c:out value="${mahasiswa.Alamat}" />
                    </td>
                    <td><a href="${pageContext.request.contextPath}/edit/${mahasiswa.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/delete/${mahasiswa.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>

</html>