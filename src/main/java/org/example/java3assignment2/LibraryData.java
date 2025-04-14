package org.example.java3assignment2;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "libraryDataServlet", value = "/library-servlet")
public class LibraryData extends HttpServlet {

    BookDatabaseManager dbm = new BookDatabaseManager();

    private void printBackToMainPageLink(PrintWriter out) {
        out.println("<p>");
        out.println("<a href=\"index.jsp\">Back to Main Page</a>");
        out.println("</p>");
    }
    // Override doPost
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String submissionType = request.getParameter("submissionType");

        if ("book".equals(submissionType)) {
            String isbn = request.getParameter("ISBN");
            String title = request.getParameter("title");
            String editionNumberStr = request.getParameter("editionNumber");
            String copyrightYear = request.getParameter("copyright");
            String authorIdStr = request.getParameter("authorID");


            int editionNumber = 0;
            try {
                editionNumber = Integer.parseInt(editionNumberStr);
            } catch (NumberFormatException e) {
                // Handle the error if the edition number is not a valid integer
                out.println("Edition Number is not a number");
                return;
            }
            int authorId = 0;
            try {
                authorId = Integer.parseInt(authorIdStr);
            } catch (NumberFormatException e) {
                out.println("Author Id is not a number");
                return;
            }

            // Build ArrayList Of author Ids
            ArrayList<Integer> authorIdList = new ArrayList<>();
            authorIdList.add(authorId);

            // Add book and update relationship
            dbm.sendNewBookToDatabase(isbn, title, editionNumber, copyrightYear, authorIdList, out);


        } else if ("author".equals(submissionType)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Add author
            dbm.sendNewAuthorToDatabase(firstName, lastName, out);
        }
    }

    // Override doGet
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String view = request.getParameter("view");
        if (view.equals("books")) {
            dbm.printAllBooks(out);
            printBackToMainPageLink(out);
        } else if (view.equals("authors")) {
            dbm.printAllAuthors(out);
            printBackToMainPageLink(out);
        }
    }

    public void destroy() {
    }
}
