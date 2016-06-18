![alt text](http://cdn0.agoda.net/images/MVC/default/logo-agoda-mobile@2X.png "agoda")

Programming Exercise
===================

Congratulations, you have passed the first phase of our interview. 

On this second phase we are going to test your programming skills, so we have a exercise template writen in Java that you will need to complete. (you could easily change to a language of your preference)

Follow the instructions of the exam below, and produce the given results in any language of your preference. 

The solution should be complete and production ready. Please do not write just the core code algorithm, leaving out e.g. error handling.
Your code should be covered by unit tests.
Feel free to use any kind of unit test framework

The solution will be evaluated on following
parameters.
Object Oriented Design aspects of the solution.
Overall coding practices.
Working test cases of the solution.

You can use any build tool for the solution, and any of the existing test frameworks.
You may also include a brief explanation of your design and assumptions along with your code.

In a Formula-1 challenge, there are n teams numbered 1 to n. Each team has a car and a driver.

Car's specification are as follows:
- Top speed: (150 + 10 * i) km per hour
- Acceleration: (2 * i) meter per second square.
- Handling factor (hf) = 0.8
- Nitro : Increases the speed to double or top speed, whichever is less. Can be used only once.

Here i is the team number.

The cars line up for the race. The start line for (i + 1)th car is 200 * i meters behind the ith car.
All of them start at the same time and try to attain their top speed. A re-assessment of the positions is done every 2 seconds(So even if the car has crossed the finish line in between, you'll get to know after 2 seconds). During this assessment, each driver checks if there is any car within 10 meters of his car, his speed reduces to: hf * (speed at that moment). Also, if the driver notices that he is the last one on the race, he uses 'nitro'.

Taking the number of teams and length of track as the input, Calculate the final speeds and the corresponding completion times.

Solution comments
=================

To run application use main class FormulaOneMain and provide required parameters
-n - number of teams
-lm - length of track in meters

ex. -n 10 -lm 1000

Every two seconds all racing team are going through chain of specific Assessments in specific order

SpeedAndPositionAssessment - increase speed and calculate new position. Most tricky part here is the case when car ahs reached max speed.
    As example at t0 car speed is 10 m/s and acceleration 2 m/s. Max speed is 11 m/s. location 0
    After 2 second it's clear that speed will be 11 m/s bbut what is location? I'm using this approach to calculate it.
        timeToMaxSpeed = (maxSpeed - startSpeed)/acceleration = 0.5sec
        location = location + startSpeed*timeToMaxSpeed + acc*timeToMaxSpeed*timeToMaxSpeed/2 + maxSpeed*(2 second - timeToMaxSpeed) = 0 + 10*0.5 + 2*0.5*0.5/2 + 11*1.5 = 21.75

FinishingAssesment - checking if anyone crossed the finish line. remove tehm from list of participants and add to list of finished
HandlerAssessmnet - check is any car is close enough to any other car and reduce speed if so.
LastPositionAssessment - use nitro if last

When list of finished cars contains all teams - process stops and prints all result sorted by finished time.


Good luck!

<br />

All material herein © 2005 – 2014 Agoda Company Pte. Ltd., All Rights Reserved.<br />
AGODA ® is a registered trademark of AGIP LLC, used under license by Agoda Company Pte. Ltd.<br />
Agoda is part ofPriceline (NASDAQ:PCLN)<br />

