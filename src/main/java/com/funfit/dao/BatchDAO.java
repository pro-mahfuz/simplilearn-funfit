package com.funfit.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.funfit.model.Batch;



public class BatchDAO {



    // CREATE

    public boolean save(Batch batch)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "INSERT INTO batch" +
                "(batch_name,batch_time,instructor)" +
                " VALUES(?,?,?)"

                );



        ps.setString(1,
                batch.getBatchName());


        ps.setString(2,
                batch.getBatchTime());


        ps.setString(3,
                batch.getInstructor());



        return ps.executeUpdate()>0;

    }





    // READ ALL

    public List<Batch> findAll()
            throws Exception {


        List<Batch> list =
                new ArrayList<>();


        Connection con =
                DBConnection.getConnection();


        ResultSet rs =
                con.createStatement()
                .executeQuery(
                "SELECT * FROM batch"
                );



        while(rs.next()) {


            list.add(

            new Batch(

            rs.getInt("batch_id"),

            rs.getString("batch_name"),

            rs.getString("batch_time"),

            rs.getString("instructor")

            )


            );


        }


        return list;

    }





    // UPDATE

    public boolean update(Batch batch)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "UPDATE batch SET " +

                "batch_name=?,"+

                "batch_time=?,"+

                "instructor=? "+

                "WHERE batch_id=?"

                );



        ps.setString(1,
                batch.getBatchName());


        ps.setString(2,
                batch.getBatchTime());


        ps.setString(3,
                batch.getInstructor());


        ps.setInt(4,
                batch.getBatchId());



        return ps.executeUpdate()>0;

    }





    // DELETE

    public boolean delete(int id)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "DELETE FROM batch " +
                "WHERE batch_id=?"

                );



        ps.setInt(1,id);



        return ps.executeUpdate()>0;

    }


}