 

# Source of the code
The nature of code in chapter 7: the game of life.

# modify species
             change one species to three species —— prey, predator,disease.
             The color is prey(0,255,0),triangle
             predator(0,0,255),circle
             disease(255,0,0),square
             infected prey(255,255,0),triangle
             infected predator(255,0,255),circle
             dead prey(255) square
             dead predator(255) square
# modify rules
             1.Loneliness:
             when there are only one prey/infected prey around the prey/infected prey itself,it will die
             2.Overpopulation
             when there are more than 3 prey around the prey itself,it will die
             when there are more than 2 infected prey/prey around the infected prey,it will die
             3.Prey reproduction
             when the prey is dead, and there are 3 prey around the dead prey, the prey will reproduce.
             when the predator is dead, and there are 3 food(prey) around the dead predator, the prey will reproduce
             4.Be eaten
             when the number of predators/infected predators is larger than the number of prey/infected prey in 3*3 squares, the prey will be eaten
             5.Prey be infected by prey
             when ther are infected prey around the prey. the prey will also be infected.
             6.Predator be infected by predator
             when there are infected predator around the predator. the predator will also be infected.
             7.Hungry to death
             when the food(prey) is less than the competitor(the predator), the predator will die.
             when the food(prey) is less than 2* #competitor(the predator),the predator will die.
             8.Predator be infected by food chain.
             when the predator eats the infected prey, it will be infected.
             9.Predator born
             when the predator is dead, and there are 2 competitors(predators) and more than 3 food, it will born.
             10.Death of disease
             when there are no alive prey/infected prey, predator/infected predator exists, the disease will die because of no host.
             11.otherwise
             it will keep the same statue.

# generate.
             there are around 5% to generate disease.
             there are around 35% to generate dead prey
             there are around 20% to generate dead predator
             there are around 15% to generate alive predator
             there are around 25% to generate alive prey

# how to run this code.
             using processing to open the Gameoflife.pde

#additions
             bio:
             set different species, to consist of a echosphere. 
             prey will be eated by predator and die because of loneliness or overcrowed.
                          will reproduce if there are parents.
             predator will become die when there arent enough food.
                          will born if there are food and parents.
             disease will infect the species
                          make them to require more food and space.
                          will die when it doesn't have a host.
             tech：
             use loops to instead the method to find the surround species one by one.
             but when the surround specie is same as the center itself, the num must minus one.
             The nature is to draw pictures one by one, thus it looks like the species are moving.
             Use different marks to represent the different specise.
             Use the scatter plot to show the change of species numbers.

    

