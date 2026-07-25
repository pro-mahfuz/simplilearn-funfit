package com.funfit.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.funfit.model.Participant;



public class ParticipantDAO {



    // CREATE

    public boolean save(Participant participant)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "INSERT INTO participant" +
                "(name,age,gender,phone,batch_id)" +
                " VALUES(?,?,?,?,?)"

                );



        ps.setString(1,
                participant.getName());


        ps.setInt(2,
                participant.getAge());


        ps.setString(3,
                participant.getGender());


        ps.setString(4,
                participant.getPhone());


        ps.setInt(5,
                participant.getBatchId());



        return ps.executeUpdate() > 0;

    }





    // READ ALL

    public List<Participant> findAll()
            throws Exception {


        List<Participant> list =
                new ArrayList<>();


        Connection con =
                DBConnection.getConnection();



        Statement st =
                con.createStatement();



        ResultSet rs =
                st.executeQuery(

                "SELECT * FROM participant"

                );



        while(rs.next()) {


            Participant p =
                    new Participant();


            p.setParticipantId(
                    rs.getInt("participant_id"));


            p.setName(
                    rs.getString("name"));


            p.setAge(
                    rs.getInt("age"));


            p.setGender(
                    rs.getString("gender"));


            p.setPhone(
                    rs.getString("phone"));


            p.setBatchId(
                    rs.getInt("batch_id"));



            list.add(p);

        }


        return list;

    }





    // READ BY ID

    public Participant findById(int id)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "SELECT * FROM participant " +
                "WHERE participant_id=?"

                );



        ps.setInt(1,id);



        ResultSet rs =
                ps.executeQuery();



        if(rs.next()) {


            return new Participant(

            rs.getInt("participant_id"),

            rs.getString("name"),

            rs.getInt("age"),

            rs.getString("gender"),

            rs.getString("phone"),

            rs.getInt("batch_id")

            );

        }


        return null;

    }





    // UPDATE

    public boolean update(Participant p)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "UPDATE participant SET " +

                "name=?," +

                "age=?," +

                "gender=?," +

                "phone=?," +

                "batch_id=? " +

                "WHERE participant_id=?"

                );



        ps.setString(1,p.getName());

        ps.setInt(2,p.getAge());

        ps.setString(3,p.getGender());

        ps.setString(4,p.getPhone());

        ps.setInt(5,p.getBatchId());

        ps.setInt(6,p.getParticipantId());



        return ps.executeUpdate()>0;


    }





    // DELETE

    public boolean delete(int id)
            throws Exception {


        Connection con =
                DBConnection.getConnection();



        PreparedStatement ps =
                con.prepareStatement(

                "DELETE FROM participant " +
                "WHERE participant_id=?"

                );



        ps.setInt(1,id);



        return ps.executeUpdate()>0;


    }


}