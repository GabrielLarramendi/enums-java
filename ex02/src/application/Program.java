package application;

import entities.Comment;
import entities.Post;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter dateAndTimeFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Comment comment01 = new Comment("Have a nice trip!");
        Comment comment02 = new Comment("Wow that's awesome!");

        Post post01 = new Post(LocalDateTime.parse("30/08/2022 10:31:05", dateAndTimeFormatted), "Traveling to Maceió", "I'm going to visit this wonderful city!", 13);
        post01.addComment(comment01);
        post01.addComment(comment02);

        Comment comment03 = new Comment("Good Night!");
        Comment comment04 = new Comment("May the force be with you!");

        Post post02 = new Post(LocalDateTime.parse("13/03/2022 13:13:13", dateAndTimeFormatted), "Good Night!", "See you!", 10);
        post02.addComment(comment03);
        post02.addComment(comment04);

        System.out.println(post01);
        System.out.println(post02);

    }


}
