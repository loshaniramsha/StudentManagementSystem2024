package org.example.studentmanagementsystem2024;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet(urlPatterns = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo:Save student
        if (!req.getContentType().startsWith("application/json")) {
            resp.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }


    /*    BufferedReader reader=req.getReader();
        StringBuilder sb=new StringBuilder();
        var writer=resp.getWriter();
        reader.lines().forEach(line->sb.append(line+"\n"));
        System.out.println(sb);
        writer.write(sb.toString());
        writer.close();*/


        // JSON mainpulate with parson
        JsonReader reader= Json.createReader(req.getReader());
        var jArray =reader.readArray();
        for (int i=0;i<jArray.size();i++){
            JsonObject jsonObject=jArray.getJsonObject(i);
            System.out.println(jsonObject.getString("name"));

        }

        /*object*/
     /*   JsonObject jsonObject=reader.readObject();*/
     /*   System.out.println(jsonObject.getString("email"));*/

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
