package org.example.java3assignment2;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "libraryDataServlet", value = "/library-servlet")
public class LibraryData extends HttpServlet {

    // Override doPost
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

    // Override doGet
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

    public void destroy() {
    }
}
