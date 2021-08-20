package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;


    public void calculateAdvStatistics(Statistics statistics){
        this.usersQuantity = statistics.usersNames().size();
        this.postsQuantity = statistics.postsCount();
        this.commentsQuantity = statistics.commentsCount();
        if (usersQuantity==0) {
            this.averagePostPerUser = 0;
            this.averageCommentsPerUser = 0;
        } else {
            this.averagePostPerUser = ((double) postsQuantity / usersQuantity);
            this.averageCommentsPerUser = ((double) commentsQuantity / usersQuantity);
        }
        if (postsQuantity==0) {
            this.averageCommentsPerPost = 0;
        } else {
            this.averageCommentsPerPost = ((double) commentsQuantity / postsQuantity);
        }
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
