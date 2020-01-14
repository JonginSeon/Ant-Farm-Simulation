# Ant-Farm-Simulation
CIS350 Project
This was a project for CIS 350: "Intro to Software Engineering" at Grand Valley State University. It uses a JavaFX gui to create an ant
farm simulation with some game-like elements. 

After pressing the "start" menu button, the "queen ant", represented by a pink square, digs down into the ground until she reaches a certain 
depth and then clears a small area, the "nest". Once this is complete, the user can open the "store" menu to purchase aditional ants that spawn 
near the queen and dig in various patterns depending on their type. Purchasing ants from the store costs "food" points, which are restored
when any ant goes into a green "food square". Each food square restores one food point, and food squares will constantly spawn randomly
at certain depths, allowing for potentially an infinite amount of food. Using the "info" menu will show how much food the user currently has.

There is no way to control the actions of the ants after their creation. Furthermore, only 10 ants including the queen may be present on 
the screen at once. Attempting to buy an eleventh ant will yield a pop-up message reminding the user of this restriction. The simulation
continues indefinetly until the user exits by closing the window or uses the "exit" menu button. The current progress of the simulation can
also be "paused" and then "saved" using the respective menu buttons, or it can be reset to the intial queen stage using the "reset" button.
