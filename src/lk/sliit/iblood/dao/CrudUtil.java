/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.dao;


import lk.sliit.iblood.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CrudUtil {

    private static PreparedStatement getPreparedStatement(String sql, Object... params) throws Exception {

        int paramsCount = questionMark(sql);
        if (paramsCount != params.length) {
            System.out.println(params.length);
            System.out.println(paramsCount);
            throw new RuntimeException("Parameters count is mismatched");
        }

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1,
                    params[i] instanceof String ?
                            ((String)(params[i])).trim() :
                            params[i]
            );
        }

        return pstm;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeQuery();
    }

    public static int executeUpdate(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeUpdate();
    }

    private static int questionMark(String sql) {
        int count = 0;
        for (int i = 0; i < sql.length(); i++) {
            if (sql.charAt(i) == '?')
                count++;
        }
        return count;
    }
}
