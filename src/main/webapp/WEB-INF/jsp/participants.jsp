<%@ page import="java.util.List" %>
<%@ page import="com.funfit.model.Participant" %>


<html>

<body>


<h2>
Participant List
</h2>


<table border="1">


<tr>

<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Phone</th>
<th>Batch</th>
<th>Delete</th>

</tr>



<%

List<Participant> list =
(List<Participant>)request.getAttribute("participants");


if(list!=null){


for(Participant p:list){


%>


<tr>


<td>
<%=p.getParticipantId()%>
</td>


<td>
<%=p.getName()%>
</td>


<td>
<%=p.getAge()%>
</td>


<td>
<%=p.getGender()%>
</td>


<td>
<%=p.getPhone()%>
</td>


<td>
<%=p.getBatchId()%>
</td>


<td>

<a href="participant?action=delete&id=<%=p.getParticipantId()%>">

Delete

</a>


</td>


</tr>


<%


}

}


%>



</table>


<br>


<a href="../../index.html">
Home
</a>


</body>

</html>