package com.kodilla.testing.weather.mock;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    private List userNamesListGenerator(int usersQuanity){
        List<String> userNames = new LinkedList<>();
        for (int i=0; i<usersQuanity; i++){
            userNames.add("User" + i);
        }
        return  userNames;
    }


    @Mock
    private Statistics statisticsMock;

    @Test
    void testCalculateAdvStatistics() {

        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(20);
        int statsComments = 20;
        int statsPosts = 10;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(10,averageCommentsPerPost);
        Assertions.assertEquals(10,averageCommentsPerUser);
        Assertions.assertEquals(1,averagePostPerUser);
    }

    @Test
    void test0Posts() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(20);
        int statsComments = 20;
        int statsPosts = 0;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(0,averageCommentsPerPost);
        Assertions.assertEquals(1,averageCommentsPerUser);
        Assertions.assertEquals(0,averagePostPerUser);
    }

    @Test
    void test1000Posts() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(20);
        int statsComments = 20;
        int statsPosts = 1000;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(0.02,averageCommentsPerPost);
        Assertions.assertEquals(1,averageCommentsPerUser);
        Assertions.assertEquals(50,averagePostPerUser);
    }

    @Test
    void test0Comments() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(20);
        int statsComments = 0;
        int statsPosts = 20;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(0,averageCommentsPerPost);
        Assertions.assertEquals(0,averageCommentsPerUser);
        Assertions.assertEquals(1,averagePostPerUser);
    }

    @Test
    void testLessCommentsThanPosts() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames = userNamesListGenerator(2);
        int statsComments = 1;
        int statsPosts = 2;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(0.5,averageCommentsPerPost);
        Assertions.assertEquals(0.5,averageCommentsPerUser);
        Assertions.assertEquals(1,averagePostPerUser);
    }

    @Test
    void testMoreCommentsThanPosts() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(2);
        int statsComments = 2;
        int statsPosts = 1;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(2,averageCommentsPerPost);
        Assertions.assertEquals(1,averageCommentsPerUser);
        Assertions.assertEquals(0.5,averagePostPerUser);
    }

    @Test
    void test0Users() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(0);
        int statsComments = 1;
        int statsPosts = 1;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(1,averageCommentsPerPost);
        Assertions.assertEquals(0,averageCommentsPerUser);
        Assertions.assertEquals(0,averagePostPerUser);
    }

    @Test
    void test100Users() {
        StatisticsCalculator statistics = new StatisticsCalculator(statisticsMock);

        //Given
        List<String> userNames =userNamesListGenerator(100);
        int statsComments = 2;
        int statsPosts = 2;

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(statsComments);
        when(statisticsMock.postsCount()).thenReturn(statsPosts);

        //When
        statistics.calculateAdvStatistics();
        double averageCommentsPerPost = statistics.getAverageCommentsPerPost();
        double averageCommentsPerUser = statistics.getAverageCommentsPerUser();
        double averagePostPerUser = statistics.getAveragePostPerUser();


        //Then
        Assertions.assertEquals(1,averageCommentsPerPost);
        Assertions.assertEquals(0.02,averageCommentsPerUser);
        Assertions.assertEquals(0.02,averagePostPerUser);
    }
}
