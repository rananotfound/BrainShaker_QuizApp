package com.ashutoshrana.brainshakerquizapp;

class Score {
    String correctAnswer,incorrectAnswer,score,percentage,totalQuestionAnswered;

    public String getCorrectAnswer() {

        return correctAnswer;
    }

    public String getIncorrectAnswer() {

        return incorrectAnswer;
    }

    public String getScore() {

        return score;
    }

    public String getPercentage() {

        return percentage;
    }

    public String getTotalQuestionAnswered() {

        return totalQuestionAnswered;
    }

    public Score(String correctAnswer,String incorrectAnswer, String score, String percentage, String totalQuestionAnswered) {
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.score = score;
        this.percentage = percentage;
        this.totalQuestionAnswered = totalQuestionAnswered;

    }
}
