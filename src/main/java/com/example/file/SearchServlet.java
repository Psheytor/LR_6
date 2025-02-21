package com.example.file;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String keyword = req.getParameter("keyword");
        System.out.println("Keyword: '" + keyword + "'");

        if (keyword == null || keyword.isEmpty()) {
            resp.getWriter().write("Please enter a word to search.");
            return;
        }

        int count = countOccurrencesInFile(keyword);
        if (count > 0) {
            resp.getWriter().write("The word '" + keyword + "' was found " + count + " time(s) in the file.");
        } else {
            resp.getWriter().write("The word '" + keyword + "' was not found in the file.");
        }
    }

    private int countOccurrencesInFile(String keyword) {
        String filePath = getServletContext().getRealPath("/WEB-INF/files/Entry-3.txt");
        System.out.println("File path: " + filePath);

        int count = 0;

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            System.out.println("File content: " + lines);

            String lowerKeyword = keyword.toLowerCase();
            for (String line : lines) {
                String lowerLine = line.toLowerCase();
                System.out.println("Searching in line: " + line);

                int index = 0;
                while ((index = lowerLine.indexOf(lowerKeyword, index)) != -1) {
                    count++;
                    index += lowerKeyword.length(); //перемещаем индекс вперед
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }
}