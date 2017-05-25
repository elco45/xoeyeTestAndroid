Feature: Video

Scenario Outline: <arg1> video
Given A user that wants to take a video
When I take the video
Then I can <arg2> the video


Examples:
|   arg1    |   arg2      |
|   Bad     |   cancel    |
|   Good    |   save      |   


