<%@ page import="java.util.List" %>
<%@ page import="com.funfit.model.Batch" %>


<html>

<body>


<h2>
Zumba Batches
</h2>


<table border="1">


<tr>

<th>ID</th>
<th>Name</th>
<th>Time</th>
<th>Instructor</th>
<th>Delete</th>

</tr>



<%

List<Batch> list =
(List<Batch>)request.getAttribute("batches");


if(list!=null){


for(Batch b:list){


%>


<tr>


<td>
<%=b.getBatchId()%>
</td>


<td>
<%=b.getBatchName()%>
</td>


<td>
<%=b.getBatchTime()%>
</td>


<td>
<%=b.getInstructor()%>
</td>


<td>

<a href="batch?action=delete&id=<%=b.getBatchId()%>">

Delete

</a>


</td>


</tr>


<%

}

}

%>


</table>


</body>

</html>