Feature: Photo

Scenario Outline: <arg1> photo
Given A user that wants to take a photo
When I take the photo
Then I <arg2> it


Examples:
|   arg1    |   arg2      |
|   Bad     |   cancel    |
|   Good    |   save      |   

