package com.funfit.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.funfit.model.Participant;
import com.funfit.repository.ParticipantRepository;



public class ParticipantServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

		try {
		
		
			String action =
			request.getParameter("action");
		
		
		
			if("delete".equals(action)){
			
			
			int id =
			Integer.parseInt(
			request.getParameter("id")
			);
			
			
			ParticipantRepository.delete(id);
			
			
			response.sendRedirect(
			"participant"
			);
		
		
			return;
	
		}
	
	
	
	
		List<Participant> participants =
		ParticipantRepository.findAll();
		
		
		
		request.setAttribute(
		"participants",
		participants
		);
		
		
		
		request.getRequestDispatcher(
		"/WEB-INF/jsp/participants.jsp"
		)
		.forward(request,response);
		
		
		
		}
		catch(Exception e){
		
		throw new ServletException(e);
		
		}
	
	}







@Override
protected void doPost(
HttpServletRequest request,
HttpServletResponse response)

throws ServletException, IOException {



try {


Participant p =
new Participant();


p.setName(
request.getParameter("name")
);



p.setAge(
Integer.parseInt(
request.getParameter("age")
)
);



p.setGender(
request.getParameter("gender")
);



p.setPhone(
request.getParameter("phone")
);



p.setBatchId(
Integer.parseInt(
request.getParameter("batchId")
)
);



ParticipantRepository.save(p);



response.sendRedirect(
"participant"
);



}
catch(Exception e){

throw new ServletException(e);

}



}







@Override
protected void doPut(
HttpServletRequest request,
HttpServletResponse response)

throws ServletException, IOException {


try {


Participant p =
new Participant();


p.setParticipantId(
Integer.parseInt(
request.getParameter("id")
)
);



p.setName(
request.getParameter("name")
);



p.setAge(
Integer.parseInt(
request.getParameter("age")
)
);



p.setGender(
request.getParameter("gender")
);



p.setPhone(
request.getParameter("phone")
);



p.setBatchId(
Integer.parseInt(
request.getParameter("batchId")
)
);



ParticipantRepository.update(p);



response.getWriter()
.print("Participant Updated");


}
catch(Exception e){

throw new ServletException(e);

}


}



@Override
protected void doDelete(
HttpServletRequest request,
HttpServletResponse response)

throws IOException {


try{


int id =
Integer.parseInt(
request.getParameter("id")
);


ParticipantRepository.delete(id);


response.getWriter()
.print("Deleted");


}
catch(Exception e){

response.getWriter()
.print(e.getMessage());

}


}



}