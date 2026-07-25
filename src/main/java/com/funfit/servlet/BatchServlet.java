package com.funfit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.model.Batch;
import com.funfit.repository.BatchRepository;


public class BatchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {


        try {


            String action =
                    request.getParameter("action");



            // Delete from link

            if ("delete".equals(action)) {


                int id =
                    Integer.parseInt(
                        request.getParameter("id")
                    );


                BatchRepository.delete(id);


                response.sendRedirect("batch");

                return;
            }



            List<Batch> batches =
                    BatchRepository.findAll();



            request.setAttribute(
                    "batches",
                    batches
            );



            request.getRequestDispatcher(
                    "/WEB-INF/jsp/batches.jsp"
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


            String id =
                    request.getParameter("id");



            Batch batch =
                    new Batch();



            batch.setBatchName(
                    request.getParameter("batchName")
            );



            batch.setBatchTime(
                    request.getParameter("batchTime")
            );



            batch.setInstructor(
                    request.getParameter("instructor")
            );




            // UPDATE

            if(id != null && !id.isEmpty()) {


                batch.setBatchId(
                    Integer.parseInt(id)
                );


                BatchRepository.update(batch);


            }

            // INSERT

            else {


                BatchRepository.save(batch);


            }



            response.sendRedirect("batch");



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


        try {


            int id =
                Integer.parseInt(
                    request.getParameter("id")
                );



            BatchRepository.delete(id);



            response.setContentType(
                    "text/plain"
            );


            response.getWriter()
                    .print("Batch Deleted");



        }
        catch(Exception e){


            response.setStatus(500);


            response.getWriter()
                    .print(e.getMessage());

        }


    }






    @Override
    protected void doPut(
            HttpServletRequest request,
            HttpServletResponse response)

            throws IOException {



        response.setContentType(
                "text/plain"
        );


        response.getWriter()
                .print(
                "PUT request received"
                );

    }



}