package com.funfit.repository;


import java.util.List;

import com.funfit.dao.BatchDAO;
import com.funfit.model.Batch;


public class BatchRepository {


    private static BatchDAO dao =
            new BatchDAO();



    public static boolean save(Batch b)
            throws Exception {

        return dao.save(b);

    }



    public static List<Batch> findAll()
            throws Exception {

        return dao.findAll();

    }



    public static boolean update(Batch b)
            throws Exception {

        return dao.update(b);

    }



    public static boolean delete(int id)
            throws Exception {

        return dao.delete(id);

    }


}