# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
    I kept my design fairly simple with five classes: Person, Camper, Nurse, HealthCenter, and Game. Camper and Nurse are both child classes of a superclass Person, which includes basic attributes (ex. name) and methods (ex. enter/exit) that all people in the game need. 
    The Nurse class was able to interact with the Health Center class through the buy method and checking inventory/the supply store. The Nurse can also interact with the Camper in order to figure out what's wrong and to treat them.
    The Camper class housed most of the storyline, making use of the Random class to generate random levels of severity and primary complaints, allowing every user to have a slightly different experience.
    I also had a Health Center class whose main job was to house the inventory and Supply Store for the Nurse to look at. I used Hashtable for both of these because it allowed me to have two values for each item (item name and either price or number in stock).
    The Game class was where I put everything together to run. This is where I made most use of Scanner to take in user input and implement methods from various classes based on what the user asks for.

    I was originally considering an alternative design that involved movement throughout different areas of the camp. This would have included some sort of Random walkie talkie calls as well. I decided against this because of the added complexity of a Location superclass with many child classes and the difficulty I was having determining where to house and implement a walkie. Given the time and energy I had to spend on this project, I decided to scale back, though I would love to experiment with Guava in a future project.

 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?


 - What **new thing(s)** did you learn / figure out in completing this project?
    Random, Hashtable, Scanner

 - Is there anything that you wish you had **implemented differently**?
    I wish I had move more of what's under TREAT in play() in the Game class to the treat() method in Nurse. Most of what I wanted in treat() wound up in play() in Game because of how accessing things (mostly appropriateTreatment from what I remember) was working.

    I also wish I had made it possible to treat a camper with multiple items (ex. ibuprofen and ACE bandage OR alcohol wipe and bandaid).

 - If you had **unlimited time**, what additional features would you implement?
    With unlimited time, I would have added movement around areas in camp, with the Nurse having to respond to calls from a walkie. I also would have had mini-challenges and perhaps special campers (my friend and I were joking around about a camper whose malady is actually being a werewolf) that the user would have to respond to.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
    During one of the demos/feedback workshops, someone I sat next to gave me really good advice about how to implement the Scanner and gave me the idea for a play() method, which became extremely helpful and helped to alleviate a lot of the stress I was having about how to implement that part. I unfortunately don't remember their name.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
    Simplify it early. I got very overwhelmed at the beginning of the project because of everything I thought it entailed. Another hint would be to learn from others and use similar methods to them. I would also have had friends play it earlier on to catch more bugs and design flaws. 
