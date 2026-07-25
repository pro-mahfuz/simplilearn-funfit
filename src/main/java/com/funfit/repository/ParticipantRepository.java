package com.funfit.repository;


import java.util.List;

import com.funfit.dao.ParticipantDAO;
import com.funfit.model.Participant;


public class ParticipantRepository {


    private static ParticipantDAO dao =
            new ParticipantDAO();



    public static boolean save(Participant p)
            throws Exception {

        return dao.save(p);

    }



    public static List<Participant> findAll()
            throws Exception {

        return dao.findAll();

    }



    public static Participant findById(int id)
            throws Exception {

        return dao.findById(id);

    }



    public static boolean update(Participant p)
            throws Exception {

        return dao.update(p);

    }



    public static boolean delete(int id)
            throws Exception {

        return dao.delete(id);

    }


}