package com.alex.algorithm.Session7.btvn;

import com.alex.algorithm.NumberUtil;

import java.util.*;

public class Bai_RoyAndTrendingTopics {

    private static PriorityQueue<Topic> queue = new PriorityQueue<>();

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int numberOfTopic = Integer.valueOf(scanner.nextLine());

        //read Input
        for (int i = 0; i < numberOfTopic; i++) {
            final List<Integer> eachLine = NumberUtil.convertByString(scanner.nextLine());
            final Topic topic = new Topic(eachLine.get(0), eachLine.get(1), eachLine.get(2), eachLine.get(3),
                    eachLine.get(4), eachLine.get(5));

            queue.add(topic);
        }

        //get 5 topic which has max changes score and sorted by topic id
        for (int i = 0; i < 5; i++) {
            final Topic highTopic = queue.peek();
            System.out.println(highTopic);

            queue.remove();
        }

    }

    static class Topic implements Comparable {
        private Integer topicId;
        private int oldScore;
        private int newScore;
        private Integer changeScore;

        private int numOfPosts;
        private int numOfLikes;
        private int numOfComments;
        private int numOfShares;


        public Topic(int topicId, int currentScore, int numOfPosts, int numOfLikes, int numOfComments, int numOfShares) {
            this.topicId = topicId;
            this.numOfPosts = numOfPosts;
            this.numOfLikes = numOfLikes;
            this.numOfComments = numOfComments;
            this.numOfShares = numOfShares;

            this.oldScore = currentScore;
            this.changeScore = calculateChangeScore();
            this.newScore = oldScore + changeScore;
        }

        private int calculateChangeScore() {
            return (numOfPosts * 50) + (numOfLikes * 5) + (numOfComments * 10) + (numOfShares * 20);
        }

        @Override
        public int compareTo(Object obj) {
            final Topic otherTopic = (Topic) obj;
            if (this.changeScore == otherTopic.changeScore) {
                return otherTopic.topicId.compareTo(this.topicId);
            }
            return otherTopic.getChangeScore().compareTo(this.changeScore);
        }

        public int getTopicId() {
            return topicId;
        }

        public Integer getChangeScore() {
            return changeScore;
        }

        public int getNewScore() {
            return newScore;
        }

        @Override
        public String toString() {
            return "Topic{" +
                    "topicId=" + topicId +
                    ", newScore=" + newScore +
                    '}';
        }
    }
}
