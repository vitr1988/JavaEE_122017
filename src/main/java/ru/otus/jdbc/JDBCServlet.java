package ru.otus.jdbc;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {

    @Resource(mappedName = "jdbc/OracleDS")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from emp");
             ResultSet resultSet = ps.executeQuery()){

            StringBuilder sb = new StringBuilder();
            while(resultSet.next()){
                sb.append(
                    Stream.of(
                        resultSet.getString("ename"),
                        resultSet.getString("job")
                    ).collect(Collectors.joining("|"))
                );
            }
            try (PrintWriter pw = response.getWriter()) {
                pw.println(sb.toString());
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
